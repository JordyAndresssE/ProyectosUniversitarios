/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poo.guiapp.dao;

import ec.edu.ups.poo.guiapp.excepciones.LimiteBibliotecasExcedidoException;
import ec.edu.ups.poo.guiapp.modelo.Biblioteca;
import java.util.ArrayList;
import java.util.List;
import ec.edu.ups.poo.guiapp.idao.IBibliotecaDAO;
import ec.edu.ups.poo.guiapp.modelo.Libro;
import ec.edu.ups.poo.guiapp.modelo.Prestamo;
import ec.edu.ups.poo.guiapp.modelo.Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author sebas
 */
public class BibliotecaDAO implements IBibliotecaDAO {
    
    private List<Biblioteca> listaBibliotecas;
    private String fileName = "bibliotecas.dat";
    private static final int MAX_BIBLIO = 10;
    private static final int RECORD_SIZE = 100;

    public BibliotecaDAO() {
        listaBibliotecas = new ArrayList<>();
        cargarBibliotecasEnArchivos();

    }
    
    @Override
    public void crearBiblioteca(Biblioteca biblioteca) {
        try {
            if (listaBibliotecas.size() < MAX_BIBLIO) {
                listaBibliotecas.add(biblioteca);
                guardarDatosEnArchivo();
            } else {
                throw new LimiteBibliotecasExcedidoException("No se pueden agregar más bibliotecas. Límite alcanzado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Biblioteca obtenerBiblioteca(int codigo) {
        for(Biblioteca biblioteca : listaBibliotecas){
            if(biblioteca.getCodigo() == codigo){
                return biblioteca;
            }
        }
        return null;
    }

    @Override
    public void actualizarBiblioteca(int codigo, Biblioteca biblioteca) {
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            while (raf.getFilePointer() < raf.length()) {
                long currentPosition = raf.getFilePointer();
                Biblioteca bibliotecaActual = leerBibliotecaDesdeArchivo(raf);

                if (bibliotecaActual.getCodigo() == codigo) {
                    // Encontrado, mover el puntero y escribir la nueva biblioteca
                    raf.seek(currentPosition);
                    escribirBibliotecasEnArchivo(raf, biblioteca);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarBiblioteca(int codigo) {
        for (int i = 0; 1 < listaBibliotecas.size(); i++){
            Biblioteca bibliotecaBuscada = listaBibliotecas.get(i);
            if(bibliotecaBuscada.getCodigo() == codigo){
                listaBibliotecas.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Biblioteca> listarBiblioteca() {
        return listaBibliotecas;
    }

    @Override
    public void cargarBibliotecasEnArchivos() {
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
            listaBibliotecas.clear(); // Limpiar la lista existente

            while (raf.getFilePointer() < raf.length()) {
                Biblioteca biblioteca = leerBibliotecaDesdeArchivo(raf);
                listaBibliotecas.add(biblioteca);
            }
        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Biblioteca leerBibliotecaDesdeArchivo(RandomAccessFile raf) throws IOException {
        int codigo = raf.readInt();
        String nombre = raf.readUTF();
        String direccion = raf.readUTF();
        String telefono = raf.readUTF();
        List<Libro> libros = leerLibrosDesdeArchivo(raf);
        List<Prestamo> prestamos = leerPrestamosDesdeArchivo(raf);
        List<Usuario> usuarios = leerUsuariosDesdeArchivo(raf);
        
        Biblioteca biblioteca = new Biblioteca(codigo, nombre, direccion, telefono, libros, prestamos, usuarios);
        
        return biblioteca;
    }

    @Override
    public void escribirBibliotecasEnArchivo(RandomAccessFile raf, Biblioteca biblioteca) throws IOException {
        raf.writeInt(biblioteca.getCodigo());
        raf.writeUTF(biblioteca.getNombre());
        raf.writeUTF(biblioteca.getDireccion());
        raf.writeUTF(biblioteca.getTelefono());
        escribirLibrosEnArchivo(raf,biblioteca.getLibros());
        escribirPrestamosEnArchivo(raf,biblioteca.getPrestamos());
        escribirUsuariosEnArchivo(raf, biblioteca.getUsuarios());
    }

    @Override
    public void guardarDatosEnArchivo() throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            for (Biblioteca biblioteca : listaBibliotecas) {
                escribirBibliotecasEnArchivo(raf, biblioteca);
            }
        } catch (IOException e) {
            throw new IOException("Error al guardar datos en el archivo.", e);
        }
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
    
    private List<Prestamo> leerPrestamosDesdeArchivo(RandomAccessFile raf) throws IOException {
        int numPrestamos = raf.readInt();
        List<Prestamo> prestamos = new ArrayList<>();

        for (int i = 0; i < numPrestamos; i++) {
            String id = raf.readUTF();
            Prestamo prestamo = new Prestamo();
            prestamo.setId(id);
            prestamos.add(prestamo);
        }

        return prestamos;
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
    
    private void escribirPrestamosEnArchivo(RandomAccessFile raf, List<Prestamo> prestamos) throws IOException {
        raf.writeInt(prestamos.size());

        for (Prestamo prestamo : prestamos) {
            raf.writeUTF(prestamo.getId());
        }
    }
}
