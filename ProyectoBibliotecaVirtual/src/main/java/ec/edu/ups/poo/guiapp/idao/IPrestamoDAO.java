/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poo.guiapp.idao;

import ec.edu.ups.poo.guiapp.modelo.Prestamo;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

/**
 *
 * @author sebas
 */
public interface IPrestamoDAO {
    List<Prestamo> listarPrestamo();
    Prestamo obtenerPrestamo(String id);
    void crearPrestamo(Prestamo prestamo);
    void actualizarPrestamo(String id, Prestamo prestamo);
    void eliminarPrestamo(String id);
    void cargarPrestamosEnArchivos();
    Prestamo leerPrestamoDesdeArchivo(RandomAccessFile raf) throws IOException;
    void escribirPrestamosEnArchivo(RandomAccessFile raf, Prestamo prestamo) throws IOException;
    void guardarDatosEnArchivo() throws IOException;
}
