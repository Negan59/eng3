package com.filmesltda.filmes.control;

public abstract class TransacaoController {

    public final boolean adquirir(){
        return true;
    }

    public abstract boolean cancelar();
    public abstract boolean registraTransacao();
    public abstract boolean emitirComprovante();
}
