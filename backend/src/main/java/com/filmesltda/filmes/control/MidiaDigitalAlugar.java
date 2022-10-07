package com.filmesltda.filmes.control;

import java.time.LocalDateTime;

import com.filmesltda.filmes.model.Comprovante;
import com.filmesltda.filmes.model.Produto;
import com.filmesltda.filmes.model.Transacao;
import com.filmesltda.filmes.model.Usuario;

public class MidiaDigitalAlugar extends TransacaoController {

    @Override
    public boolean realizaTransacao(Transacao t, int tipoPagamento) {
        return t.salvar(tipoPagamento, 2);
    }

    @Override
    public boolean registraTransacao(Transacao t) {
        Produto p = t.getProduto();
        return p.incrementarAluguel();
    }

    @Override
    public Comprovante emitirComprovante(Transacao t) {
        Usuario u = t.getUsuario();
        return new Comprovante(u.getNome(), 0, LocalDateTime.now(), "Aluguel", true);
    }


    
}
