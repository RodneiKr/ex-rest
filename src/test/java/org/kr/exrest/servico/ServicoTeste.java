package org.kr.exrest.servico;

import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertTrue("Deveria ser FALSE\n"+ servico.error(), !servico.hasError());
    }

    @Test
    public void atributosIgualNull() {
        final Servico servico = new Servico().validate();
        Assert.assertTrue("deveria ter size() == 3\n"+ servico.error(), servico.error().size() == 3);
    }
    @Test
    public void atributosVazioOuZero() {
        final Servico servico = new Servico();
        servico.setNome("");
        servico.setDescricao("");
        servico.setValor(BigDecimal.ZERO);
        servico.validate();
        Assert.assertTrue("deveria ter size() == 3\n"+ servico.error(), servico.error().size() == 3);
    }
}
