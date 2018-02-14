package com.scarduelli.robo.nasa.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lucas-linux
 */
public enum Comandos {
    
    L, R, M;
    
    public static boolean validar(final String comando) {

        final String regex = "^[lrm]+$";

        final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE 
                                    | Pattern.UNICODE_CASE | Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(comando);
        return matcher.matches();
        
    }
    
}
