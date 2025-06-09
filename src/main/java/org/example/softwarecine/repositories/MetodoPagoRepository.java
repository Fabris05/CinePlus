package org.example.softwarecine.repositories;

import org.example.softwarecine.models.MetodoPago;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoPagoRepository extends CrudRepository<MetodoPago,Integer> {
}
