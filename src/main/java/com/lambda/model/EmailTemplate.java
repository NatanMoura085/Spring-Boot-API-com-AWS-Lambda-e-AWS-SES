package com.lambda.model;

import java.time.OffsetDateTime;

public class EmailTemplate {

    private String nome;
    private Double valor;
    private OffsetDateTime data;

    public EmailTemplate(String nome, Double valor, OffsetDateTime data) {
        this.nome = nome;
        this.valor = valor;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public OffsetDateTime getData() {
        return data;
    }

    public void setData(OffsetDateTime data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "EmailTemplate{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", data=" + data +
                '}';
    }
}
