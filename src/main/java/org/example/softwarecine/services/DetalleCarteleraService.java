package org.example.softwarecine.services;

import org.example.softwarecine.DTO.CarteleraDTO;
import org.example.softwarecine.models.DetalleCartelera;

import java.util.List;
import java.util.Optional;

public interface DetalleCarteleraService {
    List<CarteleraDTO> findAll();

    Optional<CarteleraDTO> findByIdCartelera(Integer idDetalle);
}
