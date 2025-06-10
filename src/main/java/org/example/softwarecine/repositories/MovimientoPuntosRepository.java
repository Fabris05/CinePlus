package org.example.softwarecine.repositories;

import org.example.softwarecine.models.MovimientoPuntos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoPuntosRepository extends JpaRepository<MovimientoPuntos, Integer> {
}
