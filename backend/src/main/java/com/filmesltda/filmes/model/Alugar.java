package com.filmesltda.filmes.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Alugar extends Transacao{
    private LocalDate dataexp;
    
    public LocalDate getDataexp() {
        return dataexp;
    }

    public void setDataexp(LocalDate dataexp) {
        this.dataexp = dataexp;
    }

    public Alugar(LocalDate data, Produto produto, Usuario usuario, LocalDate dataexp,int tipo) {
        super(data, produto, usuario,tipo);
        this.dataexp = dataexp;
    }

    public Alugar(int id, LocalDate data, Produto produto, Usuario usuario, LocalDate dataexp,int tipo) {
        super(id, data, produto, usuario,tipo);
        this.dataexp = dataexp;
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
