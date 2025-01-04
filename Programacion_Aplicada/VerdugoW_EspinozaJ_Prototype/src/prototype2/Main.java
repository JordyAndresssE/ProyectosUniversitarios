/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prototype2;

/**
 *
 * @author jordy
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        
        // Crear un Guerrero 
        Guerrero guerreroPrototipo = new Guerrero("guerrero", "Guerrero", 1, "Ataque", "Espada", 10, 3);
        
        // Registrar el prototipo en el RegistroPersonajes
        RegistroPersonajes registro = new RegistroPersonajes();
        registro.registrarPrototipo("guerrero", guerreroPrototipo);
        
        // Clonar el Guerrero y mostrar sus atributos predefinidos
        Guerrero guerrero = (Guerrero) registro.clonarPersonaje("guerrero");
        System.out.println("Atributos predefinidos del Guerrero:");
        guerrero.mostrar();
        
        // Modificar atributos y mostrarlos nuevamente
        guerrero.setNivel(2);
        guerrero.setEquipo("Espada y Escudo");
        System.out.println("\nAtributos modificados del Guerrero:");
        guerrero.mostrar();
        
        // Crear un Mago prototipo
        Mago magoPrototipo = new Mago("mago", "Mago", 1, "Magia", "Varita", "Fuego");
        
        // Registrar el prototipo en el RegistroPersonajes
        registro.registrarPrototipo("mago", magoPrototipo);
        
        // Clonar el Mago y mostrar sus atributos predefinidos
        Mago mago = (Mago) registro.clonarPersonaje("mago");
        System.out.println("\nAtributos predefinidos del Mago:");
        mago.mostrar();
        
        // Modificar atributos y mostrarlos nuevamente
        mago.setNivel(2);
        mago.setTipoEncanto("Hielo");
        System.out.println("\nAtributos modificados del Mago:");
        mago.mostrar();
        
        // Crear un Aldeano
        Aldeano aldeanoPrototipo = new Aldeano("aldeano", "Aldeano", 1, "Trabajo", "Herramientas");
        

        registro.registrarPrototipo("aldeano", aldeanoPrototipo);
        
 
        Aldeano aldeano = (Aldeano) registro.clonarPersonaje("aldeano");
        System.out.println("\nAtributos predefinidos del Aldeano:");
        aldeano.mostrar();
        
        System.out.println("\nAtributos modificados del Aldeano (ninguno):");
        aldeano.mostrar();
    }
}