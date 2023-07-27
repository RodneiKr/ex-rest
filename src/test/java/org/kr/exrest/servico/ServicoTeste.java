package org.kr.exrest.servico;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.math.BigDecimal;

public class ServicoTeste {
    @Test
    public void coberturaDeTesteParaToString() {
        new Servico().toString();
    }
    @Test
    public void atributosPreenchidosCorretamente() {
        final Servico servico = new Servico()
                .nome("bar man")
                .descricao("bebidas")
                .valor(BigDecimal.TEN)
                .validate();
        Assert.isTrue(!servico.hasError(),"Deveria ser FALSE\n"+ servico.error());
    }

    @Test
    public void atributosIgualNull() {
        final Servico servico = new Servico().validate();
        Assert.isTrue(servico.error().size() == 3, "deveria ter size() == 3\n"+ servico.error());
    }
    @Test
    public void atributosVazioOuZero() {
        final Servico servico = new Servico()
                .nome("")
                .descricao("")
                .valor(BigDecimal.ZERO)
                .validate();
        Assert.isTrue(servico.error().size() == 3, "deveria ter size() == 3\n"+ servico.error());
    }
}
