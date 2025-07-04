package org.example.softwarecine.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Cartelera")
public class Cartelera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCartelera;

    @ManyToOne
    @JoinColumn(name = "idPelicula")
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "idSala")
    private Sala sala;

    private LocalDate fecha;

    public Cartelera() {
    }

    public Integer getIdcartelera() {
        return idCartelera;
    }

    public void setIdCartelera(Integer idCartelera) {
        this.idCartelera = idCartelera;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
