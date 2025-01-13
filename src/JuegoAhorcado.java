import java.util.Scanner;

/**
 * Clase JuegoAhorcado que permite jugar al juego del ahorcado.
 * Ofrece dos constructores para inicializar el juego con una palabra secreta
 * y permite personalizar el número de intentos.
 */
public class JuegoAhorcado {

    // Propiedades privadas
    private String palabraSecreta; // La palabra secreta a adivinar
    private char[] estadoActual;  // Estado actual de la palabra adivinada (e.g., "_ _ _ _")
    private int intentosRestantes; // Número de intentos restantes
    private final int intentosPorDefecto = 5; // Intentos por defecto

    /**
     * Constructor que inicializa el juego con una palabra secreta y
     * un número de intentos predeterminado (5).
     *
     * @param palabraSecreta La palabra que el jugador debe adivinar.
     */
    public JuegoAhorcado(String palabraSecreta) {
        this.palabraSecreta = palabraSecreta.toLowerCase(); // Convertir la palabra a minúsculas
        this.intentosRestantes = intentosPorDefecto; // Asignar intentos por defecto
        this.estadoActual = new char[palabraSecreta.length()]; // Crear el arreglo de estado
        inicializarEstado(); // Inicializar el estado actual como "_ _ _"
    }

    /**
     * Constructor que inicializa el juego con una palabra secreta y un número de intentos personalizado.
     *
     * @param palabraSecreta La palabra que el jugador debe adivinar.
     * @param intentos Número de intentos que tendrá el jugador.
     */
    public JuegoAhorcado(String palabraSecreta, int intentos) {
        this.palabraSecreta = palabraSecreta.toLowerCase();
        this.intentosRestantes = intentos; // Asignar intentos personalizados
        this.estadoActual = new char[palabraSecreta.length()];
        inicializarEstado();
    }

    /**
     * Inicializa el estado actual de la palabra secreta con guiones bajos ('_').
     */
    private void inicializarEstado() {
        for (int i = 0; i < estadoActual.length; i++) {
            estadoActual[i] = '_'; // Cada posición comienza con un guion bajo
        }
    }

    /**
     * Muestra el estado actual de la palabra secreta en la consola.
     */
    private void mostrarEstado() {
        for (char c : estadoActual) {
            System.out.print(c + " "); // Imprime cada letra o guion con un espacio
        }
        System.out.println();
    }

    /**
     * Inicia el juego del ahorcado. Permite al jugador intentar adivinar la palabra letra por letra.
     * Pregunta si el jugador desea jugar de nuevo una vez finalizado el juego.
     */
    public void iniciarJuego() {
        Scanner scanner = new Scanner(System.in);
        boolean continuarJuego = true; // Bandera para determinar si el juego continúa

        while (continuarJuego) {
            // Bucle del juego principal
            while (intentosRestantes > 0 && !esPalabraAdivinada()) {
                System.out.println("\nIntentos restantes: " + intentosRestantes);
                mostrarEstado(); // Muestra el progreso actual

                System.out.print("Introduce una letra: ");
                String entrada = scanner.nextLine().toLowerCase(); // Lee una letra

                // Validación de entrada
                if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
                    System.out.println("Introduce una sola letra");
                    continue; // Pedir otra entrada si es inválida
                }

                char letra = entrada.charAt(0);

                // Actualizar estado según la letra introducida
                if (actualizarEstado(letra)) {
                    System.out.println("Correcto, la letra se encuentra en la palabra");
                } else {
                    System.out.println("Letra incorrecta");
                    intentosRestantes--; // Resta un intento si no acierta
                }
            }

            // Determina si el jugador ganó o perdió
            if (esPalabraAdivinada()) {
                System.out.println("\n¡EUREKA! \nLa palabra era: " + palabraSecreta);
            } else {
                System.out.println("\nHas Perdido :( \nLa palabra era: " + palabraSecreta);
            }

            // Preguntar si desea jugar de nuevo
            System.out.print("¿Deseas intentarlo de nuevo? (s/n): ");
            String respuesta = scanner.nextLine().toLowerCase();
            if (respuesta.equals("s")) {
                reiniciarJuego(); // Reinicia el juego con la misma palabra
            } else {
                continuarJuego = false; // Finaliza el juego
                System.out.println("Gracias por jugar. ¡Hasta la próxima!");
            }
        }
    }

    /**
     * Actualiza el estado actual de la palabra según la letra introducida.
     *
     * @param letra La letra introducida por el jugador.
     * @return True si la letra está en la palabra secreta, False en caso contrario.
     */
    private boolean actualizarEstado(char letra) {
        boolean acierto = false;

        // Recorre la palabra secreta para verificar la letra
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra && estadoActual[i] == '_') {
                estadoActual[i] = letra; // Actualiza la posición correcta
                acierto = true; // Marca como un acierto
            }
        }
        return acierto;
    }

    /**
     * Comprueba si el jugador ha adivinado toda la palabra.
     *
     * @return True si todas las letras han sido descubiertas, False en caso contrario.
     */
    private boolean esPalabraAdivinada() {
        for (char c : estadoActual) {
            if (c == '_') {
                return false; // Si aún hay guiones bajos, la palabra no está completa
            }
        }
        return true;
    }

    /**
     * Reinicia el juego con la misma palabra secreta y los intentos por defecto.
     */
    private void reiniciarJuego() {
        intentosRestantes = intentosPorDefecto; // Restablece los intentos
        inicializarEstado(); // Reinicia el estado de la palabra
    }
}

