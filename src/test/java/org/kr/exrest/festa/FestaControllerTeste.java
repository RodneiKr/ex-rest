package org.kr.exrest.festa;

import org.assertj.core.util.Arrays;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kr.exrest.servico.Servico;
import org.kr.exrest.servico.ServicoDocument;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FestaControllerTeste {

    @InjectMocks
    private FestaController controller;

    @Mock
    private FestaService service;

    @Test
    public void deleteAll() {
        this.controller.deleteAll();
    }

    @Test
    public void deleteById() {
        this.controller.deleteById("123");
    }

    @Test
    public void getAll() {
        final FestaDocument festaDoc = new FestaDocument();
        this.festaDocument(festaDoc);

        final List<FestaDocument> festaDocList = new ArrayList<>();
        festaDocList.add(festaDoc);

        Mockito.when(this.service.getAll()).thenReturn(festaDocList);

        this.controller.getAll();
    }

    @Test
    public void getById() {
        final FestaDocument festaDoc = new FestaDocument();
        this.festaDocument(festaDoc);
        Mockito.when(this.service.getById("123")).thenReturn(festaDoc);
        this.controller.getById("123");
    }

    @Test
    public void post() {
        final FestaDocument festaDoc = null;
        final Festa festa = new Festa();
        this.festa(festa);

        Mockito.when(this.service.post(festa)).thenReturn(festaDoc);
        this.controller.post(festa);
    }

    @Test
    public void postException() {
        final FestaDocument festaDoc = null;
        final Festa festa = null;
        Mockito.when(this.service.post(festa)).thenReturn(festaDoc);

        try {
            this.controller.post(festa);
            Assert.assertTrue("deveria ter entrado catch", false);
        } catch (ResponseStatusException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void put() {
        final FestaDocument festaDoc = null;
        final Festa festa = new Festa();
        this.festa(festa);

        Mockito.when(this.service.put(festa, "123")).thenReturn(festaDoc);
        this.controller.put("123",festa);
    }

    @Test
    public void putException() {
        final FestaDocument festaDoc = null;
        final Festa festa = null;

        Mockito.when(this.service.put(festa, "123")).thenReturn(festaDoc);

        try {
            this.controller.put("123", festa);
            Assert.assertTrue("deveria ter entrado no catch", false);
        } catch (ResponseStatusException e) {
            Assert.assertTrue(true);
        }
    }

    private void festaDocument(final FestaDocument festaDoc) {
        final ServicoDocument servicoDoc = new ServicoDocument();
        servicoDoc.setNome("nome");
        servicoDoc.setDescricao("descricao");
        servicoDoc.setValor(BigDecimal.TWO);

        final List<ServicoDocument> servicoDocList = new ArrayList<>();
        servicoDocList.add(servicoDoc);

        festaDoc.setAutor("autor");
        festaDoc.setMotivo("motivo");
        festaDoc.setData(LocalDate.now());
        festaDoc.setOrcamento(BigDecimal.TEN);
        festaDoc.setId("123");
        festaDoc.setServicos(servicoDocList);
    }

    private void festa(final Festa festa) {
        final Servico servico = new Servico();
        servico.setNome("nome");
        servico.setDescricao("descricao");
        servico.setValor(BigDecimal.TWO);
        final List<Servico> servicoList = new ArrayList<>();
        servicoList.add(servico);

        festa.setAutor("autor");
        festa.setMotivo("motivo");
        festa.setData(LocalDate.now());
        festa.setOrcamento(BigDecimal.TEN);
        festa.setServicos(servicoList);
    }
}
