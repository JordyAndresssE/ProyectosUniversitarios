/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.idao;

import ec.edu.ups.bd.sistemamedico.modelo.Persona;
import java.util.List;

public interface IPersonaDAO {
    void agregarPersona(Persona persona);
    Persona buscarPersona(int id);
    List<Persona> listarPersonas();
    void actualizarPersona(Persona persona);
    void eliminarPersona(int id);
}
