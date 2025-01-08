public class Tarea3String {

    public boolean validarNIF(String nif){

        boolean validacion = true;

        if (nif.length() != 9){
            validacion = false;
        }

        for (int i = 0; i < 8 && validacion; i++){
            if (!Character.isDigit(nif.charAt(i))){
                validacion = false;
            }
        }

        if (validacion) {
            char caracter = nif.charAt(8);

            if (!Character.isLetter(caracter)){
                validacion = false;
            }

            String letrasValidas = "TRWAGMYFPDXBNJZSQVHLCKE";
            String num = nif.substring(0,8);
            int numero = Integer.parseInt(num);
            char letraValida = letrasValidas.charAt(numero % 23);

            if (Character.toUpperCase(caracter) != letraValida){
                validacion = false;
            }
        }

        return validacion;
    }


    public String quitaVocales(String conVocales){

        String sinVocales = "";
        String vocales = "aeiouAEIOUÁÉÍÓÚ";

        for (int i = 0; i < conVocales.length(); i++){
            char caracter = conVocales.charAt(i);

            if (vocales.indexOf(caracter) == -1){
                sinVocales += caracter;
            }
        }

        return sinVocales;
    }

    public String quitaEspacios(String conEspacio){

        String junto  = "";
        String espacio = " ";
        boolean huboEspacio = false;

        for (int i = 0; i < conEspacio.length(); i++){
            char caracter = conEspacio.charAt(i);

            if (espacio.indexOf(caracter) == -1){
                junto += caracter;
                huboEspacio = false;
            }
            else if (!huboEspacio) {
                junto += "*";
                huboEspacio = true;
            }
        }

        return junto;
    }

    public String invertir(String normal){

        String invertido = "";

        for (int i = normal.length() - 1; i >= 0; i--){
            invertido += normal.charAt(i);
        }

        return invertido;
    }



}
