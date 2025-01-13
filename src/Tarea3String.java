/**
 * Clase Tarea3String que contiene diferentes métodos para manipular y analizar cadenas de texto.
 */
public class Tarea3String {

    /**
     * Valida un NIF dado.
     *
     * @param nif El NIF a validar.
     * @return true si el NIF es válido, false en caso contrario.
     */
    public boolean validarNIF(String nif) {
        boolean validacion = true;

        // Comprobar longitud
        if (nif.length() != 9) {
            validacion = false;
        }

        // Comprobar que los primeros 8 caracteres sean dígitos
        for (int i = 0; i < 8 && validacion; i++) {
            if (!Character.isDigit(nif.charAt(i))) {
                validacion = false;
            }
        }

        // Validar la letra del NIF
        if (validacion) {
            char caracter = nif.charAt(8);
            if (!Character.isLetter(caracter)) {
                validacion = false;
            }

            String letrasValidas = "TRWAGMYFPDXBNJZSQVHLCKE";
            String num = nif.substring(0, 8);
            int numero = Integer.parseInt(num);
            char letraValida = letrasValidas.charAt(numero % 23);

            if (Character.toUpperCase(caracter) != letraValida) {
                validacion = false;
            }
        }

        return validacion;
    }

    /**
     * Elimina las vocales de una cadena.
     *
     * @param conVocales La cadena original con vocales.
     * @return La cadena sin vocales.
     */
    public String quitaVocales(String conVocales) {
        String sinVocales = "";
        String vocales = "aeiouAEIOUÁÉÍÓÚ";

        for (int i = 0; i < conVocales.length(); i++) {
            char caracter = conVocales.charAt(i);
            if (vocales.indexOf(caracter) == -1) {
                sinVocales += caracter;
            }
        }

        return sinVocales;
    }

    /**
     * Sustituye los espacios en una cadena por asteriscos.
     *
     * @param conEspacio La cadena original con espacios.
     * @return La cadena con los espacios reemplazados por asteriscos.
     */
    public String quitaEspacios(String conEspacio) {
        String junto = "";
        String espacio = " ";
        boolean huboEspacio = false;

        for (int i = 0; i < conEspacio.length(); i++) {
            char caracter = conEspacio.charAt(i);

            if (espacio.indexOf(caracter) == -1) {
                junto += caracter;
                huboEspacio = false;
            } else if (!huboEspacio) {
                junto += "*";
                huboEspacio = true;
            }
        }

        return junto;
    }

    /**
     * Invierte una cadena de texto.
     *
     * @param normal La cadena original.
     * @return La cadena invertida.
     */
    public String invertir(String normal) {
        String invertido = "";

        for (int i = normal.length() - 1; i >= 0; i--) {
            invertido += normal.charAt(i);
        }

        return invertido;
    }

    /**
     * Cuenta el número de veces que aparece una palabra en una frase.
     *
     * @param frase   La frase en la que buscar.
     * @param palabra La palabra a buscar.
     * @return El número de repeticiones de la palabra en la frase.
     */
    public int repeticiones(String frase, String palabra) {
        int contador = 0;
        String similar = "";
        String espacio = " ";

        for (int i = 0; i < frase.length(); i++) {
            char caracter = frase.charAt(i);

            if (espacio.indexOf(caracter) == -1) {
                if (palabra.indexOf(caracter) != -1) {
                    similar += caracter;
                    if (similar.equals(palabra)) {
                        contador++;
                        similar = "";
                    }
                }
            } else {
                similar = "";
            }
        }

        return contador;
    }

    /**
     * Verifica si una frase es un palíndromo.
     *
     * @param frase La frase a verificar.
     * @return true si la frase es un palíndromo, false en caso contrario.
     */
    public boolean palindromo(String frase) {
        boolean palindromo = false;
        String similar = "";
        String original = "";
        String espacio = " ";

        for (int i = 0; i < frase.length(); i++) {
            char caracter = frase.charAt(i);
            if (espacio.indexOf(caracter) == -1) {
                original += caracter;
            }
        }

        for (int i = original.length() - 1; i >= 0; i--) {
            similar += original.charAt(i);
        }

        if (similar.equalsIgnoreCase(original)) {
            palindromo = true;
        }

        return palindromo;
    }

    /**
     * Cifra una frase utilizando el cifrado César con un desplazamiento de 3.
     *
     * @param frase La frase a cifrar.
     * @return La frase cifrada.
     */
    public String cifrado(String frase) {
        String cifrado = "";
        String abc = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        int suma = 3;
        int indiceNuevo = 0;
        String espacio = " ";
        frase = frase.toUpperCase();

        for (int i = 0; i < frase.length(); i++) {
            char caracter = frase.charAt(i);
            if (espacio.indexOf(caracter) != -1) {
                cifrado += caracter;
            } else {
                int indice = abc.indexOf(caracter);

                if (indice != -1) {
                    indiceNuevo = (indice + suma) % abc.length();
                    cifrado += abc.charAt(indiceNuevo);
                } else {
                    System.out.println("El simbolo o letra: " + caracter + " no esta en el abecedario");
                }
            }
        }

        return cifrado;
    }

    /**
     * Descifra una frase cifrada con el cifrado César utilizando un desplazamiento de 3.
     *
     * @param frase La frase cifrada.
     * @return La frase descifrada.
     */
    public String descifrar(String frase) {
        String cifrado = "";
        String abc = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        int resta = 3;
        int indiceNuevo = 0;
        String espacio = " ";
        frase = frase.toUpperCase();

        for (int i = 0; i < frase.length(); i++) {
            char caracter = frase.charAt(i);
            if (espacio.indexOf(caracter) != -1) {
                cifrado += caracter;
            } else {
                int indice = abc.indexOf(caracter);

                if (indice != -1) {
                    indiceNuevo = (indice - resta) % abc.length();
                    if (indiceNuevo < 0) {
                        indiceNuevo += abc.length();
                    }
                    cifrado += abc.charAt(indiceNuevo);
                } else {
                    System.out.println("El simbolo o letra: " + caracter + " no esta en el abecedario");
                }
            }
        }

        return cifrado;
    }
}
