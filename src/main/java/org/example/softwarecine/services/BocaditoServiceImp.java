package org.example.softwarecine.services;

import org.example.softwarecine.models.Bocadito;
import org.example.softwarecine.repositories.BocaditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BocaditoServiceImp implements BocaditoService{

    @Autowired
    BocaditoRepository bocaditoRepository;

    @Override
    public List<Bocadito> findAll() {
        return bocaditoRepository.findAll();
    }

    @Override
    public Optional<Bocadito> findById(Integer id) {
        return bocaditoRepository.findById(id);
    }

    @Override
    public Bocadito save(Bocadito bocadito) {
        return bocaditoRepository.save(bocadito);
    }

    @Override
    public Optional<Bocadito> update(Bocadito bocadito, Integer id) {

        Optional<Bocadito> bocaditoOp = this.findById(id);
        Bocadito bocaditoOptional = null;

        if(bocaditoOp.isPresent()){
            Bocadito bocaditoBD = bocaditoOp.orElseThrow();
            bocaditoBD.setNombre(bocadito.getNombre());
            bocaditoBD.setCategoria(bocadito.getCategoria());
            bocaditoBD.setDescripcion(bocadito.getDescripcion());
            bocaditoBD.setPrecio(bocadito.getPrecio());
            bocaditoOptional = save(bocaditoBD);
        }
        return Optional.ofNullable(bocaditoOptional);
    }

    @Override
    public Optional<Bocadito> updateState(Bocadito bocadito, Integer id) {

        Optional<Bocadito> bocaditoOp = this.findById(id);
        Bocadito bocaditoOptional = null;

        if(bocaditoOp.isPresent()){
            Bocadito bocaditoBD = bocaditoOp.orElseThrow();
            bocaditoBD.setEstado(bocadito.getEstado());
            bocaditoOptional = save(bocaditoBD);
        }
        return Optional.ofNullable(bocaditoOptional);
    }
}
