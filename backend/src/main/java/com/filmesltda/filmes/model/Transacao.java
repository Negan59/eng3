package com.filmesltda.filmes.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Transacao {
    private int id;
    private LocalDateTime data;
    private Produto produto;
    private Usuario usuario;
    public Transacao() {
    }
    public Transacao(LocalDateTime data, Produto produto, Usuario usuario) {
        this.data = data;
        this.produto = produto;
        this.usuario = usuario;
    }
    public Transacao(int id, LocalDateTime data, Produto produto, Usuario usuario) {
        this.id = id;
        this.data = data;
        this.produto = produto;
        this.usuario = usuario;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
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
    
    public boolean excluir(int id){
        return true;
    }

    /*public Transacao buscar_um(int id){
        
    }*/

    /*public ArrayList<Transacao> buscarTodos(){

    }*/
    
}
