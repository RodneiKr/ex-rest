package org.kr.exrest.festa;

import org.junit.jupiter.api.Test;
import org.kr.exrest.servico.Servico;
import org.springframework.util.Assert;

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
        final Servico servico = new Servico()
                .nome("crepe")
                .descricao("crepes salgados e doces")
                .valor(BigDecimal.TWO);
        final Festa festa = new Festa()
                .autor("eu")
                .motivo("fim de ano")
                .data(LocalDate.now())
                .orcamento(BigDecimal.TWO)
                .servicos(Arrays.asList(servico))
                .validate();
        ;
        Assert.isTrue(!festa.hasError(),"\n" + festa.error());
    }
    @Test
    public void atributosIgualNull() {
        final Servico servico = new Servico().validate();
        final Festa festa = new Festa().validate();
        Assert.isTrue(festa.error().size() == 5, "\n" + festa.error());
    }
    @Test
    public void atributosVazioOuZero() {
        final Servico servico = new Servico()
                .nome("")
                .descricao("")
                .valor(BigDecimal.ZERO);
        final Festa festa = new Festa()
                .autor("")
                .motivo("")
                .data(LocalDate.now().plusDays(-1))
                .orcamento(BigDecimal.ZERO)
                .servicos(Arrays.asList(servico))
                .validate();
        Assert.isTrue(festa.error().size() == 7, "\n" + festa.error());
    }
    @Test
    public void foraDoOrcamento() {
        final Servico servico = new Servico()
                .nome("crepe")
                .descricao("crepes salgados e doces")
                .valor(BigDecimal.TWO);
        final Festa festa = new Festa()
                .autor("eu")
                .motivo("fim de ano")
                .data(LocalDate.now())
                .orcamento(BigDecimal.ONE)
                .servicos(Arrays.asList(servico))
                .validate();
        ;
        Assert.isTrue(festa.hasError(),"\n" + festa.error());
    }
}