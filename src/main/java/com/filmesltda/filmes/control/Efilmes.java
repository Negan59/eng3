package com.filmesltda.filmes.control;

import com.filmesltda.filmes.model.Assinatura;
import com.filmesltda.filmes.model.Produto;

public class Efilmes extends AssinaturaController {

    @Override
    public boolean salvarAssinatura(Assinatura assinatura) {
        assinatura.setTipo("filme");
        assinatura.setValor(29.5);
        return true;
    }

    @Override
    public boolean atualizarAssinatura(Assinatura assinatura) {
        assinatura.setTipo("filme");
        assinatura.setValor(29.5);
        return true;
    }

    @Override
    public boolean salvarProdutosAssinatura(int usu_id, Produto produto) {
        // TODO Auto-generated method stub
        return false;
    }

   
    
}
