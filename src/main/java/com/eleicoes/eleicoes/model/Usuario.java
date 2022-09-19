package com.eleicoes.eleicoes.model;

//crie uma api que recebe usuário e senha e retorne um json informando o nivel da usuario caso exista

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue
    @Column(name = "usu_id")
    private Long id;

    @Column(name = "usu_login")
    private String login;

    @Column(name = "usu_senha")
    private String senha;

    @Column(name = "usu_nivel") //o=operador ou a=dmin
    private char nivel;

    public Usuario(Long id, String login, String senha, char nivel) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.nivel = nivel;
    }

    public Usuario(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public char getNivel() {
        return nivel;
    }

    public void setNivel(char nivel) {
        this.nivel = nivel;
    }
}
