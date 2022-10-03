package com.filmesltda.filmes.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.filmesltda.filmes.model.SingletonConexao;
import com.filmesltda.filmes.model.Usuario;

public class DAOUsuario {
    public boolean salvar(Usuario u) {
        String sql = "insert into usuario (usu_nome, usu_email, usu_senha,usu_nivel,usu_status) values ('$1','$2','$3','$4','$5')";
        sql = sql.replace("$1", u.getNome());
        sql = sql.replace("$2", u.getEmail());
        sql = sql.replace("$3", u.getSenha());
        sql = sql.replace("$4", ""+u.getNivel());
        sql = sql.replace("$5", ""+u.isStatus());
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public boolean alterar(Usuario u) {
        String sql = "update usuario set usu_nome = '$1', usu_email = '$2', usu_senha = '$3',usu_nivel = '$4', usu_status = '$5' where usu_id = "
                + u.getId();
        sql = sql.replace("$1", u.getNome());
        sql = sql.replace("$2", u.getEmail());
        sql = sql.replace("$3", u.getSenha());
        sql = sql.replace("$4", ""+u.getNivel());
        sql = sql.replace("$5", ""+u.isStatus());
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

    public ArrayList<Usuario> buscar(String filtro) {
        ArrayList<Usuario> Lista = new ArrayList<>();
        String sql = "select * from usuario";
        if (!filtro.isEmpty()) {
            sql = "select * from usuario where usu_nome LIKE " + "'" + filtro + "'";
        }
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next())
                Lista.add(
                        new Usuario(rs.getInt("usu_id"), rs.getString("usu_nome"), rs.getString("usu_email"),
                        rs.getString("usu_senha"), rs.getInt("usu_nivel"),rs.getBoolean("usu_status")));
        } catch (Exception e) {
            System.out.println(e);
        }
        return Lista;
    } 

    public Usuario buscarUm(int id){
        Usuario novo = null;
        String sql = "select * from usuario where usu_id = " + id;
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);

        try {
            if (rs.next())
                novo = new Usuario(rs.getInt("usu_id"), rs.getString("usu_nome"), rs.getString("usu_email"),
                rs.getString("usu_senha"), rs.getInt("usu_nivel"),rs.getBoolean("usu_status"));
        } catch (Exception e) {
            System.out.println(e);
        }
        return novo;
    }

    public boolean apagar(int id) {
        Usuario u = buscarUm(id);
        u.setStatus(false);
        boolean flag;
        flag = alterar(u);
        return flag;
    }

    public boolean ativar(int id) {
        Usuario u = buscarUm(id);
        u.setStatus(true);
        boolean flag;
        flag = alterar(u);
        return flag;
    }
}
