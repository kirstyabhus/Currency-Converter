package com.codingblackfemales;

import java.util.HashMap;

public class CurrenciesStubEmpty implements Currencies {
    private HashMap<String, Double> exchangeRates;

    public CurrenciesStubEmpty() {
        this.exchangeRates = new HashMap<String, Double>();
    }

    public HashMap<String, Double> getAllExchangeRates() {
        return this.exchangeRates;
    }
}