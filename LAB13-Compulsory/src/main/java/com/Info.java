package com;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;
import java.util.spi.CurrencyNameProvider;

import static com.SetLocale.setLocale;

public class Info {
    public static void displayInfo(String language,String country)
    {
        Locale locale = new Locale(language, country);
        LocalDate currentdate = LocalDate.now();
        System.out.println("Country: "+ locale.getDisplayCountry());
        System.out.println("Language: "+ locale.getDisplayLanguage());
        System.out.println("Currency: "+ Currency.getInstance(locale));
        System.out.println("Week days: "+ Arrays.toString(new DateFormatSymbols()
                .getInstance(locale).getWeekdays()));
        System.out.println("Months: "+ Arrays.toString(new DateFormatSymbols()
                .getInstance(locale).getMonths()));
        System.out.println("Today: " + currentdate.getMonth() + " " + currentdate.getDayOfMonth() + ", " + currentdate.getYear());
    }
}
