package org.example.softwarecine.controllers;

import org.example.softwarecine.models.Cartelera;
import org.example.softwarecine.models.CarteleraRequest;
import org.example.softwarecine.services.CarteleraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartelera")
@CrossOrigin(origins = "*")
public class CarteleraController {

    @Autowired
    CarteleraService carteleraService;

    @GetMapping
    List<Cartelera> findAll(){
        return carteleraService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCartelera(@RequestBody CarteleraRequest request) {
        carteleraService.crearCarteleraHorarios(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cartelera creada exitosamente");
    }
}
