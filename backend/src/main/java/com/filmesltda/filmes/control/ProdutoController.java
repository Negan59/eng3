package com.filmesltda.filmes.control;

import com.filmesltda.filmes.DAO.DAOProduto;
import com.filmesltda.filmes.model.Erro;
import com.filmesltda.filmes.model.Produto;

public class ProdutoController {
    public Erro salvar(Produto p) {
        if (!p.getAutor().isEmpty()) {
            if (!p.getDescricao().isEmpty()) {
                if (!p.getTipo().isEmpty()) {
                    if (!p.getTitulo().isEmpty()) {
                        if (!p.getResponsavel().isEmpty()) {
                            if (!new DAOProduto().salvar(p)) {
                                return new Erro("Erro interno no banco de dados!!!", true);
                            }
                        }

                    } else {
                        return new Erro("Preencha o título do produto", true);
                    }

                } else {
                    return new Erro("Preencha o tipo do produto", true);
                }
            } else {
                return new Erro("Preencha a descrição do produto", true);
            }
        } else {
            return new Erro("Preencha o nome do autor", true);
        }
        return new Erro("Sucesso", false);
    }
}
