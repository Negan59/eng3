package com.filmesltda.filmes.model;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Transacao {
    private int id;
    private LocalDate data;
    private Produto produto;
    private Usuario usuario;
    private int tipo;
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public Transacao() {
    }
    public Transacao(LocalDate data, Produto produto, Usuario usuario, int tipo) {
        this.data = data;
        this.produto = produto;
        this.usuario = usuario;
        this.tipo = tipo;
    }
    public Transacao(int id, LocalDate data, Produto produto, Usuario usuario,int tipo) {
        this.id = id;
        this.data = data;
        this.produto = produto;
        this.usuario = usuario;
        this.tipo = tipo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public abstract boolean salvar();

    public abstract boolean atualizar();

    public abstract Transacao buscarUm(int id);

    public abstract ArrayList<Transacao> buscarTodos();

    
    
}
