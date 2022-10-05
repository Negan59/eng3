package com.filmesltda.filmes.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.filmesltda.filmes.model.Alugar;
import com.filmesltda.filmes.model.Produto;
import com.filmesltda.filmes.model.SingletonConexao;
import com.filmesltda.filmes.model.Transacao;
import com.filmesltda.filmes.model.Usuario;

public class DAOAlugar {
    public boolean salvar(Alugar a) {
        String sql = "insert into transacao (trans_data, trans_prodid, trans_usuid,trans_tipo,trans_dataexp) values ('$1','$2','$3','$4','$5')";
        sql = sql.replace("$1", "" + a.getData());
        Produto prod = a.getProduto();
        sql = sql.replace("$2", "" + prod.getId());
        Usuario usu = a.getUsuario();
        sql = sql.replace("$3", "" + usu.getId());
        sql = sql.replace("$4", "" + a.getTipo());
        sql = sql.replace("$5", "" + a.getDataexp());
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public boolean alterar(Alugar a) {
        String sql = "update transacao set trans_data = '$1', trans_prodid = '$2', trans_usuid = '$3',trans_tipo = '$4', trans_dataexp = '$5' where trans_id = "
                + a.getId();
        sql = sql.replace("$1", "" + a.getData());
        Produto prod = a.getProduto();
        sql = sql.replace("$2", "" + prod.getId());
        Usuario usu = a.getUsuario();
        sql = sql.replace("$3", "" + usu.getId());
        sql = sql.replace("$4", "" + a.getTipo());
        sql = sql.replace("$5", "" + a.getDataexp());
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public ArrayList<Transacao> buscarTodos(int id) {
        ArrayList<Transacao> Lista = new ArrayList<>();
        String sql = "select * from transacao where trans_id = "+id+" and trans_tipo = 2";
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next())
                Lista.add(
                        new Alugar(rs.getInt("trans_id"), rs.getDate("trans_data").toLocalDate(), new DAOProduto().buscarUm(rs.getInt("trans_prodid")),
                                new DAOUsuario().buscarUm(rs.getInt("trans_usuid")), rs.getDate("trans_dataexp").toLocalDate(), rs.getInt("trans_tipo")));
        } catch (Exception e) {
            System.out.println(e);
        }
        return Lista;
    }

    public Transacao buscarUm(int id) {
        Alugar novo = null;
        String sql = "select * from transacao where trans_id = " + id;
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);

        try {
            if (rs.next())
                novo = new Alugar(rs.getInt("trans_id"), rs.getDate("trans_data").toLocalDate(), new DAOProduto().buscarUm(rs.getInt("trans_prodid")),
                new DAOUsuario().buscarUm(rs.getInt("trans_usuid")), rs.getDate("trans_dataexp").toLocalDate(), rs.getInt("trans_tipo"));
        } catch (Exception e) {
            System.out.println(e);
        }
        return novo;
    }

    public ArrayList<Transacao> buscarValidos(int id) {
        ArrayList<Transacao> Lista = new ArrayList<>();
        String sql = "select * from transacao where trans_dataexp>current_date and trans_usuid = "+id+" and trans_tipo = 2";
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next())
                Lista.add(
                        new Alugar(rs.getInt("trans_id"), rs.getDate("trans_data").toLocalDate(), new DAOProduto().buscarUm(rs.getInt("trans_prodid")),
                                new DAOUsuario().buscarUm(rs.getInt("trans_usuid")), rs.getDate("trans_dataexp").toLocalDate(), rs.getInt("trans_tipo")));
        } catch (Exception e) {
            System.out.println(e);
        }
        return Lista;
    }

}
