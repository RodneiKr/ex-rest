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
    public static final String DOC_INVALIDO = "Documento inválido.";

    protected List<D> responseGet(final List<D> list) {
        return Optional.ofNullable(list)
                .filter((f) -> ! f.isEmpty())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, GET_RESP_LIST));
    }

    protected D responseGet(final D doc) {
        return Optional.ofNullable(doc)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, GET_RESP));
    }

    protected D responsePost(final B bean, final D doc) {
        this.krJbValidate(bean);
        return doc;
    }

    protected D responsePut(final B bean, final D doc) {
        this.krJbValidate(bean);
        return doc;
    }

    private void krJbValidate(final B bean) {
        Optional.ofNullable(bean).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, DOC_INVALIDO));
        if (bean.hasError()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, bean.error().toString());
        }
    }
}
