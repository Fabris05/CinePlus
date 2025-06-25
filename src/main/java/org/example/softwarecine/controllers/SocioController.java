package org.example.softwarecine.controllers;

import org.example.softwarecine.models.Socio;
import org.example.softwarecine.services.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/socio")
@CrossOrigin(origins = "*")
public class SocioController {

    @Autowired
    SocioService socioService;

    @GetMapping
    List<Socio> getSocios(){
        return socioService.findAll();
    }

    @GetMapping("/{idSocio}")
    public ResponseEntity<?> findById(@PathVariable Integer idSocio){
        return socioService.findById(idSocio).map(socio -> ResponseEntity.ok(socio))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    ResponseEntity<?> saveSocio(@RequestBody Socio socio){
        return ResponseEntity.status(HttpStatus.CREATED).body(socioService.save(socio));
    }

    @PutMapping("/edit/{idSocio}")
    ResponseEntity<?> updateSocio(@RequestBody Socio socio, @PathVariable Integer idSocio){
        Optional<Socio> socioOp = socioService.update(socio, idSocio);
        if(socioOp.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(socioOp.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Socio no encontrado");
        }
    }
}
