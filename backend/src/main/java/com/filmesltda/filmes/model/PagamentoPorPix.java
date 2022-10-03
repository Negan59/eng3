package com.filmesltda.filmes.model;

public class PagamentoPorPix implements PagamentoStrategy {

    @Override
    public boolean pagarAssinatura(Assinatura assinatura, Usuario usuario) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean pagarCompra(Compra compra) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean pagarAlugar(Alugar alugar) {
        // TODO Auto-generated method stub
        return false;
    }

   
    
}
