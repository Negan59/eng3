package com.filmesltda.filmes.acesso;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmesltda.filmes.control.AssinaturaController;
import com.filmesltda.filmes.control.LoginController;
import com.filmesltda.filmes.control.ProdutoController;
import com.filmesltda.filmes.control.UsuarioController;
import com.filmesltda.filmes.model.Assinatura;
import com.filmesltda.filmes.model.Erro;
import com.filmesltda.filmes.model.Login;
import com.filmesltda.filmes.model.Produto;
import com.filmesltda.filmes.model.Usuario;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class Rotas {
    //Login
    @PostMapping("/login")
    public ResponseEntity<Login> validar(@RequestBody Usuario u) {
        return new ResponseEntity<>(new LoginController().validarLogin(u.getEmail(), u.getSenha()), HttpStatus.OK);
    }
    //Usuário
    @PostMapping("/usuario")
    public ResponseEntity<Erro> inserirUsuario(@RequestBody Usuario u) {
        return new ResponseEntity<>(new UsuarioController().salvar(u), HttpStatus.OK);
    }

    @PutMapping("/usuario")
    public ResponseEntity<Erro> alterarUsuario(@RequestBody Usuario u) {
        return new ResponseEntity<>(new UsuarioController().alterar(u), HttpStatus.OK);
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

    @PutMapping("/produto")
    public ResponseEntity<Erro> alterarProduto(@RequestBody Produto u) {
        return new ResponseEntity<>(new ProdutoController().atualizar(u), HttpStatus.OK);
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

    //assinaturas

    @PostMapping("/assinatura")
    public ResponseEntity<Erro> inserirAssinatura(@RequestBody Assinatura u) {
        return new ResponseEntity<>(new AssinaturaController().salvarAssinatura(u), HttpStatus.OK);
    }

    @PutMapping("/assinatura")
    public ResponseEntity<Erro> alterarAssinatura(@RequestBody Assinatura u) {
        return new ResponseEntity<>(new AssinaturaController().atualizarAssinatura(u), HttpStatus.OK);
    }

    @GetMapping("/assinatura/buscar/{id}")
    public ResponseEntity<Assinatura> buscarUmaAssinatura(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new AssinaturaController().buscarum(id), HttpStatus.OK);
    }

    @GetMapping("/assinatura/buscartodos")
    public ResponseEntity<Object> buscarTodasAssinaturas(@RequestParam(value = "filtro") String filtro) {
        return new ResponseEntity<>(new AssinaturaController().buscarTodos(filtro), HttpStatus.OK);
    }

    @GetMapping("/assinatura/buscarativos")
    public ResponseEntity<Object> buscarAtivasAssinaturas(@RequestParam(value = "filtro") String filtro) {
        return new ResponseEntity<>(new AssinaturaController().buscarAtivos(filtro), HttpStatus.OK);
    }

    @GetMapping("/assinatura/buscarinativos")
    public ResponseEntity<Object> buscarInativasAssinaturas(@RequestParam(value = "filtro") String filtro) {
        return new ResponseEntity<>(new AssinaturaController().buscarInativos(filtro), HttpStatus.OK);
    }

    @PutMapping("/assinatura/ativar/{id}")
    public ResponseEntity<Erro> ativarAssinatura(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new AssinaturaController().ativar(id), HttpStatus.OK);
    }

    @PutMapping("/assinatura/desativar/{id}")
    public ResponseEntity<Erro> desativarAssinatura(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new AssinaturaController().desativar(id), HttpStatus.OK);
    }
}
