/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poo.guiapp.idao;

import ec.edu.ups.poo.guiapp.modelo.Usuario;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

/**
 *
 * @author sebas
 */
public interface IUsuarioDAO {
    List<Usuario> listaUsuario();
    Usuario obtenerUsuario(String id);
    Usuario obtenerUsuarioPorNombre(String nombre);
    void crearUsuario(Usuario usuario);
    void actualizarUsuario(String id, Usuario usuario);
    void eliminarUsuario(String id);
    void cargarUsuariosEnArchivos();
    Usuario leerUsuarioDesdeArchivo(RandomAccessFile raf) throws IOException;
    void escribirUsuariosEnArchivo(RandomAccessFile raf, Usuario usuario) throws IOException;
    void guardarDatosEnArchivo() throws IOException;
}
