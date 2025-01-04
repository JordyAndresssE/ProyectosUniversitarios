/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poo.guiapp.dao;

import ec.edu.ups.poo.guiapp.excepciones.LimitePrestamosExcedidoException;
import ec.edu.ups.poo.guiapp.idao.IPrestamoDAO;
import ec.edu.ups.poo.guiapp.modelo.Libro;
import ec.edu.ups.poo.guiapp.modelo.Prestamo;
import ec.edu.ups.poo.guiapp.modelo.Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author sebas
 */
public class PrestamoDAO implements IPrestamoDAO{
    
    private List<Prestamo> listaPrestamos;
    private String fileName = "prestamos.dat";
    private static final int MAX_PREST = 10;
    private static final int RECORD_SIZE = 100;
    
    public PrestamoDAO() {
        listaPrestamos = new ArrayList<>();
        cargarPrestamosEnArchivos();
    }
    
    @Override
    public List<Prestamo> listarPrestamo() {
        return listaPrestamos;
    }

    @Override
    public void crearPrestamo(Prestamo prestamo) {
        try {
            if (listaPrestamos.size() < MAX_PREST) {
                listaPrestamos.add(prestamo);
                guardarDatosEnArchivo();
            } else {
                throw new LimitePrestamosExcedidoException("No se pueden agregar más prestamos. Límite alcanzado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Prestamo obtenerPrestamo(String id) {
        for (Prestamo prestamo : listaPrestamos) {
            if(prestamo.getId().equalsIgnoreCase(id)){
                return prestamo;
            }
        }
        return null;
    }

    @Override
    public void actualizarPrestamo(String id, Prestamo prestamo) {
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            while (raf.getFilePointer() < raf.length()) {
                long currentPosition = raf.getFilePointer();
                Prestamo prestamoActual = leerPrestamoDesdeArchivo(raf);

                if (prestamoActual.getId().equalsIgnoreCase(id)) {
                    // Encontrado, mover el puntero y escribir el nuevo prestamo
                    raf.seek(currentPosition);
                    escribirPrestamosEnArchivo(raf, prestamo);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarPrestamo(String id) {
        for (int i = 0; i < listaPrestamos.size(); i++) {
            Prestamo prestamoEncontrado = listaPrestamos.get(i);
            if(prestamoEncontrado.getId().equalsIgnoreCase(id)){
                listaPrestamos.remove(i);
                break;
            }            
        }
    }  

    @Override
    public void guardarDatosEnArchivo() throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            for (Prestamo prestamo : listaPrestamos) {
                escribirPrestamosEnArchivo(raf, prestamo);
            }
        } catch (IOException e) {
            throw new IOException("Error al guardar datos en el archivo.", e);
        }
    }

    @Override
    public void cargarPrestamosEnArchivos() {
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
            listaPrestamos.clear(); // Limpiar la lista existente

            while (raf.getFilePointer() < raf.length()) {
                Prestamo prestamo = leerPrestamoDesdeArchivo(raf);
                listaPrestamos.add(prestamo);
            }
        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Prestamo leerPrestamoDesdeArchivo(RandomAccessFile raf) throws IOException {
        String id = raf.readUTF();
        List<Libro> libros = leerLibrosDesdeArchivo(raf);
        List<Usuario> usuarios = leerUsuariosDesdeArchivo(raf);
        long fechaPrestamo = raf.readLong();
        double total = raf.readDouble();
        
        Prestamo prestamo = new Prestamo(id, libros, usuarios, new Date(fechaPrestamo), total);
        return prestamo;
    }

    @Override
    public void escribirPrestamosEnArchivo(RandomAccessFile raf, Prestamo prestamo) throws IOException {
        raf.writeUTF(prestamo.getId());
        escribirLibrosEnArchivo(raf,prestamo.getLibros());
        escribirUsuariosEnArchivo(raf, prestamo.getUsuarios());
        raf.writeLong(prestamo.getFechaPrestamo().getTime());
    }
    
    private List<Usuario> leerUsuariosDesdeArchivo(RandomAccessFile raf) throws IOException {
        int numUsuarios = raf.readInt();
        List<Usuario> usuarios = new ArrayList<>();

        for (int i = 0; i < numUsuarios; i++) {
            String nombre = raf.readUTF();
            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuarios.add(usuario);
        }

        return usuarios;
    }
    
    private List<Libro> leerLibrosDesdeArchivo(RandomAccessFile raf) throws IOException {
        int numLibros = raf.readInt();
        List<Libro> libros = new ArrayList<>();

        for (int i = 0; i < numLibros; i++) {
            String titulo = raf.readUTF();
            Libro libro = new Libro();
            libro.setTitulo(titulo);
            libros.add(libro);
        }

        return libros;
    }
    
    private void escribirUsuariosEnArchivo(RandomAccessFile raf, List<Usuario> usuarios) throws IOException {
        raf.writeInt(usuarios.size());

        for (Usuario usuario : usuarios) {
            raf.writeUTF(usuario.getNombre());
        }
    }
    
    private void escribirLibrosEnArchivo(RandomAccessFile raf, List<Libro> libros) throws IOException {
        raf.writeInt(libros.size());

        for (Libro libro : libros) {
            raf.writeUTF(libro.getTitulo());
        }
    }
}
