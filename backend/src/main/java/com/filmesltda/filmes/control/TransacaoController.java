package com.filmesltda.filmes.control;

import com.filmesltda.filmes.model.Comprovante;
import com.filmesltda.filmes.model.Transacao;

public abstract class TransacaoController {

    public final Comprovante adquirirProduto(Transacao t,int tipoPagamento){
        if(realizaTransacao(t, tipoPagamento)){
            if(registraTransacao(t)){
                return emitirComprovante(t);
            }
            else{
                return new Comprovante("", 0.0, null, null, false);
            }
        }
        return new Comprovante("", 0.0, null, null, false);
    }

    public abstract boolean realizaTransacao(Transacao t,int tipoPagamento);
    public abstract boolean registraTransacao(Transacao t);
    public abstract Comprovante emitirComprovante(Transacao t);
}
