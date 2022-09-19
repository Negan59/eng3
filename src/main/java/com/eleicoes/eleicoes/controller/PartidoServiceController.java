package com.eleicoes.eleicoes.controller;

import com.eleicoes.eleicoes.model.Partido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.eleicoes.eleicoes.repository.PartidoDAO;

@CrossOrigin
@RestController
@RequestMapping("/apis/partido")
public class PartidoServiceController {

    @Autowired
    private PartidoDAO partidoDAO;

    @PostMapping("/incluir")
    public ResponseEntity<Partido> incluir(@RequestBody Partido partido) {
        try {
            if (partido.getNome() != "") {
                partidoDAO.save(partido);
                return new ResponseEntity<>(partido, HttpStatus.OK);
            }
        } catch (Exception e) {
            System.out.println("erro");
        }
        
        return new ResponseEntity<>(partido,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/buscar-um/{id}")
    public ResponseEntity<Partido> buscarUm(@PathVariable(value = "id") Long id) {
        Partido p ;
        try{
            p = partidoDAO.findById(id).get();
        }catch(Exception e){
            p = new Partido();
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/buscar-todos")
    public ResponseEntity<Object> buscarTodos(@RequestParam(value = "filtro") String filtro) {
        List<Partido> lista = partidoDAO.findWithFilter(filtro);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @DeleteMapping("/excluir")
    public ResponseEntity<Object> excluir(@RequestParam(value = "id") Long id) {
        System.out.println(id);
        partidoDAO.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping("/atualizar")
    public ResponseEntity<Partido> atualizar(@RequestBody Partido partido) {
        System.out.println(partido.getNome());
        partidoDAO.findById(partido.getId());
        return new ResponseEntity<>(partido, HttpStatus.OK);
    }

}
