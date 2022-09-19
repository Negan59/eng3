package com.filmesltda.filmes.model;

import com.filmesltda.filmes.DAO.DAOProduto;
public class Produto {
    private int id;
    private String titulo;
    private int anoLancamento;
    private String descricao; //letra no caso de música, trailer no caso de filme e sinopse no caso de livro
    private String autor;
    private String tipo;
    private Double valor;
    private String responsavel;//produtora no caso de filme, editora no caso de livro e estúdio no caso de música
    
    public Produto(String titulo, int anoLancamento, String descricao, String autor, String tipo, Double valor,
            String responsavel) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.descricao = descricao;
        this.autor = autor;
        this.tipo = tipo;
        this.valor = valor;
        this.responsavel = responsavel;
    }
    public Produto(int id, String titulo, int anoLancamento, String descricao, String autor, String tipo, Double valor,
            String responsavel) {
        this.id = id;
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.descricao = descricao;
        this.autor = autor;
        this.tipo = tipo;
        this.valor = valor;
        this.responsavel = responsavel;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getResponsavel() {
        return responsavel;
    }
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public boolean salvar(){
        DAOProduto dao = new DAOProduto();
        if(dao.salvar(this)){
            return true;
        }
        return false;

    }

}
