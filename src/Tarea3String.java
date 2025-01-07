public class Tarea3String {

    public boolean validarNIF(String nif){

        boolean validacion = true;

        if (nif.length() != 9){
            validacion = false;
        }

        for (int i = 0; i < nif.length() - 1 && validacion; i++){
            if (!Character.isDigit(nif.charAt(i))){
                validacion = false;
            }
        }

        int posicion = 8;
        char caracter = nif.charAt(posicion);

        if (!Character.isLetter(caracter)){
            validacion = false;
        }

        String letrasValidas = "TRWAGMYFPDXBNJZSQVHLCKE";
        String num = nif.substring(0,8);
        int numero = Integer.parseInt(num);
        String letraUsuario = String.valueOf(nif.charAt(numero % 23));

        if (!letrasValidas.equalsIgnoreCase(letraUsuario)){
            validacion = false;
        }

        return validacion;
    }


}
