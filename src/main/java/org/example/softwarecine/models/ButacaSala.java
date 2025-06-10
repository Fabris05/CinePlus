package org.example.softwarecine.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ButacaSala")
public class ButacaSala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idButacaSala;

    @ManyToOne
    @JoinColumn(name = "idButaca")
    private Butaca butaca;

    @ManyToOne
    @JoinColumn(name = "idSala")
    private Sala sala;

    private String estado;

    public ButacaSala() {
    }

    public int getIdButacaSala() {
        return idButacaSala;
    }

    public void setIdButacaSala(int idButacaSala) {
        this.idButacaSala = idButacaSala;
    }

    public Butaca getButaca() {
        return butaca;
    }

    public void setButaca(Butaca butaca) {
        this.butaca = butaca;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
