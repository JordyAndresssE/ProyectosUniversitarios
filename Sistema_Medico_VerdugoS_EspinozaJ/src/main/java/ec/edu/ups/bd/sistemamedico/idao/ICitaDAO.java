/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.idao;

import ec.edu.ups.bd.sistemamedico.modelo.Cita;
import java.sql.SQLException;
import java.util.List;

public interface ICitaDAO {
    void agregarCita(Cita cita) throws SQLException;
    Cita buscarCita(int id) throws SQLException;
    List<Cita> listarCitas() throws SQLException;
    void actualizarCita(Cita cita) throws SQLException;
    void eliminarCita(int id) throws SQLException;
}
