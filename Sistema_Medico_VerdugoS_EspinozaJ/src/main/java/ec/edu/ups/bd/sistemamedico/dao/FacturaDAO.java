/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.dao;

import ec.edu.ups.bd.sistemamedico.idao.IFacturaDAO;
import ec.edu.ups.bd.sistemamedico.modelo.Factura;
import ec.edu.ups.bd.sistemamedico.modelo.Persona;
import ec.edu.ups.bd.sistemamedico.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO implements IFacturaDAO{
    private Connection conexion;

    public FacturaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void agregarFactura(Factura factura) throws SQLException {
        String sql = "INSERT INTO sis_med_facturas (fac_id, fac_numero, fac_fecha_emision, fac_subtotal, fac_iva, fac_total, usu_id, per_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, factura.getId());
            stmt.setInt(2, factura.getNumero());
            stmt.setDate(3, new java.sql.Date(factura.getFechaEmision().getTime()));
            stmt.setDouble(4, factura.getSubtotal());
            stmt.setDouble(5, factura.getIva());
            stmt.setDouble(6, factura.getTotal());
            stmt.setInt(7, factura.getUsuario().getUsuId());
            stmt.setInt(8, factura.getPaciente().getPerId());
            stmt.executeUpdate();
        }
    }

    @Override
    public Factura buscarFactura(int id) throws SQLException {
        String sql = "SELECT f.*, p.*, u.* FROM sis_med_facturas f JOIN sis_med_personas p ON f.per_id = p.per_id JOIN sis_med_usuarios u ON f.usu_id = u.usu_id WHERE f.fac_id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Persona paciente = new PersonaDAO(conexion).buscarPersona(rs.getInt("per_id"));
                Usuario usuario = new UsuarioDAO(conexion).buscarUsuario(rs.getInt("usu_id"));
                return new Factura(
                    rs.getInt("fac_id"), rs.getInt("fac_numero"), rs.getDate("fac_fecha_emision"),
                    rs.getDouble("fac_subtotal"), rs.getDouble("fac_iva"), rs.getDouble("fac_total"),
                    paciente, usuario, null
                );
            }
            return null;
        }
    }

    @Override
    public List<Factura> listarFacturas() throws SQLException {
        List<Factura> facturas = new ArrayList<>();
        String sql = "SELECT f.*, p.*, u.* FROM sis_med_facturas f JOIN sis_med_personas p ON f.per_id = p.per_id JOIN sis_med_usuarios u ON f.usu_id = u.usu_id";
        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Persona paciente = new PersonaDAO(conexion).buscarPersona(rs.getInt("per_id"));
                Usuario usuario = new UsuarioDAO(conexion).buscarUsuario(rs.getInt("usu_id"));
                facturas.add(new Factura(
                    rs.getInt("fac_id"), rs.getInt("fac_numero"), rs.getDate("fac_fecha_emision"),
                    rs.getDouble("fac_subtotal"), rs.getDouble("fac_iva"), rs.getDouble("fac_total"),
                    paciente, usuario, null
                ));
            }
        }
        return facturas;
    }

    @Override
    public void actualizarFactura(Factura factura) throws SQLException {
        String sql = "UPDATE sis_med_facturas SET fac_numero = ?, fac_fecha_emision = ?, fac_subtotal = ?, fac_iva = ?, fac_total = ?, usu_id = ?, per_id = ? WHERE fac_id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, factura.getNumero());
            stmt.setDate(2, new java.sql.Date(factura.getFechaEmision().getTime()));
            stmt.setDouble(3, factura.getSubtotal());
            stmt.setDouble(4, factura.getIva());
            stmt.setDouble(5, factura.getTotal());
            stmt.setInt(6, factura.getUsuario().getUsuId());
            stmt.setInt(7, factura.getPaciente().getPerId());
            stmt.setInt(8, factura.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminarFactura(int id) throws SQLException {
        String sql = "DELETE FROM sis_med_facturas WHERE fac_id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    
}

