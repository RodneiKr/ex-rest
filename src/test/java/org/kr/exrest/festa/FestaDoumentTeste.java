package org.kr.exrest.festa;

import org.junit.jupiter.api.Test;
import org.kr.exrest.servico.Servico;
import org.kr.exrest.servico.ServicoDocument;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FestaDoumentTeste {

    @Test
    public void coberturaDeTesteParaToString() {
        new FestaDocument().toString();
    }
    @Test
    public void atributosPreenchidos() {
        final List<ServicoDocument> servicos = new ArrayList<>();
        final FestaDocument festa = new FestaDocument();
        festa.setId("123");
        festa.setAutor("autor");
        festa.setMotivo("motivo");
        festa.setData(LocalDate.now());
        festa.setOrcamento(BigDecimal.ZERO);
        festa.setServicos(servicos);
    }
}
