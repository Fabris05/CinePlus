package org.example.softwarecine.repositories;

import org.example.softwarecine.models.ButacaSala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ButacaSalaRepository extends JpaRepository<ButacaSala, Integer> {
    List<ButacaSala> findBySala_IdSala(Integer idSala);
}
