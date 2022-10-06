package com.filmesltda.filmes.model;

import com.filmesltda.filmes.DAO.DAOPagamento;

public class PagamentoPorBoleto implements PagamentoStrategy {


    @Override
    public boolean pagarAssinatura(Assinatura assinatura, Usuario usuario) {
        DAOPagamento dao = new DAOPagamento();
        double por = assinatura.getValor()*0.10;
        return dao.salvarAssinatura(assinatura, usuario, assinatura.getValor()-por);
    }

    @Override
    public boolean pagarCompra(Compra compra) {
        DAOPagamento dao = new DAOPagamento();
        Produto p = compra.getProduto();
        double por = p.getValor()*0.10;
        return dao.salvarProduto(compra.getProduto(), compra.getUsuario(),p.getValor()-por);
    }

    @Override
    public boolean pagarAlugar(Alugar alugar) {
        DAOPagamento dao = new DAOPagamento();
        Produto p = alugar.getProduto();
        double por = p.getValor()*0.10;
        return dao.salvarProduto(alugar.getProduto(), alugar.getUsuario(),por);
    }
    
}
