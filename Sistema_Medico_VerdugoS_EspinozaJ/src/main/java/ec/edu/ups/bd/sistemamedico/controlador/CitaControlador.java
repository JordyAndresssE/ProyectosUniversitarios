package ec.edu.ups.bd.sistemamedico.controlador;

import ec.edu.ups.bd.sistemamedico.dao.CitaDAO;
import ec.edu.ups.bd.sistemamedico.modelo.Cita;
import java.sql.SQLException;
import java.util.List;

public class CitaControlador {
    private CitaDAO citaDAO;

    public CitaControlador(CitaDAO citaDAO) {
        this.citaDAO = citaDAO;
    }

    public void agregarCita(Cita cita) {
        try {
            citaDAO.agregarCita(cita);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cita buscarCita(int id) {
        try {
            return citaDAO.buscarCita(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Cita> listarCitas() {
        try {
            return citaDAO.listarCitas();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void actualizarCita(Cita cita) {
        try {
            citaDAO.actualizarCita(cita);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCita(int id) {
        try {
            citaDAO.eliminarCita(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
