package org.example.softwarecine.DTO;

public class BocaditoDTO {
    private int idBocadito;
    private String nombre;
    private int cantidad;
    private double precio;
    private double total;

    public BocaditoDTO() {
    }

    public int getIdBocadito() {
        return idBocadito;
    }

    public void setIdBocadito(int idBocadito) {
        this.idBocadito = idBocadito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
