package com;

import java.util.Locale;

public class SetLocale {
    public static void setLocale(Locale locale,String language,String country){
        Locale.setDefault(new Locale(language,country));
    }
}
