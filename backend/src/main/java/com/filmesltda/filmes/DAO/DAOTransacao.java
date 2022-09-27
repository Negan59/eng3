package com.filmesltda.filmes.DAO;

import com.filmesltda.filmes.model.SingletonConexao;
import com.filmesltda.filmes.model.Transacao;

public class DAOTransacao {
    /*public boolean salvar(Transacao p) {
        String sql = "insert into transacao (prod_titulo, prod_ano, prod_desc,prod_autor, prod_tipo, prod_valor, prod_responsavel) values ('$1','$2','$3','$4','$5','$6','$7')";
        sql = sql.replace("$1", p.getTitulo());
        sql = sql.replace("$2", ""+p.getAnoLancamento());
        sql = sql.replace("$3", p.getDescricao());
        sql = sql.replace("$4", p.getAutor());
        sql = sql.replace("$5", p.getTipo());
        sql = sql.replace("$6", ""+p.getValor());
        sql = sql.replace("$7", p.getResponsavel());
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }*/
}
