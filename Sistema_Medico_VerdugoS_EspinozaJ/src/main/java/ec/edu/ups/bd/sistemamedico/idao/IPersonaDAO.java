/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.idao;

import ec.edu.ups.bd.sistemamedico.modelo.Persona;
import java.sql.SQLException;
import java.util.List;

public interface IPersonaDAO {
    void agregarPersona(Persona persona) throws SQLException;
    Persona buscarPersona(int id) throws SQLException;
    List<Persona> listarPersonas() throws SQLException;
    void actualizarPersona(Persona persona) throws SQLException;
    void eliminarPersona(int id) throws SQLException;
}
