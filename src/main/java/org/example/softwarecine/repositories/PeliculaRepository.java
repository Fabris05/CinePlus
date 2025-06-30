package org.example.softwarecine.repositories;

import org.example.softwarecine.models.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
    List<Pelicula> findByEstado(String estado);
}
