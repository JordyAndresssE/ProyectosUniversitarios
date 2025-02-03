package ec.edu.ups.bd.sistemamedico.controlador;

import ec.edu.ups.bd.sistemamedico.dao.CitaDAO;
import ec.edu.ups.bd.sistemamedico.modelo.Cita;
import java.util.List;

public class CitaControlador {
    private CitaDAO citaDAO;

    public CitaControlador(CitaDAO citaDAO) {
        this.citaDAO = citaDAO;
    }

    public void agregarCita(Cita cita) {
        citaDAO.agregarCita(cita);
    }

    public Cita buscarCita(int id) {
        return citaDAO.buscarCita(id);
    }

    public List<Cita> listarCitas() {
        return citaDAO.listarCitas();
    }

    public void actualizarCita(Cita cita) {
        citaDAO.actualizarCita(cita);
    }

    public void eliminarCita(int id) {
        citaDAO.eliminarCita(id);
    }
}
