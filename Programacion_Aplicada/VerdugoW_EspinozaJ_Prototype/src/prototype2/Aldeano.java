/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prototype2;

/**
 *
 * @author jordy
 */

public class Aldeano extends Personaje {
 
    public Aldeano(String imagenRepresentativa, String nombre, int nivel, String habilidades, String equipo) {
        super(imagenRepresentativa, nombre, nivel, habilidades, equipo);
    }

    @Override
    void mostrar() {
        System.out.println("Imagen Representativa: " + getImagenRepresentativa());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Nivel: " + getNivel());
        System.out.println("Habilidades: " + getHabilidades());
        System.out.println("Equipo: " + getEquipo());
    }
}
