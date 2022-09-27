package com.filmesltda.filmes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.filmesltda.filmes.control.ProdutoController;
import com.filmesltda.filmes.model.Erro;
import com.filmesltda.filmes.model.Produto;
import com.google.gson.Gson;

@SpringBootApplication
public class FilmesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmesApplication.class, args);
		ProdutoController pro = new ProdutoController();
		Erro erro = pro.salvar(new Produto("O todo Poderoso", 2003, "Filme onde Jim Carrey vira Deus", "Steven Koren",
				"Filme", 25.5, true,
				"Tom Shadyac"));

		System.out.println(new Gson().toJson(erro));

	}

}
