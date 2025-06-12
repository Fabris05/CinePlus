package org.example.softwarecine.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Butaca")
public class Butaca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idButaca;

    private String codigo;

    public Butaca() {
    }

    public int getIdButaca() {
        return idButaca;
    }

    public void setIdButaca(int idButaca) {
        this.idButaca = idButaca;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
