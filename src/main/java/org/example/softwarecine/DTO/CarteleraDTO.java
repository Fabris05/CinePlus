package org.example.softwarecine.DTO;

import org.example.softwarecine.models.Pelicula;
import org.example.softwarecine.models.Sala;

import java.util.List;

public class CarteleraDTO {
    private Integer idCartelera;
    private String fecha;
    private Pelicula pelicula;
    private Sala sala;
    private List<HorarioDTO> horarios;

    public Integer getIdCartelera() {
        return idCartelera;
    }

    public void setIdCartelera(Integer idCartelera) {
        this.idCartelera = idCartelera;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public List<HorarioDTO> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioDTO> horarios) {
        this.horarios = horarios;
    }
}
