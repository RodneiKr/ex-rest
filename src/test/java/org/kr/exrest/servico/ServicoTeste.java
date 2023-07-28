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
        final Servico servico = new Servico();
        servico.setNome("bar man");
        servico.setDescricao("bebidas");
        servico.setValor(BigDecimal.TEN);
        servico.validate();
        Assert.isTrue(!servico.hasError(),"Deveria ser FALSE\n"+ servico.error());
    }

    @Test
    public void atributosIgualNull() {
        final Servico servico = new Servico().validate();
        Assert.isTrue(servico.error().size() == 3, "deveria ter size() == 3\n"+ servico.error());
    }
    @Test
    public void atributosVazioOuZero() {
        final Servico servico = new Servico();
        servico.setNome("");
        servico.setDescricao("");
        servico.setValor(BigDecimal.ZERO);
        servico.validate();
        Assert.isTrue(servico.error().size() == 3, "deveria ter size() == 3\n"+ servico.error());
    }
}
