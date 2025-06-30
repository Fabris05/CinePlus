package org.example.softwarecine.models;

import java.time.LocalDate;
import java.util.List;

public class CarteleraRequest {
    private Integer idPelicula;
    private Integer idSala;
    private LocalDate fecha;
    private List<Integer> idHorarios;

    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Integer> getIdHorarios() {
        return idHorarios;
    }

    public void setIdHorarios(List<Integer> idHorarios) {
        this.idHorarios = idHorarios;
    }
}
