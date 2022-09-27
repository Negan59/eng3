package com.filmesltda.filmes.control;

import java.util.ArrayList;

import com.filmesltda.filmes.model.Assinatura;
import com.filmesltda.filmes.model.Produto;

public abstract class AssinaturaController {
    public final boolean manipularAssinatura(/* request e response */) {
        Assinatura a = new Assinatura("Netflix", "", 0, true);
        if (!verificarExistencia(a)) {
            salvarAssinatura(a);
        } else {
            atualizarAssinatura(a);
        }
        return true;
    }

    public final boolean produtoNaAssinatura(ArrayList<Produto> produtos){
        int usu_id = 1; //vai pegar o do cara logado
        for(int i = 0;i<produtos.size();i++){
            salvarProdutosAssinatura(usu_id,produtos.get(i));
        }
        return true;
    }

    public abstract boolean salvarAssinatura(Assinatura assinatura);

    public abstract boolean atualizarAssinatura(Assinatura assinatura);

    public abstract boolean salvarProdutosAssinatura(int usu_id,Produto produto);

    public boolean verificarExistencia(Assinatura assinatura) {
        System.out.println("verifica se a assinatura já existe");
        return true;
    }

}
