/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prototype2;

/**
 *
 * @author jordy
 */


public abstract class Personaje implements Cloneable {
    private String imagenRepresentativa;
    private String nombre;
    private int nivel;
    private String habilidades;
    private String equipo;
    
    abstract void mostrar();

    
    public Personaje(String imagenRepresentativa, String nombre, int nivel, String habilidades, String equipo) {
        this.imagenRepresentativa = imagenRepresentativa;
        this.nombre = nombre;
        this.nivel = nivel;
        this.habilidades = habilidades;
        this.equipo = equipo;
    }


    protected String getImagenRepresentativa() {
        return imagenRepresentativa;
    }

    protected String getNombre() {
        return nombre;
    }

    protected int getNivel() {
        return nivel;
    }

    protected String getHabilidades() {
        return habilidades;
    }

    protected String getEquipo() {
        return equipo;
    }
    
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

 
    @Override
    public Personaje clone() throws CloneNotSupportedException {
        return (Personaje) super.clone();
    }
}
