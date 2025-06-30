package org.example.softwarecine.services;

import org.example.softwarecine.models.Horario;
import org.example.softwarecine.repositories.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioImp implements HorarioService{

    @Autowired
    HorarioRepository horarioRepository;


    @Override
    public List<Horario> findAll() {
        return horarioRepository.findAll();
    }
}
