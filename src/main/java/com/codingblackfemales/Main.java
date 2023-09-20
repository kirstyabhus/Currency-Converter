package com.codingblackfemales;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CurrenciesGBP currenciesGBP = new CurrenciesGBP();
        BasicCurrencyConverter converter = new BasicCurrencyConverter(currenciesGBP);

        // create an object of Scanner
        Scanner input = new Scanner(System.in);

        // welcome message and options
        System.out.println("\n--- Welcome to Kirsty's Currency Converter ---\n");
        System.out.println("Choose an option from below:");
        System.out.println("1. Convert currency");
        System.out.println("2. Get exchange rate");
        System.out.println("3. Convert currency (API)\n");

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
            if (!option.equals("1") && !option.equals("2") && !option.equals("3")) {
                System.out
                        .println("Option " + option + " is not available. Please choose between options 1, 2 and 3.\n");
            }

            // continue asking the user for input if their input option is not one of the
            // avaliable options
        } while (!option.equals("1") && !option.equals("2") && !option.equals("3"));

        // convert currency option
        if (option.equals("1")) {
            // ask the user for source code input
            System.out.println("\nEnter your source currency code: ");
            // output currency codes array as string, to show avaliable currencies
            System.out.println(Arrays.toString(converter.getCurrencyCodes()));
            // take the source code input from the user
            String sourceCurrency = input.nextLine();

            // ask the user for destination code input
            System.out.println("\nEnter your destination currency code: ");
            // output currency codes array as string, to show avaliable currencies
            System.out.println(Arrays.toString(converter.getCurrencyCodes()));
            // take the destination code input from the user
            String destinationCurrency = input.nextLine();

            System.out
                    .println("\nEnter the amount of " + sourceCurrency + " to convert to " + destinationCurrency + ":");
            // take the amount input from the user
            double amount = input.nextDouble();

            // close the scanner object
            input.close();

            double convertedAmount = converter.convertCurrency(sourceCurrency, destinationCurrency, amount);

            // output the converted amount
            System.out.println(amount + " " + sourceCurrency + " = " + convertedAmount + " " + destinationCurrency);

            // get exchange rate option
        } else if (option.equals("2")) {
            // ask the user for source code input
            System.out.println("\nEnter your source currency code: ");
            // output currency codes array as string, to show avaliable currencies
            System.out.println(Arrays.toString(converter.getCurrencyCodes()));
            // take the source code input from the user
            String sourceCurrency = input.nextLine();

            // ask the user for destination code input
            System.out.println("\nEnter your destination currency code: ");
            // output currency codes array as string
            System.out.println(Arrays.toString(converter.getCurrencyCodes()));
            // take the destination code input from the user
            String destinationCurrency = input.nextLine();

            // close the scanner object
            input.close();

            // get the exchange rate from the given currencies
            double exchangeRate = converter.getExchangeRate(sourceCurrency, destinationCurrency);

            System.out.println("1 " + sourceCurrency + " = " + exchangeRate + " " + destinationCurrency);

        }
    }
}
