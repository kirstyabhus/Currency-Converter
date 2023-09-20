package com.codingblackfemales;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

// API returns JSON data so Gson library is used to deserialize the JSON response into Java objects.

public class CurrenciesAPI {
    public double getCurrencyConversionA(String source, String destination, double amount) {
        // Set URL
        String urlStr = "https://v6.exchangerate-api.com/v6/8d246aca316c5a6059a8bd96/pair/";

        // initialise the HttpURLConnection beforehand (since it will need to be closed after)
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
            e.printStackTrace(); 
            // error value to return
            return 0.0; 
        // a finally block to close the HTTP connection, regardless of whether an excpetion occured or not
        } finally {
            if (request != null) {
                request.disconnect();
            }
        }
    }
}
