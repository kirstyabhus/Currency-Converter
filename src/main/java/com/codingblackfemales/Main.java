package com.codingblackfemales;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        BasicCurrencyConverter converter = new BasicCurrencyConverter();

        // output currency codes array as string
        System.out.println(Arrays.toString(converter.getCurrencyCodes()));

        // output exchange rate
        // System.out.println(converter.getExchangeRate("GBP", "EUR"));

    }
}
