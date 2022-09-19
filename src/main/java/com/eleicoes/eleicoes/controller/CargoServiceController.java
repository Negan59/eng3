package com.eleicoes.eleicoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eleicoes.eleicoes.model.Cargo;
import com.eleicoes.eleicoes.repository.CargoDAO;

@CrossOrigin
@RestController
@RequestMapping("/apis/cargo")
public class CargoServiceController {

    @Autowired
    private CargoDAO cargoDAO;

    @PostMapping("/incluir")
    public ResponseEntity<Cargo> incluir(@RequestBody Cargo cargo) {
        try {
            if (cargo.getDescricao() != "") {
                cargoDAO.save(cargo);
                return new ResponseEntity<>(cargo, HttpStatus.OK);
            }
        } catch (Exception e) {
            System.out.println("erro");
        }

        return new ResponseEntity<>(cargo, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/buscar-um/{id}")
    public ResponseEntity<Cargo> buscarUm(@PathVariable(value = "id") Long id) {
        Cargo p;
        try{
           p  = cargoDAO.findById(id).get();
        }catch(Exception e){
            p = new Cargo();
        } 
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/buscar-todos")
    public ResponseEntity<Object> buscarTodos() {
        List<Cargo> lista = cargoDAO.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
    @GetMapping("/buscar-todos/{filtro}")
    public ResponseEntity<Object> buscarTodos(@PathVariable(value = "filtro") String filtro) {
        List<Cargo> lista = cargoDAO.findWithFilter(filtro);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Object> excluir(@PathVariable(value = "id") Long id) {
        cargoDAO.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping("/atualizar")
    public ResponseEntity<Cargo> atualizar(@RequestBody Cargo cargo) {
        System.out.println(cargo.getDescricao());
        // cargoDAO.findById(cargo.getId());
        return new ResponseEntity<>(cargo, HttpStatus.OK);
    }

}
