/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.dao;

import ec.edu.ups.bd.sistemamedico.modelo.Usuario;
import java.util.HashMap;
import java.util.Map;

public class LoginDAO {
    private Map<String, Usuario> usuarios = new HashMap<>();

    public LoginDAO() {
        // Simulamos usuarios
        usuarios.put("admin", new Usuario(1, "admin", "1234", "Administrador", true));
        usuarios.put("empleado", new Usuario(2, "empleado", "5678", "Empleado General", true));
    }

    public Usuario autenticar(String nombre, String contrasena) {
        Usuario usuario = usuarios.get(nombre);
        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            return usuario;
        }
        return null;
    }
}
