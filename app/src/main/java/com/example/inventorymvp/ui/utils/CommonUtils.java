package com.example.inventorymvp.ui.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase con utilidades disponibles para todas las clases de la apliación
 * Created by usuario on 13/11/17.
 */

public final class CommonUtils {
    /**
     * Método que comprueba que la contraseña tenga los siguientes requisitos
     * Debe contener al menos un dígito 0-9
     * Debe contener al menos un carácter en mayúscula
     * Debe contener al menos un carácter en minúscula
     * Y debe tener una longitud de al menos 6 carácteres
     * @param password
     * @return
     */
    public static boolean isPasswordValid(String password){
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}