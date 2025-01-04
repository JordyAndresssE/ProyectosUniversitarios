/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poo.guiapp.modelo;



/**
 *
 * @author sebas
 */
public class Usuario extends Persona{
    private String correo;

    public Usuario() {
    }

    public Usuario(String correo, String nombre, String identificacion) {
        super(nombre, identificacion);
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Usuario{" + super.toString() + ", correo=" + correo + '}';
    }

}
