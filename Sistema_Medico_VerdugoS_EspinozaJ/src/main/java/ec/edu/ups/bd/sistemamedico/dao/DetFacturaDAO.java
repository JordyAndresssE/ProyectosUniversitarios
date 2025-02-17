/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.dao;

import ec.edu.ups.bd.sistemamedico.idao.IDetFacturaDAO;
import ec.edu.ups.bd.sistemamedico.modelo.DetFactura;
import ec.edu.ups.bd.sistemamedico.modelo.Factura;
import ec.edu.ups.bd.sistemamedico.modelo.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DetFacturaDAO implements IDetFacturaDAO{
    private Connection conexion;

    public DetFacturaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void agregarDetalle(DetFactura detalle) throws SQLException {
        String sql = "INSERT INTO sis_med_detalle_facturas (det_fac_id, det_fac_cantidad, det_fac_precio_unitario, det_fac_subtotal, det_fac_iva, det_fac_total, fac_id, serv_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, detalle.getId());
            stmt.setInt(2, detalle.getCantidad());
            stmt.setDouble(3, detalle.getPrecioUnitario());
            stmt.setDouble(4, detalle.getSubtotal());
            stmt.setDouble(5, detalle.getIva());
            stmt.setDouble(6, detalle.getTotal());
            stmt.setInt(7, detalle.getFactura().getId());
            stmt.setInt(8, detalle.getServicio().getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public DetFactura buscarDetalle(int id) throws SQLException {
        String sql = "SELECT d.*, f.*, s.* FROM sis_med_detalle_facturas d JOIN sis_med_facturas f ON d.fac_id = f.fac_id JOIN sis_med_servicios s ON d.serv_id = s.serv_id WHERE d.det_fac_id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Factura factura = new FacturaDAO(conexion).buscarFactura(rs.getInt("fac_id"));
                Servicio servicio = new ServicioDAO(conexion).buscarServicio(rs.getInt("serv_id"));
                return new DetFactura(
                    rs.getInt("det_fac_id"), rs.getInt("det_fac_cantidad"), rs.getDouble("det_fac_precio_unitario"),
                    rs.getDouble("det_fac_subtotal"), rs.getDouble("det_fac_iva"), rs.getDouble("det_fac_total"),
                    factura, servicio
                );
            }
            return null;
        }
    }

    @Override
    public List<DetFactura> listarDetalles() throws SQLException {
        List<DetFactura> detalles = new ArrayList<>();
        String sql = "SELECT d.*, f.*, s.* FROM sis_med_detalle_facturas d JOIN sis_med_facturas f ON d.fac_id = f.fac_id JOIN sis_med_servicios s ON d.serv_id = s.serv_id";
        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Factura factura = new FacturaDAO(conexion).buscarFactura(rs.getInt("fac_id"));
                Servicio servicio = new ServicioDAO(conexion).buscarServicio(rs.getInt("serv_id"));
                detalles.add(new DetFactura(
                    rs.getInt("det_fac_id"), rs.getInt("det_fac_cantidad"), rs.getDouble("det_fac_precio_unitario"),
                    rs.getDouble("det_fac_subtotal"), rs.getDouble("det_fac_iva"), rs.getDouble("det_fac_total"),
                    factura, servicio
                ));
            }
        }
        return detalles;
    }

    @Override
    public void actualizarDetalle(DetFactura detalle) throws SQLException {
        String sql = "UPDATE sis_med_detalle_facturas SET det_fac_cantidad = ?, det_fac_precio_unitario = ?, det_fac_subtotal = ?, det_fac_iva = ?, det_fac_total = ?, fac_id = ?, serv_id = ? WHERE det_fac_id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, detalle.getCantidad());
            stmt.setDouble(2, detalle.getPrecioUnitario());
            stmt.setDouble(3, detalle.getSubtotal());
            stmt.setDouble(4, detalle.getIva());
            stmt.setDouble(5, detalle.getTotal());
            stmt.setInt(6, detalle.getFactura().getId());
            stmt.setInt(7, detalle.getServicio().getId());
            stmt.setInt(8, detalle.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminarDetalle(int id) throws SQLException {
        String sql = "DELETE FROM sis_med_detalle_facturas WHERE det_fac_id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }  
}
