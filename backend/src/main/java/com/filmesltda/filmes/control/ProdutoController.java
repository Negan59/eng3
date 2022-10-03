package com.filmesltda.filmes.control;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.filmesltda.filmes.DAO.DAOProduto;
import com.filmesltda.filmes.model.Erro;
import com.filmesltda.filmes.model.Produto;

public class ProdutoController {
    private String extrairExtensao(String nomeArquivo) {
        int i = nomeArquivo.lastIndexOf(".");
        return nomeArquivo.substring(i + 1);
    }
    public Erro salvar(Produto p, MultipartFile file) {
        var caminho = "../" + UUID.randomUUID() + "." + extrairExtensao(file.getOriginalFilename());
        if (!p.getAutor().isEmpty()) {
            if (!p.getDescricao().isEmpty()) {
                if (!p.getTipo().isEmpty()) {
                    if (!p.getTitulo().isEmpty()) {
                        if (!p.getResponsavel().isEmpty()) {
                            if (!new DAOProduto().salvar(p)) {
                                return new Erro("Erro interno no banco de dados!!!", true,500);
                            }
                        }

                    } else {
                        return new Erro("Preencha o título do produto", true,400);
                    }

                } else {
                    return new Erro("Preencha o tipo do produto", true,400);
                }
            } else {
                return new Erro("Preencha a descrição do produto", true,400);
            }
        } else {
            return new Erro("Preencha o nome do autor", true,400);
        }
        try {
            Files.copy(file.getInputStream(), Path.of(caminho), StandardCopyOption.REPLACE_EXISTING);
            p.setLocal(caminho);
        } catch (Exception e) {
            return new Erro("Erro no upload do arquivo", true, 500);
        }
        return new Erro("Sucesso", false,200);

    }

    public Erro atualizar(Produto p){
        if (!p.getAutor().isEmpty()) {
            if (!p.getDescricao().isEmpty()) {
                if (!p.getTipo().isEmpty()) {
                    if (!p.getTitulo().isEmpty()) {
                        if (!p.getResponsavel().isEmpty()) {
                            if (!new DAOProduto().alterar(p)) {
                                return new Erro("Erro interno no banco de dados!!!", true,500);
                            }
                        }

                    } else {
                        return new Erro("Preencha o título do produto", true,400);
                    }

                } else {
                    return new Erro("Preencha o tipo do produto", true,400);
                }
            } else {
                return new Erro("Preencha a descrição do produto", true,400);
            }
        } else {
            return new Erro("Preencha o nome do autor", true,400);
        }
        return new Erro("Sucesso", false,200);
    }

    public ArrayList<Produto> buscar(String filtro){
        return new DAOProduto().buscar(filtro);
    }

    public ArrayList<Produto> buscarAtivos(String filtro){
        return new DAOProduto().buscar(filtro);
    }

    public Produto buscarum(int id){
        if(id>0){
            return new DAOProduto().buscarUm(id);
        }
        else{
            return new Produto();
        }
    }

    public Erro desativar(int id){
        if(id>0){
            try{
                new DAOProduto().apagar(id);
            }catch(Exception e){
                return new Erro("Não foi possível desativar", true, 500);
            }
            return new Erro("Desativado com sucesso", true, 200);
        }
        return new Erro("Id inválido", true, 400);
    }

    public Erro ativar(int id){
        if(id>0){
            try{
                new DAOProduto().ativar(id);
            }catch(Exception e){
                return new Erro("Não foi possível desativar", true, 500);
            }
            return new Erro("Desativado com sucesso", true, 200);
        }
        return new Erro("Id inválido", true, 400);
    }
}
