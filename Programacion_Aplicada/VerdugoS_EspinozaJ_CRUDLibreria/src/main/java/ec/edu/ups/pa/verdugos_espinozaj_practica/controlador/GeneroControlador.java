/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.pa.verdugos_espinozaj_practica.controlador;

import ec.edu.ups.pa.verdugos_espinozaj_practica.dao.GeneroDAO;
import ec.edu.ups.pa.verdugos_espinozaj_practica.modelo.Genero;
import java.util.List;

/**
 *
 * @author sebas
 */
public class GeneroControlador {
    private GeneroDAO generoDAO = new GeneroDAO();

    public List<Genero> listarGeneros() {
        return generoDAO.listarGeneros();
    }
}
