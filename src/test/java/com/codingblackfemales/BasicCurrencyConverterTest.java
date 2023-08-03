package com.codingblackfemales;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class BasicCurrencyConverterTest {
    private BasicCurrencyConverter basicCurrencyConverter;
    private Currencies currencies;
    private HashMap<String, Double> exchangeRates;

    private boolean isEqualDoubleValue(double expectedResult, double actualResult) {
        double epsilon = 0.000001d;
        return Math.abs(expectedResult - actualResult) <= epsilon;
    }

    @Before
    public void setUp() {
        currencies = new CurrenciesStub();
        exchangeRates = currencies.getAllExchangeRates();

        basicCurrencyConverter = new BasicCurrencyConverter(currencies);
    }

    @Test
    public void returnsAllAvailableCurrencyCodes() {
        String[] currencyCodes = basicCurrencyConverter.getCurrencyCodes();

        assertTrue(currencyCodes.length > 0);
    }

    @Test
    public void returnsTheExchangeRateForDestinationCurrencyWhenSourceCurrencyIsNotSterling() {
        String sourceCode = "USD";
        String destinationCode = "EUR";

        double expectedRate = (exchangeRates.get(destinationCode) / exchangeRates.get(sourceCode));

        double actualRate = basicCurrencyConverter.getExchangeRate(sourceCode,
                destinationCode);

        assertTrue(isEqualDoubleValue(expectedRate, actualRate));
    }

    @Test
    public void returnsTheConvertedValueForTheGivenCurrencies() {
        String sourceCode = "GBP";
        String destinationCode = "EUR";
        double amountToConvert = 2.00d;

        double expectedResult = (exchangeRates.get(destinationCode) / exchangeRates.get(sourceCode)) * amountToConvert;

        double actualResult = basicCurrencyConverter.convertCurrency(sourceCode,
                destinationCode, amountToConvert);

        assertTrue(isEqualDoubleValue(expectedResult, actualResult));
    }

    @Test
    public void returnsTheConvertedValueForEuroToUnitedStatesDollars() {
        String sourceCode = "EUR";
        String destinationCode = "USD";
        double amountToConvert = 2.5d;

        double expectedResult = (exchangeRates.get(destinationCode) / exchangeRates.get(sourceCode)) * amountToConvert;

        double actualResult = basicCurrencyConverter.convertCurrency(sourceCode,
                destinationCode, amountToConvert);

        assertTrue(isEqualDoubleValue(expectedResult, actualResult));
    }

    @Test
    public void returnsTheConvertedValueForNairatoEastCaribbeanDollars() {
        String sourceCode = "NGN";
        String destinationCode = "XCD";
        double amountToConvert = 1.00d;

        double expectedResult = (exchangeRates.get(destinationCode) / exchangeRates.get(sourceCode)) * amountToConvert;

        double actualResult = basicCurrencyConverter.convertCurrency(sourceCode,
                destinationCode, amountToConvert);

        double epsilon = 0.000001d;
        assertTrue(Math.abs(expectedResult - actualResult) <= epsilon);
    }

    @Test
    public void returnsTheConvertedValueForSterlingToSterling() {
        String sourceCode = "GBP";
        String destinationCode = "GBP";
        double amountToConvert = 2.00d;
        double expectedResult = 2.00d;

        double actualResult = basicCurrencyConverter.convertCurrency(sourceCode,
                destinationCode, amountToConvert);

        double epsilon = 0.000001d;
        assertTrue(Math.abs(expectedResult - actualResult) <= epsilon);
    }

    @Test
    public void returnsZeroValueWhenTheSourceCurrencyCodeIsNotPresent() {
        String sourceCode = "";
        String destinationCode = "GBP";
        double amountToConvert = 2.00d;
        double expectedResult = 0.0d;

        double actualResult = basicCurrencyConverter.convertCurrency(sourceCode,
                destinationCode, amountToConvert);

        assertTrue(expectedResult == actualResult);
    }

    @Test
    public void returnsZeroValueWhenTheDestinationCurrencyCodeIsNotPresent() {
        String sourceCode = "EUR";
        String destinationCode = "";
        double amountToConvert = 2.00d;
        double expectedResult = 0.0d;

        double actualResult = basicCurrencyConverter.convertCurrency(sourceCode,
                destinationCode, amountToConvert);

        assertTrue(expectedResult == actualResult);
    }

    @Test
    public void returnsZeroValueWhenTheAmountisNotAValidNumber() {
        String sourceCode = "EUR";
        String destinationCode = "GBP";
        double amountToConvert = 0.0;
        double expectedResult = 0.0d;

        double actualResult = basicCurrencyConverter.convertCurrency(sourceCode,
                destinationCode, amountToConvert);

        assertTrue(expectedResult == actualResult);
    }

    @Test
    public void returnsZeroValueWhenTheAmountIsAMinusValue() {
        String sourceCode = "USD";
        String destinationCode = "GBP";
        double amountToConvert = -2.00d;
        double expectedResult = 0.0d;

        double actualResult = basicCurrencyConverter.convertCurrency(sourceCode,
                destinationCode, amountToConvert);

        assertTrue(expectedResult == actualResult);
    }

    @Test
    public void returnsZeroValueWhenTheSourceCurrencyIsNotASupportedCurrency() {
        String sourceCode = "ABC";
        String destinationCode = "GBP";
        double amountToConvert = 2.00d;
        double expectedResult = 0.0d;

        double actualResult = basicCurrencyConverter.convertCurrency(sourceCode,
                destinationCode, amountToConvert);

        assertTrue(expectedResult == actualResult);
    }

    @Test
    public void returnsZeroValueWhenTheDestinationCurrencyIsNotASupportedCurrency() {
        String sourceCode = "EUR";
        String destinationCode = "ABC";
        double amountToConvert = 2.00d;
        double expectedResult = 0.0d;

        double actualResult = basicCurrencyConverter.convertCurrency(sourceCode,
                destinationCode, amountToConvert);

        assertTrue(expectedResult == actualResult);
    }

    @Test
    public void returnsEmptyResultWhenNoAvailaleCurrencyCodesAreFound() {
        Currencies currencies = new CurrenciesStubEmpty();
        basicCurrencyConverter = new BasicCurrencyConverter(currencies);
        String[] currencyCodes = basicCurrencyConverter.getCurrencyCodes();

        assertTrue(currencyCodes.length == 0);
    }
}
