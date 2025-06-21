package org.example.softwarecine.services;

import org.example.softwarecine.models.Bocadito;

import java.util.List;
import java.util.Optional;

public interface BocaditoService {
    List<Bocadito> findAll();

    Optional<Bocadito> findById(Integer id);

    Bocadito save(Bocadito bocadito);

    Optional<Bocadito> update(Bocadito bocadito, Integer id);
}
