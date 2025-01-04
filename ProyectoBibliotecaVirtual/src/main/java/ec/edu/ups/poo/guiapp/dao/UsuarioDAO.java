/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poo.guiapp.dao;

import ec.edu.ups.poo.guiapp.excepciones.LimiteUsuariosExcedidoException;
import ec.edu.ups.poo.guiapp.idao.IUsuarioDAO;
import ec.edu.ups.poo.guiapp.modelo.Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebas
 */
public class UsuarioDAO implements IUsuarioDAO {
    
    private List<Usuario> listaUsuarios;
    private String fileName = "usuarios.dat";
    private static final int MAX_USERS = 10;
    private static final int RECORD_SIZE = 100;

    public UsuarioDAO() {
        listaUsuarios = new ArrayList<>();
        cargarUsuariosEnArchivos();
    }

    @Override
    public List<Usuario> listaUsuario() {
        return listaUsuarios;
    }

    @Override
    public Usuario obtenerUsuario(String id) {
        for (Usuario usuario : listaUsuarios) {
            if(usuario.getIdentificacion().equalsIgnoreCase(id)){
                return usuario;
            }
        }
        return null;
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        try {
            if (listaUsuarios.size() < MAX_USERS) {
                listaUsuarios.add(usuario);
                guardarDatosEnArchivo();
            } else {
                throw new LimiteUsuariosExcedidoException("No se pueden agregar más usuarios. Límite alcanzado.");
            }
        } catch (IOException e) {
            e.printStackTrace(); // o maneja de otra manera la excepción según tus necesidades
        }
    }

    @Override
    public void actualizarUsuario(String id, Usuario usuario) {
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            while (raf.getFilePointer() < raf.length()) {
                long currentPosition = raf.getFilePointer();
                Usuario usuarioActual = leerUsuarioDesdeArchivo(raf);

                if (usuarioActual.getIdentificacion().equalsIgnoreCase(id)) {
                    // Encontrado, mover el puntero y escribir el nuevo usuario
                    raf.seek(currentPosition);
                    escribirUsuariosEnArchivo(raf, usuario);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarUsuario(String id) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario usuarioEncontrado = listaUsuarios.get(i);
            if(usuarioEncontrado.getIdentificacion().equalsIgnoreCase(id)){
                listaUsuarios.remove(i);
                break;
            }
        }
    }

    @Override
    public void cargarUsuariosEnArchivos() {
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
            listaUsuarios.clear(); // Limpiar la lista existente

            while (raf.getFilePointer() < raf.length()) {
                Usuario usuario = leerUsuarioDesdeArchivo(raf);
                listaUsuarios.add(usuario);
            }
        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario leerUsuarioDesdeArchivo(RandomAccessFile raf) throws IOException {
        String id = raf.readUTF();
        String nombre = raf.readUTF();
        String correo = raf.readUTF();
        
        return new Usuario(correo, nombre, id);
    }

    @Override
    public void escribirUsuariosEnArchivo(RandomAccessFile raf, Usuario usuario) throws IOException {
        raf.writeUTF(usuario.getCorreo());
        raf.writeUTF(usuario.getNombre());
        raf.writeUTF(usuario.getIdentificacion());
    }

    @Override
    public void guardarDatosEnArchivo() throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            for (Usuario usuario : listaUsuarios) {
                escribirUsuariosEnArchivo(raf, usuario);
            }
        } catch (IOException e) {
            throw new IOException("Error al guardar datos en el archivo.", e);
        }
    }

    @Override
    public Usuario obtenerUsuarioPorNombre(String nombre) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                return usuario;
            }
        }
        return null;
    }
}
