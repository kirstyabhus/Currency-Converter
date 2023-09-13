package com.codingblackfemales;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        CurrenciesGBP currenciesGBP = new CurrenciesGBP();

        BasicCurrencyConverter converter = new BasicCurrencyConverter(currenciesGBP);

        // output currency codes array as string
        System.out.println(Arrays.toString(converter.getCurrencyCodes()));

        // output exchange rate
        System.out.println(converter.getExchangeRate("EUR", "GBP"));

        // output exchange rate
        System.out.println(converter.convertCurrency("EUR", "GBP", 2));

        CurrenciesAPI currenciesAPI = new CurrenciesAPI();

        System.out.println(currenciesAPI.testing());
    }
}
