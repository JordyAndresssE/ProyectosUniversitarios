package ec.edu.ups.bd.sistemamedico.controlador;

import ec.edu.ups.bd.sistemamedico.dao.UsuarioDAO;
import ec.edu.ups.bd.sistemamedico.modelo.Usuario;
import java.sql.SQLException;
import java.util.List;

public class UsuarioControlador {
    private UsuarioDAO usuarioDAO;
    private Usuario usuarioAutenticado;

    public UsuarioControlador(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public boolean autenticarUsuario(String nombre, String contrasena) {
        try {
            Usuario usuario = usuarioDAO.autenticar(nombre, contrasena);
            if (usuario != null) {
                this.usuarioAutenticado = usuario;
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void agregarUsuario(Usuario usuario) {
        try {
            usuarioDAO.agregarUsuario(usuario);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario buscarUsuario(int id) {
        try {
            return usuarioDAO.buscarUsuario(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Usuario> listarUsuarios() {
        try {
            return usuarioDAO.listarUsuarios();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void actualizarUsuario(Usuario usuario) {
        try {
            usuarioDAO.actualizarUsuario(usuario);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarUsuario(int id) {
        try {
            usuarioDAO.eliminarUsuario(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }
}