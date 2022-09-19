package com.filmesltda.filmes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.filmesltda.filmes.model.Produto;

@SpringBootApplication
public class FilmesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmesApplication.class, args);
		Produto prod = new Produto("Click", 2006, "Filme do controle da vida", "Frank Coraci", "Filme", 25.5, "Adam Sandler");
		if(prod.salvar()){
			System.out.println("Gravou com sucesso");
		}
		else{
			System.out.println("Não gravou com sucesso");
		}
	}

}
