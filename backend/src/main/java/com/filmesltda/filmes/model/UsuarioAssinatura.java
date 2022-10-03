package com.filmesltda.filmes.model;

import java.time.LocalDateTime;

public class UsuarioAssinatura {
    private Usuario usuario;
    private Assinatura assinatura;
    private LocalDateTime dataExpiracao;
    public UsuarioAssinatura(Usuario usuario, Assinatura assinatura, LocalDateTime dataExpiracao) {
        this.usuario = usuario;
        this.assinatura = assinatura;
        this.dataExpiracao = dataExpiracao;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Assinatura getAssinatura() {
        return assinatura;
    }
    public void setAssinatura(Assinatura assinatura) {
        this.assinatura = assinatura;
    }
    public LocalDateTime getDataExpiracao() {
        return dataExpiracao;
    }
    public void setDataExpiracao(LocalDateTime dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public boolean gravar(){
        System.out.println("Gerando a assinatura para o usuário");
        return true;
    }
    public boolean alterar(){
        System.out.println("Alterando a assinatura para o usuário");
        return true;
    }

    public boolean excluir(){
        System.out.println("excluindo a assinatura para o usuário");
        return true;
    }

    public boolean buscarTodos(){
        System.out.println("Buscando todas as assinaturas de todos os usuários");
        return true;
    }

    public boolean buscarPorUsuario(){
        System.out.println("Buscando assinaturas do usuário "+this.usuario.getNome());
        return true;
    }

    public boolean buscarPorAssinatura(){
        System.out.println("Buscando os usuários que possuem a assinatura "+this.assinatura.getNome());
        return true;
    }

    public boolean renovarAssinatura(int tipoPagamento){
        if(tipoPagamento == 1){
            if(new PagamentoPorBoleto().pagar(assinatura, usuario)){
                System.out.println("aumenta a data em 1 mês");
                alterar();
            }

        }else if(tipoPagamento == 2){
            if(new PagamentoPorPix().pagar(assinatura, usuario)){
                System.out.println("aumenta a data em 1 mês");
                alterar();
            }
        }
        else{
            if(new PagamentoPorCartao().pagar(assinatura, usuario)){
                System.out.println("aumenta a data em 1 mês");
                alterar();
            }
        }
        return true;
    }

    public boolean extornarAssinatura(int tipoPagamento){
        if(tipoPagamento == 1){
            if(new PagamentoPorBoleto().extornar(assinatura, usuario)){
                System.out.println("aumenta a data em 1 mês");
                alterar();
            }

        }else if(tipoPagamento == 2){
            if(new PagamentoPorPix().extornar(assinatura, usuario)){
                System.out.println("aumenta a data em 1 mês");
                alterar();
            }
        }
        else{
            if(new PagamentoPorCartao().extornar(assinatura, usuario)){
                System.out.println("aumenta a data em 1 mês");
                alterar();
            }
        }
        return true;
    }
}