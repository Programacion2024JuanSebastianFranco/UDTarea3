import java.util.Scanner;

public class Prinpicipal3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tarea3String tarea = new Tarea3String();

        System.out.println("Introduce un NIF para validarlo (9 caracteres):");
        String nif = scanner.nextLine();

        if (tarea.validarNIF(nif)) {
            System.out.println("El NIF es válido.");
        } else {
            System.out.println("El NIF no es válido.");
        }


        // Sin vocales
        System.out.println("Ingrese una cadena con vocales:");
        String conVocales = scanner.nextLine();

        String sinVocales = tarea.quitaVocales(conVocales);

        System.out.println("Cadena sin vocales: " + sinVocales);


        // Sin espacios
        System.out.println("Ingrese una cadena con espacios:");
        String conEspacios = scanner.nextLine();

        String junto = tarea.quitaEspacios(conEspacios);

        System.out.println("Cadena sin espacios: " + junto);

        // Sin espacios
        System.out.println("Ingrese una cadena:");
        String invertir = scanner.nextLine();

        String invertido = tarea.invertir(invertir);

        System.out.println("Cadena invertida: " + invertido);

        // Repeticiones
        System.out.println("Ingrese una frase:");
        String frase = scanner.nextLine();
        System.out.println("Ingrese una palabra:");
        String palabra = scanner.nextLine();

        int repeticiones = tarea.repeticiones(frase, palabra);
        System.out.println("Numero de Repeticiones: " + repeticiones);

        // Palindromo
        System.out.println("Ingrese un palindromo:");
        String pali = scanner.nextLine();

        if (tarea.palindromo(pali)) {
            System.out.println("Es palindromo");
        } else {
            System.out.println("No es palindromo");
        }
    }
}