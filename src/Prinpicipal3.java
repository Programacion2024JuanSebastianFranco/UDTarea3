import java.util.Scanner;

public class Prinpicipal3 {

    static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tarea3String tarea = new Tarea3String();

        int opc;

        do {
            opc = menu();

            switch (opc){
                case 1 -> {
                    // Validar Nif
                    System.out.println("Introduce un NIF para validarlo (9 caracteres):");
                    String nif = scanner.nextLine();
                    if (tarea.validarNIF(nif)) {
                        System.out.println("El NIF es válido.");
                    } else {
                        System.out.println("El NIF no es válido.");
                    }
                }

                case 2 -> {
                    // Sin vocales
                    System.out.println("Ingrese una cadena con vocales:");
                    String conVocales = scanner.nextLine();

                    String sinVocales = tarea.quitaVocales(conVocales);

                    System.out.println("Cadena sin vocales: " + sinVocales);
                }

                case 3 -> {
                    // Sin espacios
                    System.out.println("Ingrese una cadena con espacios:");
                    String conEspacios = scanner.nextLine();

                    String junto = tarea.quitaEspacios(conEspacios);

                    System.out.println("Cadena sin espacios: " + junto);
                }

                case 4 -> {
                    // Sin espacios
                    System.out.println("Ingrese una cadena:");
                    String invertir = scanner.nextLine();

                    String invertido = tarea.invertir(invertir);

                    System.out.println("Cadena invertida: " + invertido);
                }

                case 5 -> {
                    // Repeticiones
                    System.out.println("Ingrese una frase:");
                    String frase = scanner.nextLine();
                    System.out.println("Ingrese una palabra:");
                    String palabra = scanner.nextLine();

                    int repeticiones = tarea.repeticiones(frase, palabra);
                    System.out.println("Numero de Repeticiones: " + repeticiones);
                }

                case 6 -> {
                    // Palindromo
                    System.out.println("Ingrese un palindromo:");
                    String pali = scanner.nextLine();

                    if (tarea.palindromo(pali)) {
                        System.out.println("Es palindromo");
                    } else {
                        System.out.println("No es palindromo");
                    }
                }

                case 7 -> {
                    // Cifrado de Cesar
                    System.out.println("Ingrese una frase:");
                    String cifrar = scanner.nextLine();

                    String cifrado = tarea.cifrado(cifrar);
                    System.out.println(cifrado);
                }

                case 8 -> {
                    // Descifrar Cesar
                    System.out.println("Ingrese una frase:");
                    String descifrar = scanner.nextLine();

                    String descifrado = tarea.descifrar(descifrar);
                    System.out.println(descifrado);
                }

                case 9 -> {
                    // Juego
                    System.out.println("Seleccione una opcion para el juego de ahorcado:");
                    System.out.println("1. Jugar con los intentos predeterminados (5 intentos)");
                    System.out.println("2. Modificar el numero de intentos");

                    int opcion;
                    System.out.print("Elige: ");
                    opcion = scan.nextInt();
                    scan.nextLine();

                    if (opcion == 1) {
                        System.out.print("Introduzca una palabra: ");
                        String palabra = scan.nextLine();
                        JuegoAhorcado juego = new JuegoAhorcado(palabra);
                        juego.iniciarJuego();
                    } else {
                        System.out.print("Introduzca una palabra: ");
                        String palabra = scan.nextLine();
                        System.out.print("Ingresa el numero de intentos: ");
                        int intentos = scan.nextInt();

                        JuegoAhorcado juego = new JuegoAhorcado(palabra, intentos);
                        juego.iniciarJuego();
                        }
                }
            }
        } while(opc != 20);

    }


    public static int menu(){
        int opc;
        do {
            System.out.print("""
                MENU
                1. Validar Nif
                2. Quita Vocales
                3. Quita Espacios
                4. Invertir
                5. Repeticiones
                6. Palindromo
                7. Cifrado de Cesar
                8. Descifrar Cesar
                9. Juego Ahorcado
                """);
             opc = scan.nextInt();
        } while(opc < 1 || opc > 20);

        return opc;
    }


}