package org.example.softwarecine.services;

import org.example.softwarecine.models.ButacaSala;
import org.example.softwarecine.repositories.ButacaSalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ButacaSalaImp implements ButacaSalaService{

    @Autowired
    ButacaSalaRepository butacaSalaRepository;

    @Override
    public List<ButacaSala> findBySala_Id(Integer idSala) {
        return butacaSalaRepository.findBySala_IdSala(idSala);
    }
}
