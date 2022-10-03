package com.filmesltda.filmes.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Compra extends Transacao {
    public Compra(int id, LocalDate data, Produto produto, Usuario usuario,int tipo){
        super(id, data,produto,usuario,tipo);
    }

    public Compra(LocalDate data, Produto produto, Usuario usuario, int tipo){
        super(data, produto,usuario,tipo);
    }

    @Override
    public boolean salvar() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean atualizar() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Transacao buscarUm(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Transacao> buscarTodos() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
