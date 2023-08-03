package com.codingblackfemales;

import java.util.HashMap;

public class CurrenciesGBP implements Currencies {
    private HashMap<String, Double> exchangeRates;

    public CurrenciesGBP() {
        this.exchangeRates = new HashMap<String, Double>() {
            {
                put("GBP", 1.0);
                put("EUR", 1.16);
                put("USD", 1.31);
                put("JPY", 181.78);
            }
        };
    }

    public HashMap<String, Double> getAllExchangeRates() {
        return this.exchangeRates;
    }
}
