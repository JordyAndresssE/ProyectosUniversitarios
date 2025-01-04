/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poo.guiapp.idao;

import ec.edu.ups.poo.guiapp.modelo.Biblioteca;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

/**
 *
 * @author sebas
 */
public interface IBibliotecaDAO {
    void crearBiblioteca(Biblioteca biblioteca);
    Biblioteca obtenerBiblioteca(int codigo);
    void actualizarBiblioteca(int codigo, Biblioteca biblioteca);
    void eliminarBiblioteca(int codigo);
    List<Biblioteca> listarBiblioteca();
    void cargarBibliotecasEnArchivos();
    Biblioteca leerBibliotecaDesdeArchivo(RandomAccessFile raf) throws IOException;
    void escribirBibliotecasEnArchivo(RandomAccessFile raf, Biblioteca biblioteca) throws IOException;
    void guardarDatosEnArchivo() throws IOException;
}
