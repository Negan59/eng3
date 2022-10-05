package com.filmesltda.filmes.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.filmesltda.filmes.model.Compra;
import com.filmesltda.filmes.model.Produto;
import com.filmesltda.filmes.model.SingletonConexao;
import com.filmesltda.filmes.model.Transacao;
import com.filmesltda.filmes.model.Usuario;

public class DAOCompra {
    public boolean salvar(Compra a) {
        String sql = "insert into transacao (trans_data, trans_prodid, trans_usuid,trans_tipo) values ('$1','$2','$3','$4')";
        sql = sql.replace("$1", "" + a.getData());
        Produto prod = a.getProduto();
        sql = sql.replace("$2", "" + prod.getId());
        Usuario usu = a.getUsuario();
        sql = sql.replace("$3", "" + usu.getId());
        sql = sql.replace("$4", "" + a.getTipo());
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public boolean alterar(Compra a) {
        String sql = "update transacao set trans_data = '$1', trans_prodid = '$2', trans_usuid = '$3',trans_tipo = '$4' where trans_id = "
                + a.getId();
        sql = sql.replace("$1", "" + a.getData());
        Produto prod = a.getProduto();
        sql = sql.replace("$2", "" + prod.getId());
        Usuario usu = a.getUsuario();
        sql = sql.replace("$3", "" + usu.getId());
        sql = sql.replace("$4", "" + a.getTipo());
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public ArrayList<Transacao> buscarTodos(int id) {
        ArrayList<Transacao> Lista = new ArrayList<>();
        String sql = "select * from transacao where trans_usuid = "+id+" and trans_tipo = 1";
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next())
                Lista.add(
                        new Compra(rs.getInt("trans_id"), rs.getDate("trans_data").toLocalDate(), new DAOProduto().buscarUm(rs.getInt("trans_prodid")),
                                new DAOUsuario().buscarUm(rs.getInt("trans_usuid")), rs.getInt("trans_tipo")));
        } catch (Exception e) {
            System.out.println(e);
        }
        return Lista;
    }

    public Transacao buscarUm(int id) {
        Compra novo = null;
        String sql = "select * from transacao where trans_id = " + id;
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);

        try {
            if (rs.next())
                novo = new Compra(rs.getInt("trans_id"), rs.getDate("trans_data").toLocalDate(), new DAOProduto().buscarUm(rs.getInt("trans_prodid")),
                new DAOUsuario().buscarUm(rs.getInt("trans_usuid")), rs.getInt("trans_tipo"));
        } catch (Exception e) {
            System.out.println(e);
        }
        return novo;
    }

}
