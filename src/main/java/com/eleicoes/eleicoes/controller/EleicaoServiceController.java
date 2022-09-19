package com.eleicoes.eleicoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eleicoes.eleicoes.model.Eleicao;
import com.eleicoes.eleicoes.repository.EleicaoDAO;

@CrossOrigin
@RestController
@RequestMapping("/apis/eleicao")
public class EleicaoServiceController {

    @Autowired
    private EleicaoDAO eleicaoDAO;

    @PostMapping("/incluir")
    public ResponseEntity<Eleicao> incluir(@RequestBody Eleicao eleicao) {
        try {
            if (eleicao.getTipo() != "") {
                eleicaoDAO.save(eleicao);
                return new ResponseEntity<>(eleicao, HttpStatus.OK);
            }
        } catch (Exception e) {
            System.out.println("erro");
        }

        return new ResponseEntity<>(eleicao, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/buscar-um/{id}")
    public ResponseEntity<Eleicao> buscarUm(@PathVariable(value = "id") Long id) {
        Eleicao p;
        try{
            p = eleicaoDAO.findById(id).get();
        }catch(Exception e){
            p = new Eleicao();
        } 
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/buscar-todos")
    public ResponseEntity<Object> buscarTodos() {
        List<Eleicao> lista = eleicaoDAO.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/buscar-todos/{filtro}")
    public ResponseEntity<Object> buscarTodos(@PathVariable(value = "filtro") String filtro) {
        List<Eleicao> lista = eleicaoDAO.findWithFilter(filtro);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Object> excluir(@PathVariable(value = "id") Long id) {
        eleicaoDAO.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
