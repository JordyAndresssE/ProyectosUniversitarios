/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.idao;

import ec.edu.ups.bd.sistemamedico.modelo.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface IUsuarioDAO {
    void agregarUsuario(Usuario usuario) throws SQLException;
    Usuario buscarUsuario(int id) throws SQLException;
    List<Usuario> listarUsuarios() throws SQLException;
    void actualizarUsuario(Usuario usuario) throws SQLException;
    void eliminarUsuario(int id) throws SQLException;
    Usuario autenticar(String nombre, String contrasena) throws SQLException;
}
