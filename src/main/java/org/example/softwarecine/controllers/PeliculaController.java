package org.example.softwarecine.controllers;

import org.example.softwarecine.models.Pelicula;
import org.example.softwarecine.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("/edit/{idPelicula}")
    public ResponseEntity<?> update(@RequestBody Pelicula pelicula, @PathVariable Integer idPelicula){
        Optional<Pelicula> peliculaOptional =peliculaService.update(pelicula, idPelicula);

        if(peliculaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(peliculaOptional.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pelicula no encontrada");
        }
    }

    @PatchMapping("/edit/state/{idPelicula}")
    public ResponseEntity<?> updateState(@RequestBody Pelicula pelicula, @PathVariable Integer idPelicula){
        Optional<Pelicula> peliculaOptional =peliculaService.updateState(pelicula, idPelicula);

        if(peliculaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(peliculaOptional.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pelicula no encontrada");
        }
    }

    @GetMapping("/{idPelicula}")
    public ResponseEntity<?> findById(@PathVariable Integer idPelicula){

        Optional<Pelicula> peliculaOp = peliculaService.findById(idPelicula);

        if(peliculaOp.isPresent()){
            return ResponseEntity.ok(peliculaOp.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }
}
