package org.example.softwarecine.repositories;

import org.example.softwarecine.models.Rol;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepositoryImplementation<Rol,Integer> {
}
