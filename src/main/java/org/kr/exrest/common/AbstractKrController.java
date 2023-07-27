package org.kr.exrest.common;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public abstract class AbstractKrController<B extends KrError, D> {
    public static final String GET_RESP_LIST = "Lista VAZIA";
    public static final String GET_RESP = "Documento não encontrado";
    public static final String POST_RESP = "INSERt";
    public static final String PUT_RESP = "UPDATe";
    public static final String INVALIDO_0 = " INVÁLIDO.";
    public static final String INVALIDO_1 = " INVÁLIDO: ";

    protected List<D> res(final List<D> list) {
        return Optional.ofNullable(list)
                .filter((f) -> ! f.isEmpty())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, GET_RESP_LIST));
    }
    protected D res(final D doc) {
        return Optional.ofNullable(doc)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, GET_RESP));
    }
    protected D post(final B bean, final D doc) {
        this.krJbValidate(bean, POST_RESP);
        return doc;
    }
    protected D put(final B bean, final D doc) {
        this.krJbValidate(bean, PUT_RESP);
        return doc;
    }
    private void krJbValidate(final B bean, final String msg) {
        Optional.ofNullable(bean).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, msg + INVALIDO_0));
        Optional.of(! bean.error().isEmpty())
                .filter(f -> ! f)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, msg + INVALIDO_1 + bean.error()));
    }
}
