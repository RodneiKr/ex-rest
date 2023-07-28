package org.kr.exrest.festa;

import org.junit.Assert;
import org.junit.Test;
import org.kr.exrest.servico.Servico;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

public class FestaTeste {
    @Test
    public void coberturaDeTesteParaToString() {
        new Festa().toString();
    }
    @Test
    public void atributosPreenchidosCorretamente() {
        final Servico servico = new Servico();
        servico.setNome("crepe");
        servico.setDescricao("crepes salgados e doces");
        servico.setValor(BigDecimal.TWO);

        final Festa festa = new Festa();
        festa.setAutor("eu");
        festa.setMotivo("fim de ano");
        festa.setData(LocalDate.now());
        festa.setOrcamento(BigDecimal.TWO);
        festa.setServicos(Arrays.asList(servico));
        festa.validate();

        Assert.assertTrue("\n" + festa.error(),!festa.hasError());
    }
    @Test
    public void atributosIgualNull() {
        final Servico servico = new Servico().validate();
        final Festa festa = new Festa().validate();
        Assert.assertTrue( "\n" + festa.error(),festa.error().size() == 5);
    }
    @Test
    public void atributosVazioOuZero() {
        final Servico servico = new Servico();
        servico.setNome("");
        servico.setDescricao("");
        servico.setValor(BigDecimal.ZERO);

        final Festa festa = new Festa();
        festa.setAutor("");
        festa.setMotivo("");
        festa.setData(LocalDate.now().plusDays(-1));
        festa.setOrcamento(BigDecimal.ZERO);
        festa.setServicos(Arrays.asList(servico));
        festa.validate();

        Assert.assertTrue( "\n" + festa.error(),festa.error().size() == 7);
    }
    @Test
    public void foraDoOrcamento() {
        final Servico servico = new Servico();
        servico.setNome("crepe");
        servico.setDescricao("crepes salgados e doces");
        servico.setValor(BigDecimal.TWO);

        final Festa festa = new Festa();
        festa.setAutor("eu");
        festa.setMotivo("fim de ano");
        festa.setData(LocalDate.now());
        festa.setOrcamento(BigDecimal.ONE);
        festa.setServicos(Arrays.asList(servico));
        festa.validate();

        Assert.assertTrue("\n" + festa.error(),festa.hasError());
    }
}