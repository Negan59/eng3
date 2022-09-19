package com.eleicoes.eleicoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eleicoes.eleicoes.model.Candidato;
import com.eleicoes.eleicoes.repository.CandidatoDAO;

@CrossOrigin
@RestController
@RequestMapping("/apis/candidato")
public class CandidatoServiceController {

    @Autowired
    private CandidatoDAO candidatoDAO;

    @PostMapping("/incluir")
    public ResponseEntity<Candidato> incluir(@RequestBody Candidato candidato) {
        try {
            if (candidato.getNome() != "") {
                candidatoDAO.save(candidato);
                return new ResponseEntity<>(candidato, HttpStatus.OK);
            }
        } catch (Exception e) {
            System.out.println("erro");
        }

        return new ResponseEntity<>(candidato, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/buscar-um/{id}")
    public ResponseEntity<Candidato> buscarUm(@PathVariable(value = "id") Long id) {
        Candidato p;
        try{
            p = candidatoDAO.findById(id).get();
        }catch(Exception e){
            p = new Candidato();
        } 
        
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/buscar-todos")
    public ResponseEntity<Object> buscarTodos(@RequestParam(value = "filtro") String filtro) {
        List<Candidato> lista = candidatoDAO.findWithFilter(filtro);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @DeleteMapping("/excluir")
    public ResponseEntity<Object> excluir(@RequestParam(value = "id") Long id) {
        candidatoDAO.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping("/atualizar")
    public ResponseEntity<Candidato> atualizar(@RequestBody Candidato candidato) {
        System.out.println(candidato.getNome());
        candidatoDAO.findById(candidato.getId());
        return new ResponseEntity<>(candidato, HttpStatus.OK);
    }

}
