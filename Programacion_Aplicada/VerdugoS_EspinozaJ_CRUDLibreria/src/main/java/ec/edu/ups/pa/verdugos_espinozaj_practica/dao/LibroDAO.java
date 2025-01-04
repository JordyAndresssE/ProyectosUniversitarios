/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.pa.verdugos_espinozaj_practica.dao;

import ec.edu.ups.pa.verdugos_espinozaj_practica.modelo.Libro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebas
 */
public class LibroDAO {
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/gestion_libreria";
        String username = "root";
        String password = "Jordy2316.";
        return DriverManager.getConnection(url, username, password);
    }

    public boolean agregarLibro(Libro libro) {
        String query = "INSERT INTO Libro (codigo, titulo, fechaPublicacion, precio, codigoGenero) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, libro.getCodigo());
            stmt.setString(2, libro.getTitulo());
            stmt.setDate(3, new java.sql.Date(libro.getFechaPublicacion().getTime()));
            stmt.setDouble(4, libro.getPrecio());
            stmt.setString(5, libro.getCodigoGenero());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarLibro(String codigo) {
        String query = "DELETE FROM Libro WHERE codigo = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, codigo);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificarLibro(Libro libro) {
        String query = "UPDATE Libro SET titulo = ?, fechaPublicacion = ?, precio = ?, codigoGenero = ? WHERE codigo = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, libro.getTitulo());
            stmt.setDate(2, new java.sql.Date(libro.getFechaPublicacion().getTime()));
            stmt.setDouble(3, libro.getPrecio());
            stmt.setString(4, libro.getCodigoGenero());
            stmt.setString(5, libro.getCodigo());
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Libro> listarLibros() {
        List<Libro> libros = new ArrayList<>();
        String query = "SELECT * FROM Libro";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Libro libro = new Libro(
                    rs.getString("codigo"),
                    rs.getString("titulo"),
                    rs.getDate("fechaPublicacion"),
                    rs.getDouble("precio"),
                    rs.getString("codigoGenero")
                );
                libros.add(libro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }

    public Libro buscarLibroPorCodigo(String codigo) {
        Libro libro = null;
        String query = "SELECT * FROM Libro WHERE codigo = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, codigo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    libro = new Libro(
                        rs.getString("codigo"),
                        rs.getString("titulo"),
                        rs.getDate("fechaPublicacion"),
                        rs.getDouble("precio"),
                        rs.getString("codigoGenero")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libro;
    }
}
