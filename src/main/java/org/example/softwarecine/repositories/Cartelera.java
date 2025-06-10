package org.example.softwarecine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cartelera extends JpaRepository<Cartelera, Integer> {
}
