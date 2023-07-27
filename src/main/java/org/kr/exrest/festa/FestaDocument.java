package org.kr.exrest.festa;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.kr.exrest.servico.Servico;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Accessors(fluent = true)
@Getter
@Setter
@ToString
@Document
public class FestaDocument {
    @Id
    private String id;
    private String autor;
    private String motivo;
    private LocalDate data;
    private BigDecimal orcamento;
    private List<Servico> servicos;
}
