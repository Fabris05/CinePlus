package org.example.softwarecine.services;

import org.example.softwarecine.models.Sala;
import org.example.softwarecine.repositories.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaServiceImp implements SalaService{

    @Autowired
    SalaRepository salaRepository;

    @Override
    public List<Sala> findAll() {
        return salaRepository.findAll();
    }
}
