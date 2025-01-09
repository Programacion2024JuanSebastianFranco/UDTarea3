import java.io.FileReader;
import java.nio.channels.AsynchronousByteChannel;

public class Tarea3String {

    public boolean validarNIF(String nif) {

        boolean validacion = true;

        if (nif.length() != 9) {
            validacion = false;
        }

        for (int i = 0; i < 8 && validacion; i++) {
            if (!Character.isDigit(nif.charAt(i))) {
                validacion = false;
            }
        }

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

    public String invertir(String normal) {

        String invertido = "";

        for (int i = normal.length() - 1; i >= 0; i--) {
            invertido += normal.charAt(i);
        }

        return invertido;
    }


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


    public String cifrado(String frase){
        String cifrado= "";
        String abc = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        int suma = 3;
        int indiceNuevo = 0;
        String espacio = " ";

        for (int i = 0; i < frase.length(); i++){
            frase = frase.toUpperCase();
            char caracter = frase.charAt(i);
            if (espacio.indexOf(caracter) != -1){
                cifrado += caracter;
            }
            else {
                int indice = abc.indexOf(caracter);

                if (indice != -1){
                     indiceNuevo = (indice + suma) % abc.length();
                    cifrado += abc.charAt(indiceNuevo);
                }
                else {
                    System.out.println("El simbolo o letra: " + abc.charAt(indiceNuevo) + "No esta en el abecedario");
                }
            }
        }

        return cifrado;
    }



}
