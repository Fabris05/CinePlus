package org.example.softwarecine.services;


import org.example.softwarecine.models.TipoEntrada;
import org.example.softwarecine.repositories.TipoEntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoEntradaServiceImp implements TipoEntradaService{

    @Autowired
    TipoEntradaRepository tipoEntradaRepository;

    @Override
    public List<TipoEntrada> findAll() {
        return tipoEntradaRepository.findAll();
    }

    @Override
    public Optional<TipoEntrada> findById(Integer id) {
        return tipoEntradaRepository.findById(id);
    }

    @Override
    public TipoEntrada save(TipoEntrada tipoEntrada) {
        return tipoEntradaRepository.save(tipoEntrada);
    }

    @Override
    public Optional<TipoEntrada> update(TipoEntrada tipoEntrada, Integer id) {
        return Optional.empty();
    }
}
