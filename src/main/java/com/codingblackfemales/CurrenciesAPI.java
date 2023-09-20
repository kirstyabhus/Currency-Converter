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
    public double testing() throws IOException {
        // Setting URL
        String urlStr = "https://v6.exchangerate-api.com/v6/8d246aca316c5a6059a8bd96/pair/";
        String source = "EUR";
        String destination = "GBP";

        // Making Request
        URL url = new URL(urlStr + source + "/" + destination);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        // Accessing object
        double reqResult = jsonobj.get("conversion_rate").getAsDouble();

        return reqResult;
    }
}
