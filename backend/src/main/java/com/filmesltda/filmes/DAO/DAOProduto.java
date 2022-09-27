package com.filmesltda.filmes.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.filmesltda.filmes.model.Produto;
import com.filmesltda.filmes.model.SingletonConexao;

public class DAOProduto {
    public boolean salvar(Produto p) {
        String sql = "insert into produto (prod_titulo, prod_ano, prod_desc,prod_autor, prod_tipo, prod_valor, prod_responsavel,prod_status) values ('$1','$2','$3','$4','$5','$6','$7','$8')";
        sql = sql.replace("$1", p.getTitulo());
        sql = sql.replace("$2", "" + p.getAnoLancamento());
        sql = sql.replace("$3", p.getDescricao());
        sql = sql.replace("$4", p.getAutor());
        sql = sql.replace("$5", p.getTipo());
        sql = sql.replace("$6", "" + p.getValor());
        sql = sql.replace("$7", p.getResponsavel());
        sql = sql.replace("$8", "" + p.isStatus());
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public boolean alterar(Produto p) {
        String sql = "update produto set prod_titulo = '$1', prod_ano = '$2', prod_desc = '$3',prod_autor = '$4', prod_tipo = '$5', prod_valor = '$6', prod_responsavel = '$7', prod_status = '$8' where prod_id = "
                + p.getId();
        sql = sql.replace("$1", p.getTitulo());
        sql = sql.replace("$2", "" + p.getAnoLancamento());
        sql = sql.replace("$3", p.getDescricao());
        sql = sql.replace("$4", p.getAutor());
        sql = sql.replace("$5", p.getTipo());
        sql = sql.replace("$6", "" + p.getValor());
        sql = sql.replace("$7", p.getResponsavel());
        sql = sql.replace("$8", "" + p.isStatus());
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public ArrayList<Produto> buscar(String filtro) {
        ArrayList<Produto> Lista = new ArrayList<>();
        String sql = "select * from produto";
        if (!filtro.isEmpty()) {
            sql = "select * from produto where prod_titulo LIKE " + "'" + filtro + "'";
        }
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next())
                Lista.add(
                        new Produto(rs.getInt("prod_id"), rs.getString("prod_titulo"), rs.getInt("prod_ano"),
                                rs.getString("prod_desc"), rs.getString("prod_autor"), rs.getString("prod_tipo"),
                                rs.getDouble("prod_valor"), rs.getBoolean("prod_status"),
                                rs.getString("prod_responsavel")));
        } catch (Exception e) {
            System.out.println(e);
        }
        return Lista;
    }

    public Produto buscarUm(int id) {
        Produto novo = null;
        String sql = "select * from produto where prod_id = " + id;
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            if (rs.next())
                novo = new Produto(rs.getInt("prod_id"), rs.getString("prod_titulo"), rs.getInt("prod_ano"),
                        rs.getString("prod_desc"), rs.getString("prod_autor"), rs.getString("prod_tipo"),
                        rs.getDouble("prod_valor"), rs.getBoolean("prod_status"), rs.getString("prod_responsavel"));
        } catch (Exception e) {
            System.out.println(e);
        }
        return novo;
    }

    public boolean apagar(int id) {
        Produto p = buscarUm(id);
        p.setStatus(false);
        boolean flag;
        flag = alterar(p);
        return flag;
    }

    public boolean ativar(int id) {
        Produto p = buscarUm(id);
        p.setStatus(true);
        boolean flag;
        flag = alterar(p);
        return flag;
    }
}
