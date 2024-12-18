public class Tarea3String {

    public boolean esCorrectoNif(String nif){

        boolean validacion = false;


        if (nif.length() == 8 && digitos(nif) && ){

        }


        return validacion;
    }


    public boolean digitos(String nif){

        boolean digito = true;

        for (int i = 0; i < nif.length() - 1 && digito; i++){

            if (!Character.isDigit(Integer.parseInt(nif))){
                digito = false;
            }
        }

    return digito;
    }



    public boolean letra(String nif){

        boolean ultimo = false;
        int posicion = 8;
        String[] serie = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};


        char caracter = nif.charAt(posicion);

        if (Character.isLetter(caracter)){
            
        }



        return ultimo;
    }

















}
