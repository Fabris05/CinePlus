package org.example.softwarecine.controllers;

import org.example.softwarecine.models.ButacaSala;
import org.example.softwarecine.services.ButacaSalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/butacasala")
@CrossOrigin(origins = "*")
public class ButacaSalaController {

    @Autowired
    private ButacaSalaService butacaSalaService;

    @GetMapping("/sala/{idSala}")
    public List<ButacaSala> findBySala_Id(@PathVariable Integer idSala){
        return butacaSalaService.findBySala_Id(idSala);
    }
}
