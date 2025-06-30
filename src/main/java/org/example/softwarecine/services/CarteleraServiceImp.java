package org.example.softwarecine.services;

import jakarta.transaction.Transactional;
import org.example.softwarecine.models.*;
import org.example.softwarecine.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteleraServiceImp implements CarteleraService {

    @Autowired
    CarteleraRepository carteleraRepository;

    @Autowired
    DetalleCarteleraRepository detalleCarteleraRepository;

    @Autowired
    PeliculaRepository peliculaRepository;

    @Autowired
    SalaRepository salaRepository;

    @Autowired
    HorarioRepository horarioRepository;

    @Override
    public List<Cartelera> findAll() {
        return carteleraRepository.findAll();
    }

    @Override
    public Cartelera save(Cartelera cartelera) {
        return carteleraRepository.save(cartelera);
    }

    @Override
    @Transactional
    public void crearCarteleraHorarios(CarteleraRequest resquest) {
        Pelicula pelicula = peliculaRepository.findById(resquest.getIdPelicula()).orElseThrow();
        Sala sala = salaRepository.findById(resquest.getIdSala()).orElseThrow();

        //guardamos la cartelera
        Cartelera cartelera = new Cartelera();
        cartelera.setPelicula(pelicula);
        cartelera.setSala(sala);
        cartelera.setFecha(resquest.getFecha());

        carteleraRepository.save(cartelera);

        // Guardamos cada detalle
        for(Integer idHorario : resquest.getIdHorarios()){
            Horario horario = horarioRepository.findById(idHorario).orElseThrow();

            DetalleCartelera detalleCartelera = new DetalleCartelera();
            detalleCartelera.setCartelera(cartelera);
            detalleCartelera.setHorario(horario);

            detalleCarteleraRepository.save(detalleCartelera);
        }
    }
}
