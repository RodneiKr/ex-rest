package org.kr.exrest.festa;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.kr.exrest.common.AbstractKrEntity;
import org.kr.exrest.servico.Servico;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Accessors(fluent = true)
@Getter
@Setter
@ToString(callSuper = true)
public class Festa extends AbstractKrEntity {
    private String autor;
    private String motivo;
    private LocalDate data;
    private BigDecimal orcamento;
    private List<Servico> servicos;
    public boolean hasError() {
        return ! this.error().isEmpty();
    }
    public Festa validate() {
        this.validateAutor();
        this.validateMotivo();
        this.validateData();
        this.validateOrcamento();
        this.validateServicos();
        return this;
    }
    private void validateAutor() {
        if (this.autor == null || this.autor.isEmpty()) {
            this.error().add("autor: dever ser preenchido");
        }
    }
    private void validateMotivo() {
        if (this.motivo == null || this.motivo.isEmpty()) {
            this.error().add("motivo: dever ser preenchido");
        }
    }
    private void validateData() {
        if (this.data == null || this.data.isBefore(LocalDate.now())) {
            this.error().add("data: deve ser maior que hoje");
        }
    }
    private void validateOrcamento() {
        if (this.orcamento == null || this.orcamento.doubleValue() <= 0.0) {
            this.error().add("orcamento: deve ser maior que ZERO");
        }
    }
    private void validateServicos() {
        if (this.servicos == null || this.servicos.isEmpty()) {
            this.error().add("servicos: deve ser preenchido");
        } else {
            for (final Servico servico : this.servicos) {
                servico.validate();
                servico.error().forEach(e -> this.error().add(e));
            }
            this.validateServicosOrcamento();
        }
    }
    private void validateServicosOrcamento() {
        final double sum = this.servicos.stream()
                .map(m -> m.valor().doubleValue())
                .reduce(0.0, Double::sum);
        if (sum > this.orcamento.doubleValue()) {
            this.error().add("orcamento: deve ser MAIOR ou IGUAL a somatoria dos servicos");
        }
    }
}
