package org.kr.exrest.servico;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ServicoDocumentTeste {

    @Test
    public void coberturaDeTesteParaToString() {
        new ServicoDocument().toString();
    }
    @Test
    public void atributosPreenchidos() {
        final ServicoDocument servicoDoc = new ServicoDocument();
        servicoDoc.setId("123");
        servicoDoc.setDescricao("descricao");
        servicoDoc.setValor(BigDecimal.TWO);
        servicoDoc.setNome("nome");
    }
}
