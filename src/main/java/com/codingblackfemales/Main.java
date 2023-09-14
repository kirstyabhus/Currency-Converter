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
        System.out.println("--- Welcome to Kirsty's Currency Converter ---\n");
        System.out.println("Choose an option from below:");
        System.out.println("1. Convert currency");
        System.out.println("2. View accepted currency codes");
        System.out.println("3. Get exchange rate\n");

        System.out.println("Option: ");
        // take the option input from the user
        String option = input.nextLine();

        if (option.equals("1")) {
            // ask the user for source code input
            System.out.println("Enter your source currency code: ");
            // take the source code input from the user
            String sourceCurrency = input.nextLine();

            // ask the user for destination code input
            System.out.println("Enter your destination currency code: ");
            // take the destination code input from the user
            String destinationCurrency = input.nextLine();

            System.out.println("Enter the amount of " + sourceCurrency + " to convert to " + destinationCurrency + ":");
            // take the amount input from the user
            double amount = input.nextDouble();

            // close the scanner object
            input.close();

            System.out.println(converter.convertCurrency(sourceCurrency, destinationCurrency, amount));
        } else if (option.equals("2")) {

            // output currency codes array as string
            System.out.println(Arrays.toString(converter.getCurrencyCodes()));

        } else if (option.equals("3")) {
            // ask the user for source code input
            System.out.println("Enter your source currency code: ");
            // take the source code input from the user
            String sourceCurrency = input.nextLine();

            // ask the user for destination code input
            System.out.println("Enter your destination currency code: ");
            // take the destination code input from the user
            String destinationCurrency = input.nextLine();

            // close the scanner object
            input.close();

            // output exchange rate
            System.out.println(converter.getExchangeRate(sourceCurrency, destinationCurrency));

        }
    }
}
