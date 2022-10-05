package com.filmesltda.filmes.model;

import java.time.LocalDate;
import java.util.ArrayList;

import com.filmesltda.filmes.DAO.DAOCompra;

public class Compra extends Transacao {
    public Compra(int id, LocalDate data, Produto produto, Usuario usuario,int tipo){
        super(id, data,produto,usuario,tipo);
    }

    public Compra(LocalDate data, Produto produto, Usuario usuario, int tipo){
        super(data, produto,usuario,tipo);
    }

    @Override
    public boolean salvar() {
        DAOCompra dao = new DAOCompra();
        if (dao.salvar(this)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean atualizar() {
        DAOCompra dao = new DAOCompra();
        if (dao.alterar(this)) {
            return true;
        }
        return false;
    }

    @Override
    public Transacao buscarUm(int id) {
        DAOCompra dao = new DAOCompra();
        Transacao trans = dao.buscarUm(id);
        return trans;
    }

    @Override
    public ArrayList<Transacao> buscarTodos(int id) {
        DAOCompra dao = new DAOCompra();
        ArrayList<Transacao> lista = dao.buscarTodos(id);
        return lista;
    }
}
