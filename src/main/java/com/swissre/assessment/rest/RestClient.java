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

    public String sendRequest(String request, Map<String, String> parameters) throws IOException {
        URL url = new URL(request + getParameterString(parameters));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");

        if (connection.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
        }

        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()))) {
            return bufferedReader.lines().collect(joining("\n"));
        }
    }
}
