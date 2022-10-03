package com.filmesltda.filmes.model;

public interface PagamentoStrategy {
    public boolean pagarAssinatura(Assinatura assinatura, Usuario usuario);
    public boolean pagarCompra(Compra compra);
    public boolean pagarAlugar(Alugar alugar);
}
