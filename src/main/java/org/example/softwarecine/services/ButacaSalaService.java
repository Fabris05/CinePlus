package org.example.softwarecine.services;

import org.example.softwarecine.models.ButacaSala;

import java.util.List;

public interface ButacaSalaService {
    List<ButacaSala> findBySala_Id(Integer idSala);
}
