package com.filmesltda.filmes.model;


public class Assinatura {
    private Long id;
    private String nome;
    private String tipo;
    private double valor;
    private boolean status;


    public Assinatura(String nome, String tipo, double valor, boolean status) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.status = status;
    }

    public Assinatura(Long id, String nome, String tipo, double valor, boolean status) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    Assinatura() {
    }

    public final boolean gravarAssinatura() {
        System.out.println("salvando assinatura de nome " + this.nome + " de valor "+this.valor);
        return true;
    }

    public final boolean alterarAssinatura(){
        System.out.println("alterando assinatura de nome "+this.nome);
        return true;

    }

    public final boolean excluirAssinatura(){
        System.out.println("Excluindo assinatura de nome "+this.nome);
        return true;
    }


    public final boolean busca() {
        System.out.println("retorna todas as assinaturas disponíveis");
        return true;
    }

}
