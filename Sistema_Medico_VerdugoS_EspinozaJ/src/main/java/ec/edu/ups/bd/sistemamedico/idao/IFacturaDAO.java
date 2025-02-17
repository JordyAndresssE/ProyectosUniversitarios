/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.idao;

import ec.edu.ups.bd.sistemamedico.modelo.Factura;
import java.sql.SQLException;
import java.util.List;

public interface IFacturaDAO {
    void agregarFactura(Factura factura) throws SQLException;
    Factura buscarFactura(int id) throws SQLException;
    List<Factura> listarFacturas() throws SQLException;
    void actualizarFactura(Factura factura) throws SQLException;
    void eliminarFactura(int id) throws SQLException;
}
