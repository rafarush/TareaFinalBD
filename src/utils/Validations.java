package utils;

import java.sql.Date;
import java.time.LocalDate;

public class Validations {
    public static boolean validarCarnet(String cadena) {
        boolean valido = true;

        String siglo = cadena.substring(7, 8);
        int compSiglo = Integer.parseInt(siglo);

        if (compSiglo == 9 && valido) {
            valido = false;
        }

        String anyo = cadena.substring(0, 2);
        int compAnyo = Integer.parseInt(anyo);

        if (valido && ((compSiglo >= 6 && compSiglo < 9) && compAnyo > 25)) {
            valido = false;
        }

        if (valido && ((compSiglo >= 0 && compSiglo < 6) && compAnyo < 60)) {
            valido = false;
        }

        String mes = cadena.substring(2, 4);
        int compMes = Integer.parseInt(mes);

        if (compMes < 1 || compMes > 12) {
            valido = false;
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



    public static Date extractBirthdateFromCI(String ci) {
        if (ci == null || ci.length() < 6) {
            throw new IllegalArgumentException("Carné de identidad inválido.");
        }

        try {
            String aa = ci.substring(0, 2);
            String mm = ci.substring(2, 4);
            String dd = ci.substring(4, 6);

            int year = Integer.parseInt(aa);
            int month = Integer.parseInt(mm);
            int day = Integer.parseInt(dd);

            // Asumimos que nadie tiene más de 100 años
            int currentYear = LocalDate.now().getYear() % 100;
            int century = (year <= currentYear) ? 2000 : 1900;

            LocalDate birthDate = LocalDate.of(century + year, month, day);
            return Date.valueOf(birthDate); // Convertimos a java.sql.Date

        } catch (Exception e) {
            throw new IllegalArgumentException("Error al procesar el carné de identidad: " + e.getMessage());
        }
    }



    public static void validateEmail(String email) {
        if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Correo electrónico inválido: " + email);
        }
    }

}
