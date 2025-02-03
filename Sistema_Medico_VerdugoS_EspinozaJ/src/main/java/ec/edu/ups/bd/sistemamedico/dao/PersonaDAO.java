/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.dao;

import ec.edu.ups.bd.sistemamedico.modelo.Persona;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    private List<Persona> personas = new ArrayList<>();

    public void agregarPersona(Persona persona) {
        personas.add(persona);
    }

    public Persona buscarPersona(int id) {
        return personas.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public List<Persona> listarPersonas() {
        return personas;
    }

    public void actualizarPersona(Persona personaActualizada) {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getId() == personaActualizada.getId()) {
                personas.set(i, personaActualizada);
                break;
            }
        }
    }

    public void eliminarPersona(int id) {
        personas.removeIf(p -> p.getId() == id);
    }
}
