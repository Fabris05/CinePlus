package org.example.softwarecine.controllers;

import org.example.softwarecine.models.TipoEntrada;
import org.example.softwarecine.services.TipoEntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipoentrada")
@CrossOrigin(origins = "*")
public class TipoEntradaController {

    @Autowired
    TipoEntradaService tipoEntradaService;

    @GetMapping
    public List<TipoEntrada> getAllTipoEntradas(){
        return tipoEntradaService.findAll();
    }

    @GetMapping("/{idTipoEntrada}")
    public ResponseEntity<?> findById(@PathVariable Integer idTipoEntrada){
        Optional<TipoEntrada> tipoEntradaOp = tipoEntradaService.findById(idTipoEntrada);
        if(tipoEntradaOp.isPresent()){
            return ResponseEntity.ok(tipoEntradaOp.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    ResponseEntity<?> saveTipoEntrada(@RequestBody TipoEntrada tipoEntrada){
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoEntradaService.save(tipoEntrada));
    }

    @PutMapping("/edit/{idTipoEntrada}")
    public ResponseEntity<?> update(@PathVariable Integer idTipoEntrada, @RequestBody TipoEntrada tipoEntrada){
        Optional<TipoEntrada> tipoEntradaOp = tipoEntradaService.update(tipoEntrada, idTipoEntrada);

        if(tipoEntradaOp.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(tipoEntradaOp.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de Entrada no encontrado");
        }
    }

    @PatchMapping("/edit/state/{idTipoEntrada}")
    public ResponseEntity<?> updateState(@PathVariable Integer idTipoEntrada, @RequestBody TipoEntrada tipoEntrada){
        Optional<TipoEntrada> tipoEntradaOp = tipoEntradaService.updateState(tipoEntrada, idTipoEntrada);

        if(tipoEntradaOp.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(tipoEntradaOp.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de Entrada no encontrado");
        }
    }

}
