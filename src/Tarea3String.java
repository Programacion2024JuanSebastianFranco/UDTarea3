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


}
