/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poo.guiapp.controlador;

import ec.edu.ups.poo.guiapp.idao.ILibroDAO;
import ec.edu.ups.poo.guiapp.idao.IPrestamoDAO;
import ec.edu.ups.poo.guiapp.idao.IUsuarioDAO;
import ec.edu.ups.poo.guiapp.modelo.Libro;
import ec.edu.ups.poo.guiapp.modelo.Prestamo;
import ec.edu.ups.poo.guiapp.modelo.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author sebas
 */
public class PrestamoControlador {
    private IPrestamoDAO prestamoDAO;
    private Prestamo prestamo;

    public PrestamoControlador(IPrestamoDAO prestamoDAO, ILibroDAO libroDAO, IUsuarioDAO usuarioDAO) {
        this.prestamoDAO = prestamoDAO;
    }
    
    public void crearPrestamo(String id, List<Libro> libros, List<Usuario> usuarios, Date fechaPrestamo, double total){
        prestamo = new Prestamo(id, libros, usuarios, fechaPrestamo, total);
        prestamoDAO.crearPrestamo(prestamo);
    }
    
    public void actualizarPrestamo(String id, List<Libro> libros, List<Usuario> usuarios, Date fechaPrestamo, double total){
        prestamo = prestamoDAO.obtenerPrestamo(id);
        prestamo.setLibros(libros);
        prestamo.setUsuarios(usuarios);
        prestamo.setFechaPrestamo(fechaPrestamo);
        prestamo.setTotal(total);
        prestamoDAO.actualizarPrestamo(id, prestamo);
    }
    
    public void eliminarPrestamo(String id){
        prestamo = prestamoDAO.obtenerPrestamo(id);
        prestamoDAO.eliminarPrestamo(prestamo.getId());
    }
    
    public Prestamo buscarPrestamoPorId(String id){
        prestamo = prestamoDAO.obtenerPrestamo(id);
        return prestamo;
    }
    
    public List<Prestamo> listarPrestamos(){
        return prestamoDAO.listarPrestamo();
    }
  
}
