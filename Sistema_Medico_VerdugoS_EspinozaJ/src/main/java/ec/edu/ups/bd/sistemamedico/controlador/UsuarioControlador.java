package ec.edu.ups.bd.sistemamedico.controlador;

import ec.edu.ups.bd.sistemamedico.dao.UsuarioDAO;
import ec.edu.ups.bd.sistemamedico.modelo.Usuario;
import java.util.List;

public class UsuarioControlador {
    private UsuarioDAO usuarioDAO;

    public UsuarioControlador(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public void agregarUsuario(Usuario usuario) {
        usuarioDAO.agregarUsuario(usuario);
    }

    public Usuario buscarUsuario(int id) {
        return usuarioDAO.buscarUsuario(id);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listarUsuarios();
    }

    public void actualizarUsuario(Usuario usuario) {
        usuarioDAO.actualizarUsuario(usuario);
    }

    public void eliminarUsuario(int id) {
        usuarioDAO.eliminarUsuario(id);
    }
}
