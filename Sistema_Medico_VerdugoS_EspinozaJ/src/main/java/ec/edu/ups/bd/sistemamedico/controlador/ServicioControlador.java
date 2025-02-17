package ec.edu.ups.bd.sistemamedico.controlador;

import ec.edu.ups.bd.sistemamedico.dao.ServicioDAO;
import ec.edu.ups.bd.sistemamedico.modelo.Servicio;
import java.sql.SQLException;
import java.util.List;

public class ServicioControlador {
    private ServicioDAO servicioDAO;

    public ServicioControlador(ServicioDAO servicioDAO) {
        this.servicioDAO = servicioDAO;
    }

    public void agregarServicio(Servicio servicio) {
        try {
            servicioDAO.agregarServicio(servicio);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Servicio buscarServicio(int id) {
        try {
            return servicioDAO.buscarServicio(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Servicio> listarServicios() {
        try {
            return servicioDAO.listarServicios();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void actualizarServicio(Servicio servicio) {
        try {
            servicioDAO.actualizarServicio(servicio);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarServicio(int id) {
        try {
            servicioDAO.eliminarServicio(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
