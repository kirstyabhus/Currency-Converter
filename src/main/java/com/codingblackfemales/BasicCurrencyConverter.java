package com.codingblackfemales;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class BasicCurrencyConverter implements CurrencyConverter {

    // will return the converted amount (conversion from source to destination
    // currency)
    public double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount) {
        return 0; // place holder

        // TODO handle exception for Invalid or null amount.
    }

    // will return an array of available currency codes
    public String[] getCurrencyCodes() {
        // create new instance of the CurrenciesGBP class (to access its methods)
        CurrenciesGBP currenciesGBP = new CurrenciesGBP();

        // get the exchange rates (hash map)
        HashMap<String, Double> exchangeRates = currenciesGBP.getAllExchangeRates();

        // create & store a String set of the currency codes from the exchangeRates
        // HashMap
        Set<String> currencyCodesSet = new HashSet<>(exchangeRates.keySet());

        // return a String array containing the currencyCode elements of the set
        // new array is the same size as the currency code set
        String[] currencyCodes = currencyCodesSet.toArray(new String[exchangeRates.size()]);

        return currencyCodes;

    }

    // will return the exchange rate between the provided currencies.
    public double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode) {
        // create new instance of the CurrenciesGBP class (to access its methods)
        CurrenciesGBP currenciesGBP = new CurrenciesGBP();

        // get the exchange rates (hash map)
        HashMap<String, Double> exchangeRates = currenciesGBP.getAllExchangeRates();

        // calculate exchange rate between currencies using GBP exchange rate
        // (sourceCurrencyAmount / sourceCurrencyGBPExchangeR) *
        // destinationCurrencyGBPExchangeR = destinationCurrencyAmount
        // so below gives exchange rate
        double exchangeRate = exchangeRates.get(destinationCurrencyCode) / exchangeRates.get(sourceCurrencyCode);

        // TODO handle exception for Invalid or missing source currency code.
        // TODO handle exception for Invalid or missing destination currency code.

        return exchangeRate;
    }

}
