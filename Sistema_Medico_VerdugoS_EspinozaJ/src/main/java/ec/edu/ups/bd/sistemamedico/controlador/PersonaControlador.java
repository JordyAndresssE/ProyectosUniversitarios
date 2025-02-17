package ec.edu.ups.bd.sistemamedico.controlador;

import ec.edu.ups.bd.sistemamedico.dao.PersonaDAO;
import ec.edu.ups.bd.sistemamedico.modelo.Persona;
import java.sql.SQLException;
import java.util.List;

public class PersonaControlador {
    private PersonaDAO personaDAO;

    public PersonaControlador(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

    public void agregarPersona(Persona persona) {
        try {
            personaDAO.agregarPersona(persona);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Persona buscarPersona(int id) {
        try {
            return personaDAO.buscarPersona(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Persona> listarPersonas() {
        try {
            return personaDAO.listarPersonas();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void actualizarPersona(Persona persona) {
        try {
            personaDAO.actualizarPersona(persona);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarPersona(int id) {
        try {
            personaDAO.eliminarPersona(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

