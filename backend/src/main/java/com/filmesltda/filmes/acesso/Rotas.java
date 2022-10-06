package com.filmesltda.filmes.acesso;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmesltda.filmes.control.LoginController;
import com.filmesltda.filmes.control.ProdutoController;
import com.filmesltda.filmes.control.UsuarioController;
import com.filmesltda.filmes.model.Erro;
import com.filmesltda.filmes.model.Login;
import com.filmesltda.filmes.model.Produto;
import com.filmesltda.filmes.model.Usuario;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class Rotas {
    @PostMapping("/login")
    public ResponseEntity<Login> validar(@RequestBody Usuario u) {
        return new ResponseEntity<>(new LoginController().validarLogin(u.getEmail(), u.getSenha()), HttpStatus.OK);
    }

    @PostMapping("/usuario")
    public ResponseEntity<Erro> inserirUsuario(@RequestBody Usuario u) {
        return new ResponseEntity<>(new UsuarioController().salvar(u), HttpStatus.OK);
    }

    @GetMapping("/usuario/buscar/{id}")
    public ResponseEntity<Usuario> buscarUm(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new UsuarioController().buscarum(id), HttpStatus.OK);
    }

    @GetMapping("/usuario/buscartodos")
    public ResponseEntity<Object> buscarTodos(@RequestParam(value = "filtro") String filtro) {
        return new ResponseEntity<>(new UsuarioController().buscarTodos(filtro), HttpStatus.OK);
    }

    @GetMapping("/usuario/buscarativos")
    public ResponseEntity<Object> buscarAtivos(@RequestParam(value = "filtro") String filtro) {
        return new ResponseEntity<>(new UsuarioController().buscarAtivos(filtro), HttpStatus.OK);
    }

    @GetMapping("/usuario/buscarinativos")
    public ResponseEntity<Object> buscarInativos(@RequestParam(value = "filtro") String filtro) {
        return new ResponseEntity<>(new UsuarioController().buscarInativos(filtro), HttpStatus.OK);
    }

    @PutMapping("/usuario/ativar/{id}")
    public ResponseEntity<Erro> ativar(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new UsuarioController().ativar(id), HttpStatus.OK);
    }

    @PutMapping("/usuario/desativar/{id}")
    public ResponseEntity<Erro> desativar(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new UsuarioController().desativar(id), HttpStatus.OK);
    }

    //produtos

    @PostMapping("/produto")
    public ResponseEntity<Erro> inserirProduto(@RequestBody Produto u) {
        return new ResponseEntity<>(new ProdutoController().salvar(u), HttpStatus.OK);
    }

    @GetMapping("/produto/buscar/{id}")
    public ResponseEntity<Produto> buscarUmProduto(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new ProdutoController().buscarum(id), HttpStatus.OK);
    }

    @GetMapping("/produto/buscartodos")
    public ResponseEntity<Object> buscarTodosProdutos(@RequestParam(value = "filtro") String filtro) {
        return new ResponseEntity<>(new ProdutoController().buscarTodos(filtro), HttpStatus.OK);
    }

    @GetMapping("/produto/buscarativos")
    public ResponseEntity<Object> buscarAtivosProdutos(@RequestParam(value = "filtro") String filtro) {
        return new ResponseEntity<>(new ProdutoController().buscarAtivos(filtro), HttpStatus.OK);
    }

    @GetMapping("/produto/buscarinativos")
    public ResponseEntity<Object> buscarInativosProdutos(@RequestParam(value = "filtro") String filtro) {
        return new ResponseEntity<>(new ProdutoController().buscarInativos(filtro), HttpStatus.OK);
    }

    @PutMapping("/produto/ativar/{id}")
    public ResponseEntity<Erro> ativarProduto(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new ProdutoController().ativar(id), HttpStatus.OK);
    }

    @PutMapping("/produto/desativar/{id}")
    public ResponseEntity<Erro> desativarProduto(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new ProdutoController().desativar(id), HttpStatus.OK);
    }
}
