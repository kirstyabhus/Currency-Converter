package com.codingblackfemales;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;

import com.codingblackfemales.exceptions.currencyExceptions;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashSet;

public class BasicCurrencyConverter implements CurrencyConverter {
    HashMap<String, Double> currenciesGBP;

    // add constuctor
    public BasicCurrencyConverter(Currencies currencies) {
        // will get the exchange rates HashMap from the given currencies
        this.currenciesGBP = currencies.getAllExchangeRates();
    }

    // will return the converted amount (conversion from source to destination
    // currency)
    public double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount) {

        // create an instance of currencyExceptions to use the methods of this class
        currencyExceptions currencyExceptions = new currencyExceptions();

        // use the given values to check for exceptions
        double exceptionValue = currencyExceptions.findException(sourceCurrencyCode, destinationCurrencyCode, amount,
                currenciesGBP);

        // Exception handling
        if (exceptionValue == 0.0) {
            return 0.0;
        }

        // TODO add Try-catch with return in try
        // TODO try throws again

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
        // Setting URL
        String url_str = "https://v6.exchangerate-api.com/v6/8d246aca316c5a6059a8bd96/pair/";

        // Making Request
        URL url;
        try {
            url = new URL(url_str + sourceCurrencyCode + "/" + destinationCurrencyCode);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            // Accessing object
            double req_result = jsonobj.get("conversion_rate").getAsDouble();

            return req_result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

}
