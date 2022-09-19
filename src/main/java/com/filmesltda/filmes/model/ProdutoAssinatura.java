package com.filmesltda.filmes.model;

import java.time.LocalDateTime;

public class ProdutoAssinatura {
    private Produto produto;
    private Assinatura assinatura;
    private LocalDateTime data;
    public ProdutoAssinatura(Produto produto, Assinatura assinatura, LocalDateTime data) {
        this.produto = produto;
        this.assinatura = assinatura;
        this.data = data;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Assinatura getAssinatura() {
        return assinatura;
    }
    public void setAssinatura(Assinatura assinatura) {
        this.assinatura = assinatura;
    }
    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public boolean gravar(){
        System.out.println("gravando o produto "+this.produto.getTitulo()+" na assinatura "+this.assinatura.getNome());
        return true;
    }

    public boolean alterar(){
        System.out.println("alterando o produto "+this.produto.getTitulo()+" na assinatura "+this.assinatura.getNome());
        return true;
    }

    public boolean excluir(){
        System.out.println("excluindo o produto "+this.produto.getTitulo()+" na assinatura "+this.assinatura.getNome());
        return true;
    }

    public boolean buscar(){
        System.out.println("buscando o produto "+this.produto.getTitulo()+" na assinatura "+this.assinatura.getNome());
        return true;
    }

    public boolean buscarPorAssinatura(int id){
        System.out.println("buscando todos os produtos "+" na assinatura "+id);
        return true;
    }

    public boolean buscarPorProduto(int id){
        System.out.println("buscando o produto "+id+" em todas as assinaturas");
        return true;
    }

}
