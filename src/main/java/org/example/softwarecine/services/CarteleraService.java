package org.example.softwarecine.services;

import org.example.softwarecine.models.Cartelera;
import org.example.softwarecine.models.CarteleraRequest;

import java.util.List;

public interface CarteleraService {

    List<Cartelera> findAll();
    Cartelera save(Cartelera cartelera);
    void crearCarteleraHorarios(CarteleraRequest resquest);
}
