package org.kr.exrest.festa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return this.repository.save(festa(festa));
    }
    FestaDocument put(final Festa festa) {
        return this.repository.save(festa(festa));
    }

    private FestaDocument festa(final Festa festa) {
        return new FestaDocument()
                .autor(festa.autor())
                .data(festa.data())
                .motivo(festa.motivo())
                .orcamento(festa.orcamento())
                .servicos(festa.servicos());
    }
}
