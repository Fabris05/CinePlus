package org.example.softwarecine.services;

import org.example.softwarecine.DTO.CarteleraDTO;
import org.example.softwarecine.DTO.HorarioDTO;
import org.example.softwarecine.models.DetalleCartelera;
import org.example.softwarecine.repositories.DetalleCarteleraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DetalleCarteleraImp implements DetalleCarteleraService{
    @Autowired
    DetalleCarteleraRepository detalleCarteleraRepository;

    @Override
    public List<CarteleraDTO> findAll() {
        List<DetalleCartelera> detalles = detalleCarteleraRepository.findAll();

        Map<Integer, CarteleraDTO> mapCartelera = new LinkedHashMap<>();

        for(DetalleCartelera detalle: detalles){
            Integer idCartelera = detalle.getCartelera().getIdcartelera();

            if(!mapCartelera.containsKey(idCartelera)){
                CarteleraDTO dto = new CarteleraDTO();
                dto.setIdCartelera(idCartelera);
                dto.setFecha(detalle.getCartelera().getFecha().toString());
                dto.setPelicula(detalle.getCartelera().getPelicula());
                dto.setSala(detalle.getCartelera().getSala());
                dto.setHorarios(new ArrayList<>());
                mapCartelera.put(idCartelera, dto);
            }

            HorarioDTO dtoHorario = new HorarioDTO();
            dtoHorario.setIdHorario(detalle.getHorario().getIdHorario());
            dtoHorario.setHora(detalle.getHorario().getHora().toString());

            mapCartelera.get(idCartelera).getHorarios().add(dtoHorario);
        }
        return new ArrayList<>(mapCartelera.values());
    }

    @Override
    public Optional<CarteleraDTO> findByIdCartelera(Integer idCartelera) {
        List<DetalleCartelera> detalles = detalleCarteleraRepository.findByCarteleraIdCartelera(idCartelera);

        if (detalles.isEmpty()) {
            return Optional.empty();
        }

        CarteleraDTO dto = new CarteleraDTO();
        dto.setIdCartelera(idCartelera);
        dto.setFecha(detalles.get(0).getCartelera().getFecha().toString());
        dto.setPelicula(detalles.get(0).getCartelera().getPelicula());
        dto.setSala(detalles.get(0).getCartelera().getSala());
        dto.setHorarios(new ArrayList<>());

        for (DetalleCartelera detalle : detalles) {
            HorarioDTO dtoHorario = new HorarioDTO();
            dtoHorario.setIdHorario(detalle.getHorario().getIdHorario());
            dtoHorario.setHora(detalle.getHorario().getHora().toString());
            dto.getHorarios().add(dtoHorario);
        }

        return Optional.of(dto);
    }
}
