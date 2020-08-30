package com.swissre.assessment.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import static com.swissre.assessment.rest.ParameterStringBuilder.getParameterString;
import static java.util.stream.Collectors.joining;

public class RestClient {

    private static final String ENDPOINT = "https://min-api.cryptocompare.com/data/price";
    private static final int SUCCESS = 200;

    public String sendRequest(Map<String, String> parameters) {
        try {
            return composeRequest(parameters);
        } catch (IOException e) {
            throw new RuntimeException("Error opening connection to REST API");
        }
    }

    private String composeRequest(Map<String, String> parameters) throws IOException {
        URL url = new URL(ENDPOINT + getParameterString(parameters));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");

        if (connection.getResponseCode() != SUCCESS) {
            throw new RuntimeException("Request failed - HTTP error code : " + connection.getResponseCode());
        }

        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()))) {
            return bufferedReader.lines().collect(joining("\n"));
        }
    }
}
