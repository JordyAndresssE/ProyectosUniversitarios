/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.idao;

import ec.edu.ups.bd.sistemamedico.modelo.Cita;
import java.util.List;

public interface ICitaDAO {
    void agregarCita(Cita cita);
    Cita buscarCita(int id);
    List<Cita> listarCitas();
    void actualizarCita(Cita cita);
    void eliminarCita(int id);
}
