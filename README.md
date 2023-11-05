# Currency Converter Application (Java)

An application that can convert a user-defined amount in a source currency to a destination currency. This application gives the user the option to convert currencies in the given, hard-coded class, or by using the live (daily-refreshed) exchange rates fetched from [ExchangeRate API](https://v6.exchangerate-api.com/). 
The application has been implemented as both a command-line application and with a Swing GUI.
## Description
### Currency Converter
#### CurrencyConverter interface
The CurrencyConverter interface includes three methods:
- `double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount)`: This method accepts a source currency code, a destination currency code, and an amount. It will return the converted amount.
- `String[] getCurrencyCodes()`: This method returns an array of available currency codes
- `double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode)`: This method returns the exchange rate between the provided currencies.
#### BasicCurrencyConverter class
The BasicCurrenciesConverter class implements the 'CurrencyConverter' interface. 
### Currency Converter (API)
The CurrenciesAPI class has the following method:
- `double getCurrencyConversionA(String source, String destination, double amount)`: This method excepts a source currency code, a destination currency code, and an amount. It will return the converted amount from the from [ExchangeRate-API](https://v6.exchangerate-api.com/), using exchange rates that update once per day.

## Demo
<p align="center">
  <img src="images/CLI(1).gif" alt="Currency Converter CLI demo" width="400" height="400"/>
</p>
<p align="center">
  <img src="images/SWING.gif" alt="Currency Converter SWING GUI demo" width="400" height="400"/>
</p>

## Prerequisites
### Running the Project
This project uses the [Java][1] programming language.

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
### Using the API option
Before using the API option of the Currency Converter, you need to obtain an API key from [ExchangeRate API](https://v6.exchangerate-api.com/). You will use this API key when initializing the `CurrenciesAPI` object.

## How to Install and Run this project


## Testing
To ensure that the API method functions correctly, you can run the included unit test which uses JUnit and Mockito.
