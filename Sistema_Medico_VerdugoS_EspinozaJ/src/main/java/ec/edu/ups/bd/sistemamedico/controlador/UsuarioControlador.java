package ec.edu.ups.bd.sistemamedico.controlador;

import ec.edu.ups.bd.sistemamedico.dao.UsuarioDAO;
import ec.edu.ups.bd.sistemamedico.modelo.Usuario;
import java.util.Optional;

public class UsuarioControlador {
    private UsuarioDAO usuarioDAO;
    private Usuario usuarioAutenticado;

    public UsuarioControlador(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    // Método para autenticar usuario por nombre y contraseña
    public boolean autenticarUsuario(String nombre, String contrasena) {
        Optional<Usuario> usuario = usuarioDAO.autenticarUsuario(nombre, contrasena);
        if (usuario.isPresent()) {
            this.usuarioAutenticado = usuario.get();
            return true;
        }
        return false;
    }

    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }
}