package com.codingblackfemales;

import java.util.HashMap;

public class CurrenciesStub implements Currencies {
    private HashMap<String, Double> exchangeRates;

    public CurrenciesStub() {
        this.exchangeRates = new HashMap<String, Double>() {
            {
                put("GBP", 1.00d);
                put("EUR", 1.16d);
                put("USD", 1.29d);
                put("NGN", 1020.26d);
                put("JMD", 200.13d);
                put("XCD", 3.49d);
            }
        };
    }

    public HashMap<String, Double> getAllExchangeRates() {
        return this.exchangeRates;
    }
}
