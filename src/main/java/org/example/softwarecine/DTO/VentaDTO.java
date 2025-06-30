package org.example.softwarecine.DTO;

import java.util.List;

public class VentaDTO {
    private ClienteDTO cliente;
    private ReservaDTO reserva;
    private List<EntradaDTO> entradas;
    private List<BocaditoDTO> bocaditos;
    private VentaInfoDTO venta;

    public VentaDTO() {
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public ReservaDTO getReserva() {
        return reserva;
    }

    public void setReserva(ReservaDTO reserva) {
        this.reserva = reserva;
    }

    public List<EntradaDTO> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<EntradaDTO> entradas) {
        this.entradas = entradas;
    }

    public List<BocaditoDTO> getBocaditos() {
        return bocaditos;
    }

    public void setBocaditos(List<BocaditoDTO> bocaditos) {
        this.bocaditos = bocaditos;
    }

    public VentaInfoDTO getVenta() {
        return venta;
    }

    public void setVenta(VentaInfoDTO venta) {
        this.venta = venta;
    }
}
