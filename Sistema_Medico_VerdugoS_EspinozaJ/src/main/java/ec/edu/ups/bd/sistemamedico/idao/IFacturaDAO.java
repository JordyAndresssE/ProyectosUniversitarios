/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.idao;

import ec.edu.ups.bd.sistemamedico.modelo.Factura;
import java.util.List;

public interface IFacturaDAO {
    void agregarFactura(Factura factura);
    Factura buscarFactura(int id);
    List<Factura> listarFacturas();
    void actualizarFactura(Factura factura);
    void eliminarFactura(int id);
}
