package org.example.softwarecine.repositories;

import org.example.softwarecine.models.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<Horario,Integer> {
}
