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

        Optional<TipoEntrada> tipoEntradaOp = this.findById(id);
        TipoEntrada tipoEntradaOptional = null;

        if(tipoEntradaOp.isPresent()){
            TipoEntrada tipoEntradaBD = tipoEntradaOp.orElseThrow();
            tipoEntradaBD.setTipo(tipoEntrada.getTipo());
            tipoEntradaBD.setDescripcion(tipoEntrada.getDescripcion());
            tipoEntradaBD.setPrecio(tipoEntrada.getPrecio());
            tipoEntradaOptional = save(tipoEntradaBD);
        }
        return Optional.ofNullable(tipoEntradaOptional);
    }

    @Override
    public Optional<TipoEntrada> updateState(TipoEntrada tipoEntrada, Integer id) {

        Optional<TipoEntrada> tipoEntradaOp = this.findById(id);

        TipoEntrada tipoEntradaOptional = null;

        if(tipoEntradaOp.isPresent()){
            TipoEntrada tipoEntradaBD = tipoEntradaOp.orElseThrow();
            tipoEntradaBD.setEstado(tipoEntrada.getEstado());
            tipoEntradaOptional = save(tipoEntradaBD);
        }
        return Optional.ofNullable(tipoEntradaOptional);
    }
}
