package org.example.softwarecine.controllers;

import org.example.softwarecine.models.Usuario;
import org.example.softwarecine.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<?> findById(@PathVariable Integer idUsuario) {
        Optional<Usuario> usuarioOp = usuarioService.findById(idUsuario);
        if (usuarioOp.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioOp.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");

    }

    @PostMapping("/save")
    ResponseEntity<?> saveUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }

    @PutMapping("/edit/{idUsuario}")
    ResponseEntity<?> updateUsuario(@RequestBody Usuario usuario, @PathVariable Integer idUsuario) {
        Optional<Usuario> usuarioOp = usuarioService.update(usuario, idUsuario);
        if (usuarioOp.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioOp.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }
}
