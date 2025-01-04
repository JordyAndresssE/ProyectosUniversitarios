/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poo.guiapp.controlador;

import ec.edu.ups.poo.guiapp.modelo.Biblioteca;
import ec.edu.ups.poo.guiapp.idao.IBibliotecaDAO;
import ec.edu.ups.poo.guiapp.modelo.Libro;
import ec.edu.ups.poo.guiapp.modelo.Prestamo;
import ec.edu.ups.poo.guiapp.modelo.Usuario;
import java.util.List;

/**
 *
 * @author sebas
 */
public class BibliotecaControlador {
    private IBibliotecaDAO bibliotecaDAO;
    private Biblioteca biblioteca;

    public BibliotecaControlador(IBibliotecaDAO bibliotecaDAO) {
        this.bibliotecaDAO = bibliotecaDAO;
    }
    
    public void crearBiblioteca(int codigo, String nombre, String direccion, String telefono, List<Libro> libros, List<Prestamo> prestamos, List<Usuario> usuarios){
        biblioteca = new Biblioteca(codigo, nombre, direccion, telefono, libros, prestamos, usuarios);
        bibliotecaDAO.crearBiblioteca(biblioteca);
    }
    
    public Biblioteca buscarBiblioteca(int codigo){
        biblioteca = bibliotecaDAO.obtenerBiblioteca(codigo);
        return biblioteca;
    }
    
    public void actualizarBiblioteca(int codigo, String nombre, String direccion, String telefono, List<Libro> libros, List<Prestamo> prestamos, List<Usuario> usuarios){
        biblioteca = bibliotecaDAO.obtenerBiblioteca(codigo);
        biblioteca.setNombre(nombre);
        biblioteca.setDireccion(direccion);
        biblioteca.setTelefono(telefono);
        biblioteca.setLibros(libros);
        biblioteca.setPrestamos(prestamos);
        biblioteca.setUsuarios(usuarios);
        bibliotecaDAO.actualizarBiblioteca(codigo, biblioteca);
    }
    
    public void eliminarBiblioteca(int codigo){
        biblioteca = bibliotecaDAO.obtenerBiblioteca(codigo);
        bibliotecaDAO.eliminarBiblioteca(biblioteca.getCodigo());
    }
    
    public List<Biblioteca> listarBiblioteca(){
        return bibliotecaDAO.listarBiblioteca();
    }
}
