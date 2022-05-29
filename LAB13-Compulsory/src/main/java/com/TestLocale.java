package com;

import java.util.Locale;

import static com.DisplayLocales.*;
import static com.Info.displayInfo;

public class TestLocale {
    public static void main(String args[]) {
        displayMessages(Locale.forLanguageTag("ro"));
//-> Salut, Utilizatorul Duke s-a conectat la 2016-05-03, La revedere
        System.out.println();
        displayMessages(Locale.getDefault());
//-> Hello, User Duke logged in at 2016-05-03, Goodbye
        System.out.println();
        //displayAvailableLocales();
        displayCurrentLocale();
        System.out.println();
        displayInfo("ro","RO");
        System.out.println();
        displayInfo("ar","SA");
    }
}
