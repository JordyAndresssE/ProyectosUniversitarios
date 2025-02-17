package ec.edu.ups.bd.sistemamedico.controlador;

import ec.edu.ups.bd.sistemamedico.dao.DetFacturaDAO;
import ec.edu.ups.bd.sistemamedico.modelo.DetFactura;
import java.sql.SQLException;
import java.util.List;

public class DetFacturaControlador {
    private DetFacturaDAO detFacturaDAO;

    public DetFacturaControlador(DetFacturaDAO detFacturaDAO) {
        this.detFacturaDAO = detFacturaDAO;
    }

    public void agregarDetalle(DetFactura detalle) {
        try {
            detFacturaDAO.agregarDetalle(detalle);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DetFactura buscarDetalle(int id) {
        try {
            return detFacturaDAO.buscarDetalle(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<DetFactura> listarDetalles() {
        try {
            return detFacturaDAO.listarDetalles();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void actualizarDetalle(DetFactura detalle) {
        try {
            detFacturaDAO.actualizarDetalle(detalle);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarDetalle(int id) {
        try {
            detFacturaDAO.eliminarDetalle(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
