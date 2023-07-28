package org.kr.exrest.servico;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

//@Accessors(fluent = true)
@Getter
@Setter
@ToString
@Document
public class ServicoDocument {
    @Id
    private String id;
    private String nome;
    private String descricao;
    private BigDecimal valor;
}
