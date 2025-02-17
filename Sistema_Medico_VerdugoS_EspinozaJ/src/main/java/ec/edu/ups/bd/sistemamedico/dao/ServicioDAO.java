/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.dao;

import ec.edu.ups.bd.sistemamedico.idao.IServicioDAO;
import ec.edu.ups.bd.sistemamedico.modelo.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServicioDAO implements IServicioDAO{
    private Connection conexion;

    public ServicioDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void agregarServicio(Servicio servicio) throws SQLException {
        String sql = "INSERT INTO sis_med_servicios (serv_id, serv_nombre, serv_precio, serv_aplicaiva, serv_estado) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, servicio.getId());
            stmt.setString(2, servicio.getNombre());
            stmt.setDouble(3, servicio.getPrecio());
            stmt.setString(4, servicio.getAplicaIVA());
            stmt.setString(5, servicio.getEstado());
            stmt.executeUpdate();
        }
    }

    @Override
    public Servicio buscarServicio(int id) throws SQLException {
        String sql = "SELECT * FROM sis_med_servicios WHERE serv_id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Servicio(
                    rs.getInt("serv_id"), rs.getString("serv_nombre"), rs.getDouble("serv_precio"),
                    rs.getString("serv_aplicaiva"), rs.getString("serv_estado")
                );
            }
            return null;
        }
    }

    @Override
    public List<Servicio> listarServicios() throws SQLException {
        List<Servicio> servicios = new ArrayList<>();
        String sql = "SELECT * FROM sis_med_servicios";
        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                servicios.add(new Servicio(
                    rs.getInt("serv_id"), rs.getString("serv_nombre"), rs.getDouble("serv_precio"),
                    rs.getString("serv_aplicaiva"), rs.getString("serv_estado")
                ));
            }
        }
        return servicios;
    }

    @Override
    public void actualizarServicio(Servicio servicio) throws SQLException {
        String sql = "UPDATE sis_med_servicios SET serv_nombre = ?, serv_precio = ?, serv_aplicaiva = ?, serv_estado = ? WHERE serv_id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, servicio.getNombre());
            stmt.setDouble(2, servicio.getPrecio());
            stmt.setString(3, servicio.getAplicaIVA());
            stmt.setString(4, servicio.getEstado());
            stmt.setInt(5, servicio.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminarServicio(int id) throws SQLException {
        String sql = "DELETE FROM sis_med_servicios WHERE serv_id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}