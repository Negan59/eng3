package com.filmesltda.filmes.control;

import com.filmesltda.filmes.model.Erro;
import com.filmesltda.filmes.model.Usuario;

public class LoginController {
    public Erro validarLogin(String email, String senha){
        Usuario u = new Usuario().buscarEmail(email);
        if(u != null){
            if(senha.equals(u.getSenha())){
                return new Erro("Login realizado com sucesso", false, 200);
            }else{
                return new Erro("Senhas não coincidem", true, 400);
            }
        }
        return new Erro("Usuário não encontrado", true, 500);
    }
}
