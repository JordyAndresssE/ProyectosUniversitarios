/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.dao;

import ec.edu.ups.bd.sistemamedico.idao.IPersonaDAO;
import ec.edu.ups.bd.sistemamedico.modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO implements IPersonaDAO{
    private Connection conexion;

    public PersonaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void agregarPersona(Persona persona) throws SQLException {
        String sql = "INSERT INTO sis_med_personas (per_id, per_cedula, per_nombres, per_apellidos, per_direccion, per_telefono, per_correo, per_tipo, per_empleado, per_estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, persona.getPerId());
            stmt.setString(2, persona.getCedula());
            stmt.setString(3, persona.getNombres());
            stmt.setString(4, persona.getApellidos());
            stmt.setString(5, persona.getDireccion());
            stmt.setString(6, persona.getTelefono());
            stmt.setString(7, persona.getCorreo());
            stmt.setString(8, persona.getTipo());
            stmt.setString(9, persona.getEmpleado());
            stmt.setString(10, persona.getEstado());
            stmt.executeUpdate();
        }
    }

    @Override
    public Persona buscarPersona(int id) throws SQLException {
        String sql = "SELECT * FROM sis_med_personas WHERE per_id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Persona(
                    rs.getInt("per_id"), rs.getString("per_cedula"), rs.getString("per_nombres"),
                    rs.getString("per_apellidos"), rs.getString("per_direccion"), rs.getString("per_telefono"),
                    rs.getString("per_correo"), rs.getString("per_tipo"), rs.getString("per_empleado"), rs.getString("per_estado")
                );
            }
            return null;
        }
    }

    @Override
    public List<Persona> listarPersonas() throws SQLException {
        List<Persona> personas = new ArrayList<>();
        String sql = "SELECT * FROM sis_med_personas";
        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                personas.add(new Persona(
                    rs.getInt("per_id"), rs.getString("per_cedula"), rs.getString("per_nombres"),
                    rs.getString("per_apellidos"), rs.getString("per_direccion"), rs.getString("per_telefono"),
                    rs.getString("per_correo"), rs.getString("per_tipo"), rs.getString("per_empleado"), rs.getString("per_estado")
                ));
            }
        }
        return personas;
    }

    @Override
    public void actualizarPersona(Persona persona) throws SQLException {
        String sql = "UPDATE sis_med_personas SET per_cedula = ?, per_nombres = ?, per_apellidos = ?, per_direccion = ?, per_telefono = ?, per_correo = ?, per_tipo = ?, per_empleado = ?, per_estado = ? WHERE per_id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, persona.getCedula());
            stmt.setString(2, persona.getNombres());
            stmt.setString(3, persona.getApellidos());
            stmt.setString(4, persona.getDireccion());
            stmt.setString(5, persona.getTelefono());
            stmt.setString(6, persona.getCorreo());
            stmt.setString(7, persona.getTipo());
            stmt.setString(8, persona.getEmpleado());
            stmt.setString(9, persona.getEstado());
            stmt.setInt(10, persona.getPerId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminarPersona(int id) throws SQLException {
        String sql = "DELETE FROM sis_med_personas WHERE per_id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}
