package com;

import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;

public class DisplayLocales {
    public static void displayMessages(Locale locale) {
        String baseName = "MyResources";
        ResourceBundle messages =
                ResourceBundle.getBundle(baseName, locale);
        System.out.println(messages.getString("hello"));
        String pattern = messages.getString("welcome");
        Object[] arguments = {"Duke", LocalDate.now()};
        String welcome = new MessageFormat(pattern).format(arguments);
        System.out.println(welcome);
        System.out.println(messages.getString("bye"));
    }
    public static void displayAvailableLocales() {
        System.out.println("Available locales:");
        Locale available[] =
                Locale.getAvailableLocales();
        for (Locale locale : available) {
            System.out.println(locale.getDisplayCountry() + "\t" +
                    locale.getDisplayLanguage(locale));
        }
    }
    public static void displayCurrentLocale(){
        System.out.println("Default locale:");
        System.out.println(Locale.getDefault());
    }
}
