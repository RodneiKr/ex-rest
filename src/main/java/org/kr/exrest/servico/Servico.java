package org.kr.exrest.servico;

import lombok.*;
import lombok.experimental.Accessors;
import org.kr.exrest.common.AbstractKrEntity;

import java.math.BigDecimal;

//@Accessors(fluent = true)
@Getter
@Setter
@ToString(callSuper = true)
public class Servico extends AbstractKrEntity {
    private String nome;
    private String descricao;
    private BigDecimal valor;
    public boolean hasError() {
        return ! this.error().isEmpty();
    }
    public Servico validate() {
        this.error().clear();
        this.validateNome();
        this.validateDescricao();
        this.validateValor();
        return this;
    }
    private void validateNome() {
        if (this.nome == null || this.nome.isEmpty()) {
            this.error().add("nome: deve ser preenchido");
        }
    }
    private void validateDescricao() {
        if (this.descricao == null || this.descricao.isEmpty()) {
            this.error().add("descricao: deve ser preenchido");
        }
    }
    private void validateValor() {
        if (this.valor == null || this.valor.doubleValue() <= 0.0) {
            this.error().add("valor: deve ser maior que ZERO");
        }
    }
}
