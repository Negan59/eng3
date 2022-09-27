package com.filmesltda.filmes.model;

public class Erro {
    private String mensagem;
    private boolean tipo;// se é 0 é sucesso, se é 1 é erro

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Erro(String mensagem, boolean tipo) {
        this.mensagem = mensagem;
        this.tipo = tipo;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }
}
