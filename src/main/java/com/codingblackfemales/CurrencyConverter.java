package com.codingblackfemales;

public interface CurrencyConverter {

    // will return the converted amount (conversion from source to destination
    // currency)
    public double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount);

    // will return an array of available currency codes
    public String[] getCurrencyCodes();

    // will return the exchange rate between the provided currencies.
    public double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode);

}
