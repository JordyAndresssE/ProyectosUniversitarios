package ec.edu.ups.bd.sistemamedico.controlador;

import ec.edu.ups.bd.sistemamedico.dao.LoginDAO;
import ec.edu.ups.bd.sistemamedico.modelo.Usuario;

public class LoginControlador {
    private LoginDAO loginDAO;

    public LoginControlador(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    public Usuario autenticar(String nombre, String contrasena) {
        return loginDAO.autenticar(nombre, contrasena);
    }
}
