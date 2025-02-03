/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.dao;

import ec.edu.ups.bd.sistemamedico.modelo.Servicio;
import java.util.ArrayList;
import java.util.List;

public class ServicioDAO {
    private List<Servicio> servicios = new ArrayList<>();

    public void agregarServicio(Servicio servicio) {
        servicios.add(servicio);
    }

    public Servicio buscarServicio(int id) {
        return servicios.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    public List<Servicio> listarServicios() {
        return servicios;
    }

    public void actualizarServicio(Servicio servicioActualizado) {
        for (int i = 0; i < servicios.size(); i++) {
            if (servicios.get(i).getId() == servicioActualizado.getId()) {
                servicios.set(i, servicioActualizado);
                break;
            }
        }
    }

    public void eliminarServicio(int id) {
        servicios.removeIf(s -> s.getId() == id);
    }
}
