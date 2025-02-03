package ec.edu.ups.bd.sistemamedico.controlador;

import ec.edu.ups.bd.sistemamedico.dao.DetFacturaDAO;
import ec.edu.ups.bd.sistemamedico.modelo.DetFactura;
import java.util.List;

public class DetFacturaControlador {
    private DetFacturaDAO detFacturaDAO;

    public DetFacturaControlador(DetFacturaDAO detFacturaDAO) {
        this.detFacturaDAO = detFacturaDAO;
    }

    public void agregarDetalle(DetFactura detalle) {
        detFacturaDAO.agregarDetalle(detalle);
    }

    public DetFactura buscarDetalle(int id) {
        return detFacturaDAO.buscarDetalle(id);
    }

    public List<DetFactura> listarDetalles() {
        return detFacturaDAO.listarDetalles();
    }

    public void actualizarDetalle(DetFactura detalle) {
        detFacturaDAO.actualizarDetalle(detalle);
    }

    public void eliminarDetalle(int id) {
        detFacturaDAO.eliminarDetalle(id);
    }
}
