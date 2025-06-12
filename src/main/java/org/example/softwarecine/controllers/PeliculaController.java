package org.example.softwarecine.controllers;

import org.example.softwarecine.models.Pelicula;
import org.example.softwarecine.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
@CrossOrigin(origins = "*")
public class PeliculaController {

    @Autowired
    PeliculaService peliculaService;

    @GetMapping
    public List<Pelicula> getAllPeliculas(){
        return peliculaService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<?> savePelicula(@RequestBody Pelicula pelicula){
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaService.save(pelicula));
    }
}
