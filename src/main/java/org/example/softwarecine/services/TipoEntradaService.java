package org.example.softwarecine.services;

import org.example.softwarecine.models.TipoEntrada;

import java.util.List;
import java.util.Optional;

public interface TipoEntradaService {

    List<TipoEntrada> findAll();

    Optional<TipoEntrada> findById(Integer id);

    TipoEntrada save(TipoEntrada tipoEntrada);

    Optional<TipoEntrada> update(TipoEntrada tipoEntrada, Integer id);

}
