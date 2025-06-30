package org.example.softwarecine.DTO;

import java.util.List;

public class ReservaDTO {
    private int idCartelera;
    private HorarioDTO horario;
    private SalaDTO sala;
    private PeliculaDTO pelicula;
    private List<ButacaDTO> butacas;

    public ReservaDTO() {
    }

    public int getIdCartelera() {
        return idCartelera;
    }

    public void setIdCartelera(int idCartelera) {
        this.idCartelera = idCartelera;
    }

    public HorarioDTO getHorario() {
        return horario;
    }

    public void setHorario(HorarioDTO horario) {
        this.horario = horario;
    }

    public SalaDTO getSala() {
        return sala;
    }

    public void setSala(SalaDTO sala) {
        this.sala = sala;
    }

    public PeliculaDTO getPelicula() {
        return pelicula;
    }

    public void setPelicula(PeliculaDTO pelicula) {
        this.pelicula = pelicula;
    }

    public List<ButacaDTO> getButacas() {
        return butacas;
    }

    public void setButacas(List<ButacaDTO> butacas) {
        this.butacas = butacas;
    }
}
