/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prototype2;

/**
 *
 * @author jordy
 */
public class Guerrero extends Personaje {
    
    private int fuerza;
    private int vidas;


    public Guerrero(String imagenRepresentativa, String nombre, int nivel, String habilidades, String equipo, int fuerza, int vidas) {
        super(imagenRepresentativa, nombre, nivel, habilidades, equipo);
        this.fuerza = fuerza;
        this.vidas = vidas;
    }

    @Override
    void mostrar() {
        
        System.out.println("Imagen Representativa: " + getImagenRepresentativa());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Nivel: " + getNivel());
        System.out.println("Habilidades: " + getHabilidades());
        System.out.println("Equipo: " + getEquipo());
        System.out.println("Fuerza: " + fuerza);
        System.out.println("Vidas: " + vidas);
        
    }
    
}
