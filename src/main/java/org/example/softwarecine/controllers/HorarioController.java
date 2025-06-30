package org.example.softwarecine.controllers;

import org.example.softwarecine.models.Horario;
import org.example.softwarecine.services.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/horario")
@CrossOrigin(origins = "*")
public class HorarioController {

    @Autowired
    HorarioService horarioService;

    @GetMapping
    public List<Horario> findAll(){
        return horarioService.findAll();
    }

}
