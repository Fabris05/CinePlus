package org.example.softwarecine.DTO;

public class ButacaDTO {
    private int idButacaSala;
    private int idButaca;
    private String codigo;
    private String estado;

    public ButacaDTO() {
    }

    public int getIdButacaSala() {
        return idButacaSala;
    }

    public void setIdButacaSala(int idButacaSala) {
        this.idButacaSala = idButacaSala;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
