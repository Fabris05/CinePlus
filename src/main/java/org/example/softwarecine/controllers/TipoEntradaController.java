package org.example.softwarecine.controllers;

import org.example.softwarecine.models.TipoEntrada;
import org.example.softwarecine.services.TipoEntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/save")
    ResponseEntity<?> saveTipoEntrada(@RequestBody TipoEntrada tipoEntrada){
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoEntradaService.save(tipoEntrada));
    }
}
