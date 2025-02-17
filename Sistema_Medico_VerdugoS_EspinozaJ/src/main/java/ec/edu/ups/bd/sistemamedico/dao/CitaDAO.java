/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.dao;

import ec.edu.ups.bd.sistemamedico.idao.ICitaDAO;
import ec.edu.ups.bd.sistemamedico.modelo.Cita;
import ec.edu.ups.bd.sistemamedico.modelo.Persona;
import ec.edu.ups.bd.sistemamedico.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO implements ICitaDAO{
    private Connection conexion;

    public CitaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void agregarCita(Cita cita) throws SQLException {
        String sql = "INSERT INTO sis_med_citas (cit_id, cit_fecha_hora, cit_estado, usu_id, per_id, per_id2) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, cita.getId());
            stmt.setTimestamp(2, new java.sql.Timestamp(cita.getFechaHora().getTime()));
            stmt.setString(3, cita.getEstado());
            stmt.setInt(4, cita.getUsuario().getUsuId());
            stmt.setInt(5, cita.getPaciente().getPerId());
            stmt.setInt(6, cita.getMedico().getPerId());
            stmt.executeUpdate();
        }
    }

    @Override
    public Cita buscarCita(int id) throws SQLException {
        String sql = "SELECT c.*, u.*, p1.*, p2.* FROM sis_med_citas c JOIN sis_med_usuarios u ON c.usu_id = u.usu_id JOIN sis_med_personas p1 ON c.per_id = p1.per_id JOIN sis_med_personas p2 ON c.per_id2 = p2.per_id WHERE c.cit_id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Usuario usuario = new UsuarioDAO(conexion).buscarUsuario(rs.getInt("usu_id"));
                Persona paciente = new PersonaDAO(conexion).buscarPersona(rs.getInt("per_id"));
                Persona medico = new PersonaDAO(conexion).buscarPersona(rs.getInt("per_id2"));
                return new Cita(
                    rs.getInt("cit_id"), rs.getTimestamp("cit_fecha_hora"), rs.getString("cit_estado"),
                    usuario, paciente, medico
                );
            }
            return null;
        }
    }

    @Override
    public List<Cita> listarCitas() throws SQLException {
        List<Cita> citas = new ArrayList<>();
        String sql = "SELECT c.*, u.*, p1.*, p2.* FROM sis_med_citas c JOIN sis_med_usuarios u ON c.usu_id = u.usu_id JOIN sis_med_personas p1 ON c.per_id = p1.per_id JOIN sis_med_personas p2 ON c.per_id2 = p2.per_id";
        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario usuario = new UsuarioDAO(conexion).buscarUsuario(rs.getInt("usu_id"));
                Persona paciente = new PersonaDAO(conexion).buscarPersona(rs.getInt("per_id"));
                Persona medico = new PersonaDAO(conexion).buscarPersona(rs.getInt("per_id2"));
                citas.add(new Cita(
                    rs.getInt("cit_id"), rs.getTimestamp("cit_fecha_hora"), rs.getString("cit_estado"),
                    usuario, paciente, medico
                ));
            }
        }
        return citas;
    }

    @Override
    public void actualizarCita(Cita cita) throws SQLException {
        String sql = "UPDATE sis_med_citas SET cit_fecha_hora = ?, cit_estado = ?, usu_id = ?, per_id = ?, per_id2 = ? WHERE cit_id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setTimestamp(1, new java.sql.Timestamp(cita.getFechaHora().getTime()));
            stmt.setString(2, cita.getEstado());
            stmt.setInt(3, cita.getUsuario().getUsuId());
            stmt.setInt(4, cita.getPaciente().getPerId());
            stmt.setInt(5, cita.getMedico().getPerId());
            stmt.setInt(6, cita.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminarCita(int id) throws SQLException {
        String sql = "DELETE FROM sis_med_citas WHERE cit_id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    
}

