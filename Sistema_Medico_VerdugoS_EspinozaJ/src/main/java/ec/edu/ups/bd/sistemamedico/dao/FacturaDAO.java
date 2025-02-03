/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.dao;

import ec.edu.ups.bd.sistemamedico.modelo.Factura;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {
    private List<Factura> facturas = new ArrayList<>();

    public void agregarFactura(Factura factura) {
        facturas.add(factura);
    }

    public Factura buscarFactura(int id) {
        return facturas.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
    }

    public List<Factura> listarFacturas() {
        return facturas;
    }

    public void actualizarFactura(Factura facturaActualizada) {
        for (int i = 0; i < facturas.size(); i++) {
            if (facturas.get(i).getId() == facturaActualizada.getId()) {
                facturas.set(i, facturaActualizada);
                break;
            }
        }
    }

    public void eliminarFactura(int id) {
        facturas.removeIf(f -> f.getId() == id);
    }
}
