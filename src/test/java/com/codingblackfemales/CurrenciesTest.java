package com.codingblackfemales;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class CurrenciesTest {
    private Currencies currencies;
    private HashMap<String, Double> exchangeRates;

    @Before
    public void setUp() {
        currencies = new CurrenciesGBP();
        exchangeRates = currencies.getAllExchangeRates();
    }

    @Test
    public void returnsAllAvailableCurrencyCodes() {
        HashMap<String, Double> actualResult = currencies.getAllExchangeRates();

        assertTrue(exchangeRates.size() == actualResult.size());
    }

    @Test
    public void returnsEmptyResultWhenNoAvailableExchangesAreFound() {
        Currencies currencies = new CurrenciesStubEmpty();
        HashMap<String, Double> currencyCodes = currencies.getAllExchangeRates();

        assertTrue(currencyCodes.size() == 0);
    }
}
