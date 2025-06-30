package org.example.softwarecine.repositories;

import org.example.softwarecine.models.DetalleCartelera;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;

public interface DetalleCarteleraRepository extends JpaRepositoryImplementation<DetalleCartelera, Integer> {
    List<DetalleCartelera> findByCarteleraIdCartelera(Integer idCartelera);
}
