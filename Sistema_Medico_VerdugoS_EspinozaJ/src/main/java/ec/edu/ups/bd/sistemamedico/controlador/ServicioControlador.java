package ec.edu.ups.bd.sistemamedico.controlador;

import ec.edu.ups.bd.sistemamedico.dao.ServicioDAO;
import ec.edu.ups.bd.sistemamedico.modelo.Servicio;
import java.util.List;

public class ServicioControlador {
    private ServicioDAO servicioDAO;

    public ServicioControlador(ServicioDAO servicioDAO) {
        this.servicioDAO = servicioDAO;
    }

    public void agregarServicio(Servicio servicio) {
        servicioDAO.agregarServicio(servicio);
    }

    public Servicio buscarServicio(int id) {
        return servicioDAO.buscarServicio(id);
    }

    public List<Servicio> listarServicios() {
        return servicioDAO.listarServicios();
    }

    public void actualizarServicio(Servicio servicio) {
        servicioDAO.actualizarServicio(servicio);
    }

    public void eliminarServicio(int id) {
        servicioDAO.eliminarServicio(id);
    }
}
