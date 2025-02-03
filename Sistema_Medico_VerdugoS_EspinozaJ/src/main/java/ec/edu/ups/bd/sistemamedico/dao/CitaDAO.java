/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.dao;

import ec.edu.ups.bd.sistemamedico.modelo.Cita;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO {
    private List<Cita> citas = new ArrayList<>();

    public void agregarCita(Cita cita) {
        citas.add(cita);
    }

    public Cita buscarCita(int id) {
        return citas.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public List<Cita> listarCitas() {
        return citas;
    }

    public void actualizarCita(Cita citaActualizada) {
        for (int i = 0; i < citas.size(); i++) {
            if (citas.get(i).getId() == citaActualizada.getId()) {
                citas.set(i, citaActualizada);
                break;
            }
        }
    }

    public void eliminarCita(int id) {
        citas.removeIf(c -> c.getId() == id);
    }
}
