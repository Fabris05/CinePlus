package org.example.softwarecine.repositories;

import org.example.softwarecine.models.Pelicula;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepositoryImplementation<Pelicula, Integer> {
}
