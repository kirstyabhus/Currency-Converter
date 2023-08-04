package com.codingblackfemales;

public interface CurrencyConverter {

    // will return the converted amount (conversion from source to destination
    // currency)
    double convertCurrency(String sourceCurrencyCose, String destinationCurrencyCode, double amount);

    // will return an array of available currency codes
    String[] getCurrencyCodes();

    // will return the exchange rate between the provided currencies.
    double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode);

}
