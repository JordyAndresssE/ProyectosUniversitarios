package ec.edu.ups.bd.sistemamedico.controlador;

import ec.edu.ups.bd.sistemamedico.dao.FacturaDAO;
import ec.edu.ups.bd.sistemamedico.modelo.Factura;
import java.util.List;

public class FacturaControlador {
    private FacturaDAO facturaDAO;

    public FacturaControlador(FacturaDAO facturaDAO) {
        this.facturaDAO = facturaDAO;
    }

    public void agregarFactura(Factura factura) {
        facturaDAO.agregarFactura(factura);
    }

    public Factura buscarFactura(int id) {
        return facturaDAO.buscarFactura(id);
    }

    public List<Factura> listarFacturas() {
        return facturaDAO.listarFacturas();
    }

    public void actualizarFactura(Factura factura) {
        facturaDAO.actualizarFactura(factura);
    }

    public void eliminarFactura(int id) {
        facturaDAO.eliminarFactura(id);
    }
}
