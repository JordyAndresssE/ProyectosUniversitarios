/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prototype2;

/**
 *
 * @author jordy
 */

public class Mago extends Personaje {
    private String tipoEncanto;

    // Constructor
    public Mago(String imagenRepresentativa, String nombre, int nivel, String habilidades, String equipo, String tipoEncanto) {
        super(imagenRepresentativa, nombre, nivel, habilidades, equipo);
        this.tipoEncanto = tipoEncanto;
    }

    @Override
    void mostrar() {
        System.out.println("Imagen Representativa: " + getImagenRepresentativa());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Nivel: " + getNivel());
        System.out.println("Habilidades: " + getHabilidades());
        System.out.println("Equipo: " + getEquipo());
        System.out.println("Tipo de Encanto: " + tipoEncanto);
    }
    
     public void setTipoEncanto(String tipoEncanto) {
        this.tipoEncanto = tipoEncanto;
    }
}
