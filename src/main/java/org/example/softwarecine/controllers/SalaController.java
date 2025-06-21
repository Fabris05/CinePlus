package org.example.softwarecine.controllers;

import org.example.softwarecine.models.Sala;
import org.example.softwarecine.services.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/salas")
@CrossOrigin(origins = "*")
public class SalaController {

    @Autowired
    SalaService salaService;

    @GetMapping
    List<Sala> getSalas(){
        return salaService.findAll();
    }

}
