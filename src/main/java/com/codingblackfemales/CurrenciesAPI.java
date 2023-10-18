package com.codingblackfemales;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

// API returns JSON data so Gson library is used to deserialize the JSON response into Java objects.

public class CurrenciesAPI {
    private final String apiKey;

    public CurrenciesAPI(String apiKey) {
        this.apiKey = apiKey;
    }

    // METHOD TO GET THE CONVERSION BETWEEN TWO CURRENCIES
    public double getCurrencyConversionA(String source, String destination, double amount) {
        // Set URL
        String urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/";

        // initialise the HttpURLConnection beforehand (since it will need to be closed
        // after)
        HttpURLConnection request = null;

        try {
            // make request
            URL url = new URL(urlStr + source + "/" + destination + "/" + amount);
            request = (HttpURLConnection) url.openConnection();
            request.connect();

            // if the HTTP request is successful (200 response code i.e. HTTP_OK)
            if (request.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // Convert to JSON response into a JSON object
                JsonParser jp = new JsonParser();
                JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
                JsonObject jsonobj = root.getAsJsonObject();
                // access object and get the conversion result as a double
                double reqResult = jsonobj.get("conversion_result").getAsDouble();
                // return the converted amount
                return reqResult;

                // if the HTTP request is unsuccessful
            } else {
                // throw IOException with HTTP status code
                throw new IOException("HTTP request failed with code: " + request.getResponseCode());
            }
            // handling of IOException
        } catch (IOException e) {
            // e.printStackTrace();
            // error value to return
            return 0.0;
            // a finally block to close the HTTP connection, regardless of whether an
            // excpetion occured or not
        } finally {
            if (request != null) {
                request.disconnect();
            }
        }
    }

    // METHOD TO GET ALL THE CURRENCY CODES SUPPORTED BY THE API
    public ArrayList<String> getCurrencyCodes() {
        // Set URL
        String urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey + "/codes";

        // initialise the HttpURLConnection beforehand (since it will need to be closed
        // after)
        HttpURLConnection request = null;

        try {
            // make request
            URL url = new URL(urlStr);
            request = (HttpURLConnection) url.openConnection();
            request.connect();

            // if the HTTP request is successful (200 response code i.e. HTTP_OK)
            if (request.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // Convert to JSON response into a JSON object
                JsonParser jp = new JsonParser();
                JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
                JsonObject jsonobj = root.getAsJsonObject();

                // access the "supported_codes" array from the JSON object
                JsonArray supportedCodes = jsonobj.getAsJsonArray("supported_codes");

                // create new arraylist to store the currency codes (with their names)
                ArrayList<String> currencyCodes = new ArrayList<String>();
                // process the elemets in the "supported_codes" array
                for (JsonElement element : supportedCodes) {
                    JsonArray codeArray = element.getAsJsonArray();
                    String code = codeArray.get(0).getAsString();
                    String name = codeArray.get(1).getAsString();
                    currencyCodes.add(code + " (" + name + ")");
                }

                return currencyCodes;
                // if the HTTP request is unsuccessful
            } else {
                // throw IOException with HTTP status code
                throw new IOException("HTTP request failed with code: " + request.getResponseCode());
            }
            // handling of IOException
        } catch (IOException e) {
            // e.printStackTrace();
            // error value to return
            return new ArrayList<>();
            // a finally block to close the HTTP connection, regardless of whether an
            // excpetion occured or not
        } finally {
            if (request != null) {
                request.disconnect();
            }
        }

    }
}
