package com.eleicoes.eleicoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.eleicoes.eleicoes.model.Voto;
import com.eleicoes.eleicoes.repository.VotoDAO;

@CrossOrigin
@RestController
@RequestMapping("/apis/voto")
public class VotoServiceController {

    @Autowired
    private VotoDAO votoDAO;

    @PostMapping("/incluir")
    public ResponseEntity<Voto> incluir(@RequestBody Voto voto) {
        try {
            votoDAO.save(voto);
            return new ResponseEntity<>(voto, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("erro");
        }

        return new ResponseEntity<>(voto, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/buscar-todos")
    public ResponseEntity<Object> buscarTodos() {
        List<Voto> lista = votoDAO.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/buscar-um/{id}")
    public ResponseEntity<Voto> buscarUm(@PathVariable(value = "id") Long id) {
        Voto p; 
        try{
            p = votoDAO.findById(id).get();
        }catch(Exception e){
            p = new Voto();
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Object> excluir(@PathVariable(value = "id") Long id) {
        votoDAO.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
