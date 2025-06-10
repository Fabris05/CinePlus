package org.example.softwarecine.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "DetalleEntrada")
public class DetalleEntrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleEntrada;

    @ManyToOne
    @JoinColumn(name = "idEntrada")
    @JsonBackReference
    private Entrada entrada;

    @ManyToOne
    @JoinColumn(name = "idButaca")
    private Butaca butaca;

    public DetalleEntrada() {
    }

    public int getIdDetalleEntrada() {
        return idDetalleEntrada;
    }

    public void setIdDetalleEntrada(int idDetalleEntrada) {
        this.idDetalleEntrada = idDetalleEntrada;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public Butaca getButaca() {
        return butaca;
    }

    public void setButaca(Butaca butaca) {
        this.butaca = butaca;
    }
}
