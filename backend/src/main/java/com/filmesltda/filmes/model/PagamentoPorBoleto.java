package com.filmesltda.filmes.model;

public class PagamentoPorBoleto implements PagamentoStrategy {

    @Override
    public boolean pagar(Assinatura assinatura, Usuario usuario) {
        System.out.println("Pagamento foi feito por boleto pelo usuario "+usuario.getNome()+" relativo a assinatura "+assinatura.getNome());
        return true;
    }

    @Override
    public boolean extornar(Assinatura assinatura, Usuario usuario) {
        System.out.println("Pagamento foi extornado com ressarcimento em conta pelo usuario "+usuario.getNome()+" relativo a assinatura "+assinatura.getNome());
        return true;
    }
    
}
