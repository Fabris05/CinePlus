package org.example.softwarecine.controllers;

import org.example.softwarecine.DTO.CarteleraDTO;
import org.example.softwarecine.services.DetalleCarteleraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detallecartelera")
@CrossOrigin(origins = "*")
public class DetalleCarteleraController {

    @Autowired
    DetalleCarteleraService detalleCarteleraService;

    @GetMapping
    public ResponseEntity<List<CarteleraDTO>> getAllCartelera(){
        return ResponseEntity.ok(detalleCarteleraService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDetalleCartelera(@PathVariable Integer id){
        Optional<CarteleraDTO> detalle = detalleCarteleraService.findByIdCartelera(id);

        return detalle.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
