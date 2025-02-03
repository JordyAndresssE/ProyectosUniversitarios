/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.idao;

import ec.edu.ups.bd.sistemamedico.modelo.Servicio;
import java.util.List;

public interface IServicioDAO {
    void agregarServicio(Servicio servicio);
    Servicio buscarServicio(int id);
    List<Servicio> listarServicios();
    void actualizarServicio(Servicio servicio);
    void eliminarServicio(int id);
}
