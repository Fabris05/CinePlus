package org.example.softwarecine.services;

import org.example.softwarecine.models.Pelicula;
import org.example.softwarecine.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImp implements PeliculaService{

    @Autowired
    PeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> findAll() {
        return peliculaRepository.findAll();
    }

    @Override
    public Optional<Pelicula> findById(Integer id) {
        return peliculaRepository.findById(id);
    }

    @Override
    public Pelicula save(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public Optional<Pelicula> update(Pelicula pelicula, Integer id) {

        Optional<Pelicula> peliculaOp = this.findById(id);
        Pelicula peliculaOptional = null;

        if(peliculaOp.isPresent()){
            Pelicula peliculaBD = peliculaOp.orElseThrow();
            peliculaBD.setNombre(pelicula.getNombre());
            peliculaBD.setDirector(pelicula.getDirector());
            peliculaBD.setClasificacion(pelicula.getClasificacion());
            peliculaBD.setGenero(pelicula.getGenero());
            peliculaBD.setDuracion(pelicula.getDuracion());

            peliculaOptional = save(peliculaBD);
        }

        return Optional.ofNullable(peliculaOptional);
    }

    @Override
    public Optional<Pelicula> updateState(Pelicula pelicula, Integer id) {
        Optional<Pelicula> peliculaOp = this.findById(id);
        Pelicula peliculaOptional = null;

        if(peliculaOp.isPresent()){
            Pelicula peliculaBD = peliculaOp.orElseThrow();
            peliculaBD.setEstado(pelicula.getEstado());
            peliculaOptional = save(peliculaBD);
        }

        return Optional.ofNullable(peliculaOptional);
    }
}
