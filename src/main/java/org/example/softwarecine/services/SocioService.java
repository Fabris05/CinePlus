package org.example.softwarecine.services;

import org.example.softwarecine.models.Socio;

import java.util.List;
import java.util.Optional;

public interface SocioService {
    List<Socio> findAll();

    Socio save(Socio socio);

    Optional<Socio> findById(Integer id);

    Optional<Socio> update(Socio socio, Integer id);
}
