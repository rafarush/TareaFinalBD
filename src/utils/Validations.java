package utils;

public class Validations {
    public static boolean validarCarnet(String cadena) {
        boolean valido = true;

        String siglo = cadena.substring(7, 8);
        int compSiglo = Integer.parseInt(siglo);

        if (compSiglo == 9 && valido) {
            valido = false; // Siglo XIX
        }

        String anyo = cadena.substring(0, 2);
        int compAnyo = Integer.parseInt(anyo);

        if (valido && ((compSiglo >= 6 && compSiglo < 9) && compAnyo > 25)) {
            valido = false; // Siglo XXI y a�o mayor que el actual (inv�lido).
        }

        if (valido && ((compSiglo >= 0 && compSiglo < 6) && compAnyo < 60)) {
            valido = false; // Siglo XX y mayor que 100 a�os.
        }

        String mes = cadena.substring(2, 4);
        int compMes = Integer.parseInt(mes);

        if (compMes < 1 || compMes > 12) {
            valido = false; // Solo 12 meses.
        }

        String dia = cadena.substring(4, 6);
        int compDia = Integer.parseInt(dia);

        if (valido && compDia < 1) {
            valido = false;
        }
        if (valido && compDia > 31) {
            valido = false;
        }
        if (valido && ((compMes < 8 && compMes != 2 && compMes % 2 == 0) && compDia > 30)) {
            valido = false;
        }
        if (valido && ((compMes > 7 && compMes != 2 && compMes % 2 != 0) && compDia > 30)) {
            valido = false;
        }

        // A�o bisiesto y validaci�n de febrero
        int annoInt = Integer.parseInt(cadena.substring(0, 2));
        if (valido && (compMes == 2 && annoInt % 4 == 0 && compDia > 29)) {
            valido = false;
        }
        if (valido && (compMes == 2 && annoInt % 4 != 0 && compDia > 28)) {
            valido = false;
        }

        return valido;
    }
    public static boolean nameValidation(String cadena) {
        boolean valido = true;
        valido = cadena.contains(" ");
        if (!valido) {
            int i=0;
            while (i < cadena.length() && valido) {
                char c = cadena.charAt(i);
                if (!Character.isLetter(c)) {
                    valido = false;
                }
                i++;
            }
        }
        return valido;
    }
}
