package org.example.softwarecine.repositories;

import org.example.softwarecine.models.ButacaSala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ButacaSalaRepository extends JpaRepository<ButacaSala, Integer> {
}
