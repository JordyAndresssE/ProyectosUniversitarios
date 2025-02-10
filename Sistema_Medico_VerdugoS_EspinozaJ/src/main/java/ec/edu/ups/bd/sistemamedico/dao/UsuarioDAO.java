package ec.edu.ups.bd.sistemamedico.dao;

import ec.edu.ups.bd.sistemamedico.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UsuarioDAO {
    private Connection conexion;

    public UsuarioDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public Optional<Usuario> autenticarUsuario(String nombre, String contrasena) {
        String sql = "SELECT usu_id, usu_nombre, usu_contrasena, usu_rol FROM sis_med_usuarios WHERE usu_nombre = ? AND usu_contrasena = ? AND usu_estado = 'S'";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, contrasena);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return Optional.of(new Usuario(
                    rs.getInt("usu_id"),
                    rs.getString("usu_nombre"),
                    rs.getString("usu_contrasena"),
                    rs.getString("usu_rol"),
                    true
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
