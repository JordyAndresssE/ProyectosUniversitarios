package ec.edu.ups.bd.sistemamedico.controlador;

import ec.edu.ups.bd.sistemamedico.dao.FacturaDAO;
import ec.edu.ups.bd.sistemamedico.modelo.Factura;
import java.sql.SQLException;
import java.util.List;

public class FacturaControlador {
    private FacturaDAO facturaDAO;

    public FacturaControlador(FacturaDAO facturaDAO) {
        this.facturaDAO = facturaDAO;
    }

    public void agregarFactura(Factura factura) {
        try {
            facturaDAO.agregarFactura(factura);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Factura buscarFactura(int id) {
        try {
            return facturaDAO.buscarFactura(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Factura> listarFacturas() {
        try {
            return facturaDAO.listarFacturas();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void actualizarFactura(Factura factura) {
        try {
            facturaDAO.actualizarFactura(factura);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarFactura(int id) {
        try {
            facturaDAO.eliminarFactura(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
