package org.example.softwarecine.controllers;

import org.example.softwarecine.models.Socio;
import org.example.softwarecine.services.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/save")
    ResponseEntity<?> saveSocio(@RequestBody Socio socio){
        return ResponseEntity.status(HttpStatus.CREATED).body(socioService.save(socio));
    }

}
