package org.kr.exrest.festa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kr.exrest.servico.Servico;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

//https://www.appsdeveloperblog.com/getting-started-with-mockito-mock-and-injectmocks/

@ExtendWith(MockitoExtension.class)
public class FestaServiceTeste {

    @InjectMocks
    private FestaService service;

    @Mock
    private FestaRepository repository;

    @Test
    public void deleteAll() {
        this.service.deleteAll();
    }

    @Test
    public void deleteById() {
        this.service.deleteById("123");
    }

    @Test
    public void getAll() {
        this.service.getAll();
    }

    @Test
    public void getById() {
        this.service.getById("123");
    }

    @Test
    public void post() {
        final Servico servico = new Servico();
        servico.setNome("nome");
        servico.setDescricao("descricao");
        servico.setValor(BigDecimal.TWO);

        final Festa festa = new Festa();
        festa.setAutor("autor");
        festa.setMotivo("motivo");
        festa.setData(LocalDate.now());
        festa.setOrcamento(BigDecimal.TEN);
        festa.setServicos(Arrays.asList(servico));

        this.service.post(festa);
    }

    @Test
    public void put() {
        this.service.put(new Festa(), "123");
    }
}
