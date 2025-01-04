package EspinozaJ_VerdugoW_ListasGenericas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Generica<T> {

    private List<T> lista;
    private Scanner scanner;

    public Generica() {
        this.lista = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void agregarElemento(T elemento) {
        lista.add(elemento);
    }

    public List<T> obtenerLista() {
        return lista;
    }

    public int mostrarMenu() {
        System.out.println("\n1. Mezclar listas");
        System.out.println("2. Salir");
        System.out.print("Ingrese su opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        return opcion;
    }

    public int elegirTipoDato() {
        System.out.println("1. Integer");
        System.out.println("2. String");
        System.out.println("3. Character");
        System.out.print("Ingrese el tipo de dato: ");

        int tipoDato = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        return tipoDato;
    }

    public int obtenerNumeroListas() {
        System.out.print("Ingrese el número de listas que desea mezclar: ");
        int numeroListas = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        return numeroListas;
    }

    public void llenarLista(int tipoDato) {
        System.out.println("Ingrese los datos para la lista :");
        T valor;
        do {
            if (tipoDato == 1) {
                System.out.print("Ingrese un entero (-1 para terminar): ");
                valor = (T) (Integer) scanner.nextInt();
                if (valor.equals((T)(Integer)(-1))) break;
            } else if (tipoDato == 2) {
                System.out.print("Ingrese una cadena (fin para terminar): ");
                valor = (T) scanner.next();
                if (valor.equals((T)"fin")) break;
            } else if (tipoDato == 3) {
                System.out.print("Ingrese un carácter (# para terminar): ");
                valor = (T) (Character) scanner.next().charAt(0);
                if (valor.equals((T)Character.valueOf('#'))) break;
            } else {
                throw new IllegalArgumentException("Tipo de dato no válido");
            }
            scanner.nextLine(); // Consumir salto de línea
            this.agregarElemento(valor);
        } while (true);
    }

    public static <T> List<T> mezclarListas(List<Generica<?>> listas) {
        List<T> listaMezclada = new ArrayList<>();
        int maxSize = listas.stream().mapToInt(lista -> lista.obtenerLista().size()).max().orElse(0);

        for (int i = 0; i < maxSize; i++) {
            for (Generica<?> lista : listas) {
                if (i < lista.obtenerLista().size()) {
                    listaMezclada.add((T)lista.obtenerLista().get(i));
                }
            }
        }
        return listaMezclada;
    }
}

