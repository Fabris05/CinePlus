package org.example.softwarecine.controllers;

import org.example.softwarecine.DTO.VentaDTO;
import org.example.softwarecine.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venta")
@CrossOrigin(origins = "*")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(ventaService.findAll());
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarVenta(@RequestBody VentaDTO ventaDTO){
        try{
            ventaService.procesarVenta(ventaDTO);
            return ResponseEntity.ok("Venta registrada exitosamente");
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error al registrar venta" + e.getMessage());
        }
    }

}
