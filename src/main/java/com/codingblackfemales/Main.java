package com.codingblackfemales;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String apiKey = "8d246aca316c5a6059a8bd96";

        CurrenciesGBP currenciesGBP = new CurrenciesGBP();
        BasicCurrencyConverter converter = new BasicCurrencyConverter(currenciesGBP);
        CurrenciesAPI currenciesAPI = new CurrenciesAPI(apiKey);

        // create an object of Scanner
        Scanner input = new Scanner(System.in);

        // welcome message and options
        System.out.println("\n--- Kirsty's Currency Converter ---\n");
        System.out.println("Choose an option from below:");
        System.out.println("1. Convert currency");
        // System.out.println("2. Get exchange rate");
        System.out.println("2. Convert currency (API)\n");

        // user option
        String option;

        // user option choice input kept within do-while, to ensure user only chooses
        // the avaliable options. If input is not one of the options, the user will be
        // promted for an input again
        do {

            System.out.println("Option: ");
            // take the option input from the user
            option = input.nextLine();

            // if the input is not one of the avaliable options, let the user know
            if (!option.equals("1") && !option.equals("2")) {
                System.out
                        .println("Option " + option + " is not available. Please choose between options 1 and 2.\n");
            }

            // continue asking the user for input if their input option is not one of the
            // avaliable options
        } while (!option.equals("1") && !option.equals("2"));

        // TODO Make this less repetitive
        // convert currency option
        if (option.equals("1")) {
            // ask the user for source code input
            System.out.println("\nEnter your source currency code: ");
            // output currency codes array as string, to show avaliable currencies
            System.out.println(Arrays.toString(converter.getCurrencyCodes()));
            // take the source code input from the user
            String sourceCurrency = input.nextLine().toUpperCase();

            // ask the user for destination code input
            System.out.println("\nEnter your destination currency code: ");
            // output currency codes array as string, to show avaliable currencies
            System.out.println(Arrays.toString(converter.getCurrencyCodes()));
            // take the destination code input from the user
            String destinationCurrency = input.nextLine().toUpperCase();

            System.out
                    .println("\nEnter the amount of " + sourceCurrency + " to convert to " + destinationCurrency + ":");
            // take the amount input from the user
            double amount = input.nextDouble();

            // close the scanner object
            input.close();

            double exchangeRate = currenciesAPI.getCurrencyConversionA(sourceCurrency, destinationCurrency, 1);
            double convertedAmount = converter.convertCurrency(sourceCurrency, destinationCurrency, amount);

            System.out.println("\n" + 1 + " " + sourceCurrency + " = " + exchangeRate + " " + destinationCurrency);
            // output the converted amount
            System.out.println(amount + " " + sourceCurrency + " = " + convertedAmount + " " + destinationCurrency);

            // convert currency (API version)
        } else if (option.equals("2")) {
            // ask the user for source code input
            System.out.println("\nEnter your source currency code: ");
            // take the source code input from the user
            String sourceCurrency = input.nextLine().toUpperCase();

            // ask the user for destination code input
            System.out.println("\nEnter your destination currency code: ");
            // take the destination code input from the user
            String destinationCurrency = input.nextLine().toUpperCase();

            System.out
                    .println("\nEnter the amount of " + sourceCurrency + " to convert to " + destinationCurrency + ":");
            // take the amount input from the user
            double amount = input.nextDouble();

            // close the scanner object
            input.close();

            // exchange rate
            double exchangeRate = currenciesAPI.getCurrencyConversionA(sourceCurrency, destinationCurrency, 1);
            // convert the given currency
            double convertedAmount = currenciesAPI.getCurrencyConversionA(sourceCurrency, destinationCurrency, amount);

            // if the API method returns 0.0, meaning incorrect currency code
            if (convertedAmount == 0.0) {
                System.out.println("\nException: Currency code must be in the database.");
            } else {
                // output the converted amount
                System.out.println("\n" + 1 + " " + sourceCurrency + " = " + exchangeRate + " " + destinationCurrency);
                System.out.println(amount + " " + sourceCurrency + " = " + convertedAmount + " " + destinationCurrency);
            }

        }
    }
}
