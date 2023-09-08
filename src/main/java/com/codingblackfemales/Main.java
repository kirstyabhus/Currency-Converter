package com.codingblackfemales;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        CurrenciesGBP currenciesGBP = new CurrenciesGBP();

        BasicCurrencyConverter converter = new BasicCurrencyConverter(currenciesGBP);

        // output currency codes array as string
        System.out.println(Arrays.toString(converter.getCurrencyCodes()));

        // output exchange rate
        System.out.println(converter.getExchangeRate("GBP", "EUR"));

    }
}
