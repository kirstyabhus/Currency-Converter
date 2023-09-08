package com.codingblackfemales.exceptions;

import java.util.HashMap;

import com.codingblackfemales.CurrenciesGBP;

public class currencyExceptions {
    public double findException(String sourceCurrencyCode, String destinationCurrencyCode, double amount) {
        // create new instance of the CurrenciesGBP class (to access its methods)
        CurrenciesGBP currenciesGBP = new CurrenciesGBP();

        // get the exchange rates (hash map)
        HashMap<String, Double> exchangeRates = currenciesGBP.getAllExchangeRates();

        if (sourceCurrencyCode == "" || destinationCurrencyCode == "") {
            System.out.println("Exception: Currency code must not be null.");
            return 0.0;
        }

        if (amount < 0) {
            System.out.println("Exception: Amount must not be less than 0.");
            return 0.0;
        }

        if (exchangeRates.containsKey(sourceCurrencyCode) == false
                || exchangeRates.containsKey(destinationCurrencyCode) == false) {
            System.out.println("Exception: Currency code must be in the database.");
            return 0.0;
        }

        return 1.0;
    }
}
