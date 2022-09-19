package com.filmesltda.filmes.model;

public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private int nivel;
    public Usuario(String nome, String email, String senha, int nivel) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nivel = nivel;
    }
    public Usuario(Long id, String nome, String email, String senha, int nivel) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nivel = nivel;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public boolean gravar(Usuario usuario){
        System.out.println("Chama a DAO para gravar o usuario"+usuario.getNome());
        return true;
    }

    public boolean alterar(Usuario usuario){
        System.out.println("Chama a DAO para alterar o usuario"+usuario.getNome());
        return true;
    }

    public boolean excluir(Long id){
        System.out.println("Chama a DAO para alterar o usuario"+id);
        return true;
    }

    public boolean buscarPorId(Long id){
        System.out.println("Chama a DAO para buscar o usuario"+id);
        return true;
    }

    public boolean buscarTodos(){
        System.out.println("Chama a DAO para buscar todos os usuarios");
        return true;
    }

    public boolean buscarPorNome(String nome){
        System.out.println("Chama a DAO para buscar o usuario de nome"+nome);
        return true;
    }
}
