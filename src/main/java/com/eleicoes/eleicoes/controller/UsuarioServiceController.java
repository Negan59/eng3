package com.eleicoes.eleicoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eleicoes.eleicoes.model.Usuario;
import com.eleicoes.eleicoes.repository.UsuarioDAO;

@CrossOrigin
@RestController
@RequestMapping("/apis/usuario")
public class UsuarioServiceController {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @GetMapping("/buscar-todos")
    public ResponseEntity<Object> buscarTodos() {
        List<Usuario> lista = usuarioDAO.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/buscar-todos/{filtro}/{senha}")
    public ResponseEntity<Object> buscarTodos(@PathVariable(value = "filtro") String filtro, @PathVariable(value = "senha") String senha) {
        List<Usuario> lista = usuarioDAO.findWithFilter(filtro);
        if(lista.get(0).getSenha() != senha){
            return new ResponseEntity<>(lista, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
    
}
