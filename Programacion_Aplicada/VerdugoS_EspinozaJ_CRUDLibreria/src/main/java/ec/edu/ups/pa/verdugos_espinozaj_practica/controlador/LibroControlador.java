/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.pa.verdugos_espinozaj_practica.controlador;

import ec.edu.ups.pa.verdugos_espinozaj_practica.dao.LibroDAO;
import ec.edu.ups.pa.verdugos_espinozaj_practica.modelo.Libro;
import java.util.List;

/**
 *
 * @author sebas
 */
public class LibroControlador {
    private LibroDAO libroDAO = new LibroDAO();

    public boolean agregarLibro(Libro libro) {
        return libroDAO.agregarLibro(libro);
    }

    public boolean eliminarLibro(String codigo) {
        return libroDAO.eliminarLibro(codigo);
    }

    public boolean modificarLibro(Libro libro) {
        return libroDAO.modificarLibro(libro);
    }

    public List<Libro> listarLibros() {
        return libroDAO.listarLibros();
    }

    public Libro buscarLibroPorCodigo(String codigo) {
        return libroDAO.buscarLibroPorCodigo(codigo);
    }
}

