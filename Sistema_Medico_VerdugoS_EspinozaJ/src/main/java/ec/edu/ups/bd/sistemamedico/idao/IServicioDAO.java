/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.idao;

import ec.edu.ups.bd.sistemamedico.modelo.Servicio;
import java.sql.SQLException;
import java.util.List;

public interface IServicioDAO {
    void agregarServicio(Servicio servicio) throws SQLException;
    Servicio buscarServicio(int id) throws SQLException;
    List<Servicio> listarServicios() throws SQLException;
    void actualizarServicio(Servicio servicio) throws SQLException;
    void eliminarServicio(int id) throws SQLException;
}

