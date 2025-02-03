/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.dao;

import ec.edu.ups.bd.sistemamedico.modelo.DetFactura;
import java.util.ArrayList;
import java.util.List;

public class DetFacturaDAO {
    private List<DetFactura> detallesFactura = new ArrayList<>();

    public void agregarDetalle(DetFactura detalle) {
        detallesFactura.add(detalle);
    }

    public DetFactura buscarDetalle(int id) {
        return detallesFactura.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    public List<DetFactura> listarDetalles() {
        return detallesFactura;
    }

    public void actualizarDetalle(DetFactura detalleActualizado) {
        for (int i = 0; i < detallesFactura.size(); i++) {
            if (detallesFactura.get(i).getId() == detalleActualizado.getId()) {
                detallesFactura.set(i, detalleActualizado);
                break;
            }
        }
    }

    public void eliminarDetalle(int id) {
        detallesFactura.removeIf(d -> d.getId() == id);
    }
}
