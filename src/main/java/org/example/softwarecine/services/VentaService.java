package org.example.softwarecine.services;

import org.example.softwarecine.DTO.VentaDTO;
import org.example.softwarecine.models.Venta;

import java.util.List;

public interface VentaService {
    List<Venta> findAll();
    void procesarVenta(VentaDTO ventaDTO);
}
