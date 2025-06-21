package org.example.softwarecine.controllers;

import org.example.softwarecine.models.Usuario;
import org.example.softwarecine.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    List<Usuario> getAllUsuarios(){
        return usuarioService.findAll();
    }

    @PostMapping("/save")
    ResponseEntity<?> saveUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }
}
