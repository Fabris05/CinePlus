package org.example.softwarecine.repositories;

import org.example.softwarecine.models.DetalleEntrada;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleEntradaRepository extends JpaRepositoryImplementation<DetalleEntrada, Integer> {
}

