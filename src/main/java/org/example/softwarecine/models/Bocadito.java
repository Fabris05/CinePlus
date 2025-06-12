package org.example.softwarecine.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Bocadito")
public class Bocadito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBocadito;

    private String nombre;
    private String categoria;
    private int stock;
    private String descripcion;
    private Double precio;
    private String imagen;

    public Bocadito() {
    }

    public int getIdBocadito() {
        return idBocadito;
    }

    public void setIdBocadito(int idBocadito) {
        this.idBocadito = this.idBocadito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
