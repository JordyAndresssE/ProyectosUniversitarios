package ec.edu.ups.bd.sistemamedico.controlador;

import ec.edu.ups.bd.sistemamedico.dao.PersonaDAO;
import ec.edu.ups.bd.sistemamedico.modelo.Persona;
import java.util.List;

public class PersonaControlador {
    private PersonaDAO personaDAO;

    public PersonaControlador(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

    public void agregarPersona(Persona persona) {
        personaDAO.agregarPersona(persona);
    }

    public Persona buscarPersona(int id) {
        return personaDAO.buscarPersona(id);
    }

    public List<Persona> listarPersonas() {
        return personaDAO.listarPersonas();
    }

    public void actualizarPersona(Persona persona) {
        personaDAO.actualizarPersona(persona);
    }

    public void eliminarPersona(int id) {
        personaDAO.eliminarPersona(id);
    }
}
