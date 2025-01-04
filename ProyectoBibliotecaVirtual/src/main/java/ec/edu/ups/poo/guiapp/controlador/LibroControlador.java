/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poo.guiapp.controlador;

import ec.edu.ups.poo.guiapp.idao.ILibroDAO;
import ec.edu.ups.poo.guiapp.modelo.Libro;
import java.util.List;

/**
 *
 * @author sebas
 */
public class LibroControlador {
  private ILibroDAO libroDAO;
    private Libro libro;

    public LibroControlador(ILibroDAO libroDAO) {
        this.libroDAO = libroDAO;
    }

    public void crearLibro(String titulo, String autor, int anio, int codigo, double precio, boolean disponible){
        libro = new Libro(titulo, autor, anio, codigo, precio, disponible);
        libroDAO.crearLibro(libro);
    }
    
    public void actualizarLibro(String titulo, String autor, int anio, int codigo, double precio, boolean disponible){
        libro = libroDAO.obtenerLibro(codigo);
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        libro.setAnio(anio);
        libro.setPrecio(precio);
        libro.setDisponible(disponible);
        libroDAO.actualizarLibro(codigo, libro);
    }
    
    public void eliminarLibro(int codigo){
        libro = libroDAO.obtenerLibro(codigo);
        libroDAO.eliminarLibro(libro.getCodigo());
    }
    
    public Libro buscarLibroPorId(int codigo){
        libro = libroDAO.obtenerLibro(codigo);
        return libro;
    }
    
    public Libro buscarLibroPorTitulo(String titulo){
        libro = libroDAO.obtenerLibroPorTitulo(titulo);
        return libro;
    }
    
    public List<Libro> listarLibro(){
        return libroDAO.listaLibro();
    }  
}
