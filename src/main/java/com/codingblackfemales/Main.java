package com.codingblackfemales;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // create an object of Scanner
        Scanner input = new Scanner(System.in);

        // ask the user for source code input
        System.out.println("Enter your source currency code: ");
        // take the source code input from the user
        String sourceCurrency = input.nextLine();

        // ask the user for destination code input
        System.out.println("Enter your destination currency code: ");
        // take the destination code input from the user
        String destinationCurrency = input.nextLine();

        // ask the user for the amount to convert
        System.out.println("Enter the amount of " + sourceCurrency + " to convert to " + destinationCurrency + ":");
        // take the amount input from the user
        double amount = input.nextDouble();

        // close the scanner object
        input.close();

        CurrenciesGBP currenciesGBP = new CurrenciesGBP();

        BasicCurrencyConverter converter = new BasicCurrencyConverter(currenciesGBP);

        // output currency codes array as string
        System.out.println(Arrays.toString(converter.getCurrencyCodes()));

        // output exchange rate
        System.out.println(converter.getExchangeRate(sourceCurrency, destinationCurrency));

        System.out.println(converter.convertCurrency(sourceCurrency, destinationCurrency, amount));

    }
}
