public class Tarea3String {

    public boolean esCorrectoNif(String nif) {

        boolean valido = true;

        if (nif.length() != 9) {
            valido = false;
        }


        if (!digitos(nif.substring(0, 8))) {
            valido = false;
        }


        if (!letra(nif)) {
            valido = false;
        }


        int numero = Integer.parseInt(nif.substring(0, 8));
        char letraCorrecta = calcularLetra(numero);
        char letraNif = nif.charAt(8);

        return letraCorrecta == letraNif && valido;
    }


    public boolean digitos(String cadena) {
        boolean digito = true;

        for (int i = 0; i < cadena.length(); i++) {
            if (!Character.isDigit(cadena.charAt(i))) {
                digito = false;
            }
        }
        return digito;
    }


    public boolean letra(String nif) {
        char caracter = nif.charAt(8);
        return Character.isLetter(caracter);
    }


    public char calcularLetra(int numero) {
        String serie = "TRWAGMYFPDXBNJZSQVHLCKE";
        int posicion = numero % 23;
        return serie.charAt(posicion);
    }
}
