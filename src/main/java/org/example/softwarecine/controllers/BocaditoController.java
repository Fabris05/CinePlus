package org.example.softwarecine.controllers;

import org.example.softwarecine.models.Bocadito;
import org.example.softwarecine.services.BocaditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bocaditos")
@CrossOrigin(origins = "*")
public class BocaditoController {

    @Autowired
    BocaditoService bocaditoService;

    @GetMapping
    public List<Bocadito> getAllBocaditos(){
        return bocaditoService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveBocadito(@RequestBody Bocadito bocadito){
        return ResponseEntity.status(HttpStatus.CREATED).body(bocaditoService.save(bocadito));
    }

    @PatchMapping("/edit/state/{idBocadito}")
    public ResponseEntity<?> updateState(@PathVariable Integer idBocadito, @RequestBody Bocadito bocadito){
        Optional<Bocadito> bocaditoOptional = bocaditoService.updateState(bocadito, idBocadito);
        if(bocaditoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(bocaditoOptional.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bocadito no encontrado");
        }
    }

    @PutMapping("/edit/{idBocadito}")
    public ResponseEntity<?> updateMovie(@PathVariable Integer idBocadito, @RequestBody Bocadito bocadito){
        Optional<Bocadito> bocaditoOptional = bocaditoService.update(bocadito, idBocadito);
        if(bocaditoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(bocaditoOptional.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bocadito no encontrado");
        }
    }

    @GetMapping("/{idBocadito}")
    public ResponseEntity<?> findById(@PathVariable Integer idBocadito){
        Optional<Bocadito> bocaditoOp = bocaditoService.findById(idBocadito);
        if(bocaditoOp.isPresent()){
            return ResponseEntity.ok(bocaditoOp.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
