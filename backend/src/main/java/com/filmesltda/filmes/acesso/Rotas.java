package com.filmesltda.filmes.acesso;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmesltda.filmes.control.LoginController;
import com.filmesltda.filmes.control.UsuarioController;
import com.filmesltda.filmes.model.Erro;
import com.filmesltda.filmes.model.Login;
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
}
