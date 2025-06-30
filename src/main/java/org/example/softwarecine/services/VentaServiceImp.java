package org.example.softwarecine.services;

import jakarta.transaction.Transactional;
import org.example.softwarecine.DTO.BocaditoDTO;
import org.example.softwarecine.DTO.ButacaDTO;
import org.example.softwarecine.DTO.EntradaDTO;
import org.example.softwarecine.DTO.VentaDTO;
import org.example.softwarecine.models.*;
import org.example.softwarecine.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VentaServiceImp implements VentaService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EntradaRepository entradaRepository;

    @Autowired
    private DetalleEntradaRepository detalleEntradaRepository;

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Autowired
    private BocaditoRepository bocaditoRepository;

    @Autowired
    private ButacaRepository butacaRepository;

    @Autowired
    private TipoEntradaRepository tipoEntradaRepository;

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private CarteleraRepository carteleraRepository;

    @Override
    public List<Venta> findAll() {
        return ventaRepository.findAll();
    }

    @Override
    @Transactional
    public void procesarVenta(VentaDTO ventaDTO) {
        // 1. Registrar Cliente
        Cliente cliente = new Cliente();
        cliente.setNombre(ventaDTO.getCliente().getNombre());
        cliente.setApellido(ventaDTO.getCliente().getApellido());
        cliente.setEmail(ventaDTO.getCliente().getEmail());
        cliente.setTipoDocumento(ventaDTO.getCliente().getTipoDocumento());
        cliente.setNumDocumento(ventaDTO.getCliente().getNumDocumento());
        clienteRepository.save(cliente);

        // 2. Registrar Entrada (si existe)
        Entrada entrada = null;
        if (!ventaDTO.getEntradas().isEmpty()) {
            EntradaDTO entradaDTO = ventaDTO.getEntradas().get(0);
            entrada = new Entrada();

            Cartelera cartelera = carteleraRepository.findById(ventaDTO.getReserva().getIdCartelera())
                    .orElseThrow(() -> new RuntimeException("Cartelera no encontrada"));
            entrada.setCartelera(cartelera);

            TipoEntrada tipoEntrada = tipoEntradaRepository.findById(entradaDTO.getIdTipoEntrada())
                    .orElseThrow(() -> new RuntimeException("Tipo de entrada no encontrado"));
            entrada.setTipoEntrada(tipoEntrada);
            entradaRepository.save(entrada);

            // 3. Registrar Detalles de Entrada (butacas)
            for (ButacaDTO butacaDTO : ventaDTO.getReserva().getButacas()) {
                Butaca butaca = butacaRepository.findById(butacaDTO.getIdButaca())
                        .orElseThrow(() -> new RuntimeException("Butaca no encontrada"));

                DetalleEntrada detalleEntrada = new DetalleEntrada();
                detalleEntrada.setEntrada(entrada);
                detalleEntrada.setButaca(butaca);
                detalleEntradaRepository.save(detalleEntrada);
            }
        }

        // 4. Registrar Venta
        Venta venta = new Venta();
        venta.setCliente(cliente);

        // Socio y Usuario por defecto
        venta.setSocio(socioRepository.findById(0).orElse(null));
        venta.setUsuario(usuarioRepository.findById(0).orElse(null));
        venta.setMetodoPago(metodoPagoRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Método de pago no encontrado")));

        venta.setFecha(LocalDateTime.parse(ventaDTO.getVenta().getFecha()));
        venta.setTotal(ventaDTO.getVenta().getTotal());
        venta.setEstado("Procesado");
        ventaRepository.save(venta);

        // 5. Registrar DetalleVenta - Entradas
        if (entrada != null) {
            for (EntradaDTO e : ventaDTO.getEntradas()) {
                DetalleVenta dv = new DetalleVenta();
                dv.setVenta(venta);
                dv.setEntrada(entrada);
                dv.setBocadito(null);
                dv.setCantidad(e.getCantidad());
                dv.setTotal(e.getCantidad() * entrada.getTipoEntrada().getPrecio());
                detalleVentaRepository.save(dv);
            }
        }

        // 6. Registrar DetalleVenta - Bocaditos
        for (BocaditoDTO b : ventaDTO.getBocaditos()) {
            System.out.println("buscando idBocadito: "+b.getIdBocadito());
            Bocadito bocadito = bocaditoRepository.findById(b.getIdBocadito())
                    .orElseThrow(() -> new RuntimeException("Bocadito no encontrado"));

            DetalleVenta dv = new DetalleVenta();
            dv.setVenta(venta);
            dv.setEntrada(null); // no aplica
            dv.setBocadito(bocadito);
            dv.setCantidad(b.getCantidad());
            dv.setTotal(b.getTotal());
            detalleVentaRepository.save(dv);
        }
    }
}
