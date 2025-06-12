package org.example.softwarecine.models;

import jakarta.persistence.*;

@Entity
@Table(name = "TipoEntrada")
public class TipoEntrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoEntrada;

    private String tipo;

    private Double precio;

    public TipoEntrada() {
    }

    public int getIdTipoEntrada() {
        return idTipoEntrada;
    }

    public void setIdTipoEntrada(int idTipoEntrada) {
        this.idTipoEntrada = this.idTipoEntrada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
