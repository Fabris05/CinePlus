package org.example.softwarecine.controllers;

import org.example.softwarecine.models.Bocadito;
import org.example.softwarecine.services.BocaditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
