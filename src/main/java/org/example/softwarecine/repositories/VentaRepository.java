package org.example.softwarecine.repositories;

import org.example.softwarecine.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta,Integer> {
}
