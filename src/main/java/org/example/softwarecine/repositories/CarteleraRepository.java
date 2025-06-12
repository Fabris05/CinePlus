package org.example.softwarecine.repositories;

import org.example.softwarecine.models.Cartelera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteleraRepository extends JpaRepository<Cartelera, Integer> {
}
