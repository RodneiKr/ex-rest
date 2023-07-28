package org.kr.exrest.festa;

import org.kr.exrest.servico.Servico;
import org.kr.exrest.servico.ServicoDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FestaService {
    @Autowired
    private FestaRepository repository;

    void deleteAll() {
        this.repository.deleteAll();
    }

    void deleteById(final String id) {
        this.repository.deleteById(id);
    }

    List<FestaDocument> getAll() {
        return this.repository.findAll();
    }

    FestaDocument getById(final String id) {
        return this.repository.findById(id).orElse(null);
    }

    FestaDocument post(final Festa festa) {
        return (this.isBeforeSave(festa) ? this.repository.save(festaToDoc(festa, null)) : null);
    }

    FestaDocument put(final Festa festa, final String id) {
        return (this.isBeforeSave(festa) ? this.repository.save(festaToDoc(festa, id)) : null);
    }

    private FestaDocument festaToDoc(final Festa festa, final String id) {
        final List<ServicoDocument> servicoDocumentList = new ArrayList<>();
        final List<Servico> servicoList = festa.getServicos();
        servicoList.forEach(s -> this.servicoToDoc(s, servicoDocumentList));

        final FestaDocument ret = new FestaDocument();
        ret.setId(id);
        ret.setAutor(festa.getAutor());
        ret.setData(festa.getData());
        ret.setMotivo(festa.getMotivo());
        ret.setOrcamento(festa.getOrcamento());
        ret.setServicos(servicoDocumentList);
        return ret;
    }

    private void servicoToDoc(final Servico servico, final List<ServicoDocument> list) {
        final ServicoDocument doc = new ServicoDocument();
//        doc.setId(null);
        doc.setNome(servico.getNome());
        doc.setDescricao(servico.getDescricao());
        doc.setValor(servico.getValor());
        list.add(doc);
    }

    private boolean isBeforeSave(final Festa festa) {
        return ! Optional.ofNullable(festa).orElse(new Festa()).validate().hasError();
    }
}
