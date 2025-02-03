/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.dao;

import ec.edu.ups.bd.sistemamedico.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private List<Usuario> usuarios = new ArrayList<>();

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario buscarUsuario(int id) {
        return usuarios.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    public void actualizarUsuario(Usuario usuarioActualizado) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == usuarioActualizado.getId()) {
                usuarios.set(i, usuarioActualizado);
                break;
            }
        }
    }

    public void eliminarUsuario(int id) {
        usuarios.removeIf(u -> u.getId() == id);
    }
}
