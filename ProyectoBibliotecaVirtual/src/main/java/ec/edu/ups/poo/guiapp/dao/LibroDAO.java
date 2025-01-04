/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poo.guiapp.dao;

import ec.edu.ups.poo.guiapp.excepciones.LimiteLibrosExcedidoException;
import ec.edu.ups.poo.guiapp.idao.ILibroDAO;
import ec.edu.ups.poo.guiapp.modelo.Libro;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebas
 */
public class LibroDAO implements ILibroDAO{
    private List<Libro> listaLibros;
    private String fileName = "libros.dat";
    private static final int MAX_BOOKS = 10;
    private static final int RECORD_SIZE = 100;

    public LibroDAO() {
        listaLibros = new ArrayList<>();
        cargarLibrosEnArchivos();
    }

    @Override
    public Libro obtenerLibro(int id) {
        for (Libro libro : listaLibros) {
            if(libro.getCodigo() == id){
                return libro;
            }
        }
        return null;
    }

    @Override
    public void crearLibro(Libro libro) {
        try {
            if (listaLibros.size() < MAX_BOOKS) {
                listaLibros.add(libro);
                guardarDatosEnArchivo();
            } else {
                throw new LimiteLibrosExcedidoException("No se pueden agregar más libros. Límite alcanzado.");
            }
        } catch (IOException e) {
            e.printStackTrace(); // o maneja de otra manera la excepción según tus necesidades
        }
    }

    @Override
    public void actualizarLibro(int id, Libro libro) {
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            while (raf.getFilePointer() < raf.length()) {
                long currentPosition = raf.getFilePointer();
                Libro libroActual = leerLibroDesdeArchivo(raf);

                if (libroActual.getCodigo() == id) {
                    // Encontrado, mover el puntero y escribir el nuevo libro
                    raf.seek(currentPosition);
                    escribirLibrosEnArchivo(raf, libro);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarLibro(int id) {
        for (int i = 0; i < listaLibros.size(); i++) {
            Libro libroEncontrado = listaLibros.get(i);
            if(libroEncontrado.getCodigo() == id){
                listaLibros.remove(i);
                break;
            }   
        }
    }

    @Override
    public List<Libro> listaLibro() {
        return listaLibros;
    }

    @Override
    public Libro obtenerLibroPorTitulo(String titulo) {
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    @Override
    public void cargarLibrosEnArchivos() {
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
            listaLibros.clear(); // Limpiar la lista existente

            while (raf.getFilePointer() < raf.length()) {
                Libro libro = leerLibroDesdeArchivo(raf);
                listaLibros.add(libro);
            }
        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Libro leerLibroDesdeArchivo(RandomAccessFile raf) throws IOException {
        String titulo = raf.readUTF();
        String autor = raf.readUTF();
        int anio = raf.readInt();
        int codigo = raf.readInt();
        double precio = raf.readDouble();
        boolean disponible = raf.readBoolean();
        
        return new Libro(titulo, autor, anio, codigo, precio, disponible);
    }

    @Override
    public void escribirLibrosEnArchivo(RandomAccessFile raf, Libro libro) throws IOException {
        raf.writeUTF(libro.getTitulo());
        raf.writeUTF(libro.getAutor());
        raf.writeInt(libro.getAnio());
        raf.writeInt(libro.getCodigo());
        raf.writeDouble(libro.getPrecio());
        raf.writeBoolean(libro.isDisponible());     
    }

    @Override
    public void guardarDatosEnArchivo() throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            for (Libro libro : listaLibros) {
                escribirLibrosEnArchivo(raf, libro);
            }
        } catch (IOException e) {
            throw new IOException("Error al guardar datos en el archivo.", e);
        }
    }
}
