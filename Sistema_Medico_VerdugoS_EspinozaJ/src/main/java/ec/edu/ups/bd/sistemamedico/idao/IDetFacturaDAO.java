/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.idao;

import ec.edu.ups.bd.sistemamedico.modelo.DetFactura;
import java.util.List;

public interface IDetFacturaDAO {
    void agregarDetalle(DetFactura detalle);
    DetFactura buscarDetalle(int id);
    List<DetFactura> listarDetalles();
    void actualizarDetalle(DetFactura detalle);
    void eliminarDetalle(int id);
}
