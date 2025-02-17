/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.idao;

import ec.edu.ups.bd.sistemamedico.modelo.DetFactura;
import java.sql.SQLException;
import java.util.List;

public interface IDetFacturaDAO {
    void agregarDetalle(DetFactura detalle) throws SQLException;
    DetFactura buscarDetalle(int id) throws SQLException;
    List<DetFactura> listarDetalles() throws SQLException;
    void actualizarDetalle(DetFactura detalle) throws SQLException;
    void eliminarDetalle(int id) throws SQLException;
}
