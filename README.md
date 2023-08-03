[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/WOfrqnzM)
# Java Assessment: Currency Converter Application

## Objective

You are required to implement a Java class that can convert a user-defined amount in a source currency to a destination currency. This assignment aims to demonstrate your understanding of basic Java syntax, inheritance, exception handling, and working with arrays.

## Description

You must create the following two files:

1. `CurrencyConverter.java`: This will contain an interface that must define three methods:

   a. `double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount)`: This method must accept a source currency code, a destination currency code, and an amount. It will return the converted amount (i.e. the value of the destination currency once converted from the provided amount in the source currency).

   b. `String[] getCurrencyCodes()`: This method will return an array of available currency codes.

   b. `double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode)`: This method will return the exchange rate between the provided currencies.

2. `BasicCurrencyConverter.java`: This will contain a class that must implement the `CurrencyConverter` interface. 

Ensure your code is appropriately documented, following best practices for comments.

## Specifications

1. You should implement exception handling in your application. This should cover situations where invalid or missing inputs occur. 

2. You need to handle the following exceptions:

   a. Invalid or missing source currency code.
   
   b. Invalid or missing destination currency code.

   c. Invalid or null amount.

3. The currencies are available as a hard-coded HashMap using the currency code as the key and the exchange rate relative to GBP. This HashMap is exposed as a static property of the provided `CurrenciesGBP` class for simplicity. Your `BasicCurrencyConverter` class must use this class to retrieve the currency rates.

## Prerequisites

This starter project uses the [Java][1] programming language.

Before getting started, ensure you have Java 17 LTS (or higher) installed locally. The following commands should output the version of Java installed.

```bash
$ javac -version

javac 17.0.4
```


```bash
$ java -version

openjdk version "17.0.4" 2022-07-19 LTS
OpenJDK Runtime Environment Zulu17.36+13-CA (build 17.0.4+8-LTS)
OpenJDK 64-Bit Server VM Zulu17.36+13-CA (build 17.0.4+8-LTS, mixed mode, sharing)
```

## Instructions

1. Clone this repository to your local machine.
```bash
git clone git@github.com:cbfacademy/java-currency-converter-assessment-[your student identifier].git
cd java-currency-converter-assessment-[your student identifier]
git checkout -b ${your-branch-name}
```

3. Open in Visual Studio Code (or your preferred IDE).
4. Install the project dependencies and validate your project by running the following command in a terminal at the root of your project:

```bash
./mvnw clean validate
```

If you are on a Windows machine, that will be:

```bat
mvnw clean validate
```

You should see the following console output:

```bash
./mvnw clean validate

[INFO] Scanning for projects...
[INFO] 
[INFO] --------------< com.codingblackfemales:java-currency-converter-assessment >-----------------
[INFO] Building java-currency-converter-assessment 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:3.2.0:clean (default-clean) @ java-currency-converter-assessment ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.155 s
[INFO] Finished at: 2022-11-03T20:56:09Z
[INFO] ------------------------------------------------------------------------

```

5. Start by creating the `CurrencyConverter` interface.

6. Implement the `BasicCurrencyConverter` class. This class should use the provided `CurrenciesGBP` class when calculating the exchange rates and amounts.

7.  Implement exception handling to manage scenarios where the user enters invalid or missing inputs.

## Testing

To verify that your code works as expected, run the `BasicCurrencyConverterTest` tests.

In your terminal, ensure that you are in the `java-currency-converter-assessment-[your student identifier]` folder.
Then run the following command in your terminal.

```shell
./mvnw clean test
```

If you are on Windows, run this command instead:

```shell
mvnw.cmd clean test
```

### Tests Results

Your implementation is correct when all tests pass:
```
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.codingblackfemales.BasicCurrencyConverterTest
[INFO] Tests run: 13, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.015 s - in com.codingblackfemales.BasicCurrencyConverterTest
[INFO] Running com.codingblackfemales.CurrenciesTest
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 s - in com.codingblackfemales.CurrenciesTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 15, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.366 s
[INFO] Finished at: 2023-08-02T19:45:08+01:00
[INFO] ------------------------------------------------------------------------
```

## Submission

Commit all files and push and merge to the main branch of your remote repo in GitHub. It may be helpful to submit a PR and ask your mentor to review it. Your submission should include:

1. `CurrencyConverter.java`
2. `BasicCurrencyConverter.java`

## Due Date

Please refer to the course schedule in the Learning Platform for this assignment's due date. Late submissions without an approved extension will be penalised.

## Stretch Goals

For any students who complete early and want an additional challenge, you can consider the following changes. **IMPORTANT:** These steps may require skills that haven't yet been taught on the course. *They are not required*, you don't have to attempt them if you don't want to!

1. Extend the number of currencies supported by the `CurrenciesGBP` class. Use real-world exchange rates or make up your own.
2. Implement the `Main` class as a command-line application allowing a user to get the converted amount between any supported currencies. Note: This will require research into input and output streams.

Remember, the best way to learn to program is by doing. Take this opportunity to enhance your understanding of Java. Good luck, and happy coding!
