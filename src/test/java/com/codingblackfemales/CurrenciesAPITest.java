package com.codingblackfemales;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class CurrenciesAPITest {

    @Mock
    private HttpURLConnection mockConnection;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCurrencyConversionA() throws IOException {
        // Initialise needed variables
        String apiKey = "8d246aca316c5a6059a8bd96";
        CurrenciesAPI api = new CurrenciesAPI(apiKey);
        String source = "USD";
        String destination = "EUR";
        double amount = 100.0d;

        // intitialise approx. current expected value
        double expectedConversionResult = 93.935d;

        // Mock the HttpURLConnection
        // mock the behaviour of getRsponseCode(), which should be sucessful HTTP
        // response
        when(mockConnection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);
        // create expected JSON string response from API
        String jsonResponse = "{\"conversion_result\": " + expectedConversionResult + "}";
        // InputStream to stimulate response from server
        InputStream responseStream = new ByteArrayInputStream(jsonResponse.getBytes());
        when(mockConnection.getInputStream()).thenReturn(responseStream);

        // Act
        double result = api.getCurrencyConversionA(source, destination, amount);

        // Assert
        double epsilon = 0.001d;
        assertTrue(Math.abs(expectedConversionResult - result) <= epsilon);
    }
}
