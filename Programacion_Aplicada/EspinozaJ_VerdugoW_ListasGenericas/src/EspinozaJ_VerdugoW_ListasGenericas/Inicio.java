package EspinozaJ_VerdugoW_ListasGenericas;

import java.util.ArrayList;
import java.util.List;

public class Inicio {

    public static void main(String[] args) {
        Generica<?> generica = new Generica<>();
        int opcion;

        do {
            opcion = generica.mostrarMenu();

            switch (opcion) {
                case 1:
                    procesarListasEnInicio(generica);
                    break;
                case 2:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 2);
    }

    private static void procesarListasEnInicio(Generica<?> generica) {
        int numeroListas = generica.obtenerNumeroListas();
        List<Generica<?>> listas = new ArrayList<>();

        for (int i = 0; i < numeroListas; i++) {
            int tipoDato = generica.elegirTipoDato();
            Generica<?> lista = new Generica<>();
            System.out.println("Para la lista " + (i + 1) + ", elija el tipo de datos (1-3): " + tipoDato);
            lista.llenarLista(tipoDato);
            listas.add(lista);
        }

        List<?> listaMezclada = Generica.mezclarListas(listas);
        System.out.println("Lista mezclada: " + listaMezclada);
    }
}


