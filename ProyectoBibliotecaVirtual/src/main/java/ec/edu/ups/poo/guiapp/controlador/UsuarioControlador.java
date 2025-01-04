/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poo.guiapp.controlador;

import ec.edu.ups.poo.guiapp.idao.IUsuarioDAO;
import ec.edu.ups.poo.guiapp.modelo.Usuario;
import java.util.List;

/**
 *
 * @author sebas
 */
public class UsuarioControlador {
    private IUsuarioDAO usuarioDAO;
    private Usuario usuario;

    public UsuarioControlador(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    
    public void crearUsuario(String correo, String nombre, String id){
        usuario = new Usuario(correo,nombre,id);
        usuarioDAO.crearUsuario(usuario);
    }
    
    public void actualizarUsuario(String correo, String nombre, String id){
        usuario = usuarioDAO.obtenerUsuario(id);
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuarioDAO.actualizarUsuario(id, usuario);
    }
    
    public Usuario buscarUsuario(String id){
        usuario = usuarioDAO.obtenerUsuario(id);
        return usuario;
    }
    
    public Usuario buscarUsuarioPorNombre(String nombre){
        usuario = usuarioDAO.obtenerUsuarioPorNombre(nombre);
        return usuario;
    }
    
    public void eliminarUsuario(String id){
        usuario = usuarioDAO.obtenerUsuario(id);
        usuarioDAO.eliminarUsuario(usuario.getIdentificacion());
    }
    
    public List<Usuario> listarUsuario(){
        return usuarioDAO.listaUsuario();
    }
}
