package com.filmesltda.filmes.model;

import java.time.LocalDate;
import java.util.ArrayList;

import com.filmesltda.filmes.DAO.DAOAlugar;

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
        DAOAlugar dao = new DAOAlugar();
        if (dao.salvar(this)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean atualizar() {
        DAOAlugar dao = new DAOAlugar();
        if (dao.alterar(this)) {
            return true;
        }
        return false;
    }

    @Override
    public Transacao buscarUm(int id) {
        DAOAlugar dao = new DAOAlugar();
        Transacao trans = dao.buscarUm(id);
        return trans;
    }

    @Override
    public ArrayList<Transacao> buscarTodos(int id) {
        DAOAlugar dao = new DAOAlugar();
        ArrayList<Transacao> lista = dao.buscarTodos(id);
        return lista;
    }

    public ArrayList<Transacao> buscarValidos(int id) {
        DAOAlugar dao = new DAOAlugar();
        ArrayList<Transacao> lista = dao.buscarValidos(id);
        return lista;
    }
    
}
