package com.filmesltda.filmes.model;

public interface PagamentoStrategy {
    public boolean pagar(Assinatura assinatura, Usuario usuario);
    public boolean extornar(Assinatura assinatura,Usuario usuario);
}
