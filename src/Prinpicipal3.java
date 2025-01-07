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
    }
}