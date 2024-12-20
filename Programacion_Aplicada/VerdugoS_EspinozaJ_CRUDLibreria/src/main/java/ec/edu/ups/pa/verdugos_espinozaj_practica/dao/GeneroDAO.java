/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.pa.verdugos_espinozaj_practica.dao;
import ec.edu.ups.pa.verdugos_espinozaj_practica.modelo.Genero;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebas
 */
public class GeneroDAO {
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/gestion_libreria";
        String username = "root";
        String password = "Jordy2316.";
        return DriverManager.getConnection(url, username, password);
    }

    public List<Genero> listarGeneros() {
        List<Genero> generos = new ArrayList<>();
        String query = "SELECT * FROM Genero";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Genero genero = new Genero(
                    rs.getString("codigo"),
                    rs.getString("descripcion")
                );
                generos.add(genero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generos;
    }
}
