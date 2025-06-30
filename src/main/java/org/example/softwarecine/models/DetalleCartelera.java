package org.example.softwarecine.models;

import jakarta.persistence.*;

@Entity
@Table(name = "DetalleCartelera")
public class DetalleCartelera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalle;

    @ManyToOne
    @JoinColumn(name = "idCartelera")
    private Cartelera cartelera;

    @ManyToOne
    @JoinColumn(name = "idHorario")
    private Horario horario;

    public DetalleCartelera() {
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Cartelera getCartelera() {
        return cartelera;
    }

    public void setCartelera(Cartelera cartelera) {
        this.cartelera = cartelera;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
}
