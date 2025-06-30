package org.example.softwarecine.services;

import org.example.softwarecine.models.Pelicula;

import java.util.List;
import java.util.Optional;

public interface PeliculaService {

    List<Pelicula> findAll();

    List<Pelicula> findByEstado(String estado);

    Optional<Pelicula> findById(Integer id);

    Pelicula save(Pelicula pelicula);

    Optional<Pelicula> update(Pelicula pelicula, Integer id);

    Optional<Pelicula> updateState(Pelicula pelicula, Integer id);
}
