/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.dao;

import ec.edu.ups.bd.sistemamedico.idao.ILoginDAO;
import ec.edu.ups.bd.sistemamedico.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class LoginDAO implements ILoginDAO{
    private Connection conexion;
    private Map<String, Usuario> usuarios = new HashMap<>();

    public LoginDAO() {
        this.conexion = ConexionBD.getConexion();
        // Usuario administrador quemado
        usuarios.put("admin", new Usuario(1, "admin", "1234", "A", "S", 0, "0000000000", "Admin", "Principal", "N/A", "0000000000", "admin@admin.com", "E", "A", "S"));
    }

    @Override
    public Usuario autenticar(String nombre, String contrasena) throws SQLException {
        if (usuarios.containsKey(nombre)) {
            Usuario usuario = usuarios.get(nombre);
            if (usuario.getContrasena().equals(contrasena)) {
                return usuario;
            }
            return null;
        }
        String sql = "SELECT u.*, p.* FROM sis_med_usuarios u JOIN sis_med_personas p ON u.per_id = p.per_id WHERE u.usu_nombre = ? AND u.usu_contrasena = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, contrasena);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getInt("usu_id"),
                    rs.getString("usu_nombre"),
                    rs.getString("usu_contrasena"),
                    rs.getString("usu_rol"),
                    rs.getString("usu_estado"),
                    rs.getInt("per_id"),
                    rs.getString("per_cedula"),
                    rs.getString("per_nombres"),
                    rs.getString("per_apellidos"),
                    rs.getString("per_direccion"),
                    rs.getString("per_telefono"),
                    rs.getString("per_correo"),
                    rs.getString("per_tipo"),
                    rs.getString("per_empleado"),
                    rs.getString("per_estado")
                );
            }
        }
        return null;
    }

    
}
