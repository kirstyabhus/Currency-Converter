package com.codingblackfemales;

import java.util.HashMap;
import java.util.Set;

import com.codingblackfemales.exceptions.CurrencyExceptions;

import java.util.HashSet;

public class BasicCurrencyConverter implements CurrencyConverter {
    HashMap<String, Double> currenciesGBP;

    // constuctor
    public BasicCurrencyConverter(Currencies currencies) {
        // get the exchange rates HashMap from the given currencies
        this.currenciesGBP = currencies.getAllExchangeRates();
    }

    // will return the converted amount (conversion from source to destination
    // currency)
    public double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount) {

        // create new instance of currencyExceptions
        CurrencyExceptions currencyExceptions = new CurrencyExceptions();
        // find the exceptions that will occur from the inputs
        double exceptionValue = currencyExceptions.findException(sourceCurrencyCode, destinationCurrencyCode, amount,
                currenciesGBP);
        // if theres an exception, return 0.0
        if (exceptionValue == 0.0) {
            return 0.0;
        }
        // calculate the destination amount, after getting the exchange rate
        double destinationAmount = amount * getExchangeRate(sourceCurrencyCode, destinationCurrencyCode);

        return destinationAmount;
    }

    // will return an array of available currency codes
    public String[] getCurrencyCodes() {
        // create & store a String set of the currency codes from the exchangeRates
        // HashMap
        Set<String> currencyCodesSet = new HashSet<>(currenciesGBP.keySet());
        // return a String array containing the currencyCode elements of the set
        // new array is the same size as the currency code set
        String[] currencyCodes = currencyCodesSet.toArray(new String[currencyCodesSet.size()]);

        return currencyCodes;

    }

    // will return the exchange rate between the provided currencies.
    public double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode) {
        // calculate exchange rate between currencies using GBP exchange rate
        double exchangeRate = currenciesGBP.get(destinationCurrencyCode) / currenciesGBP.get(sourceCurrencyCode);

        return exchangeRate;
    }

}
