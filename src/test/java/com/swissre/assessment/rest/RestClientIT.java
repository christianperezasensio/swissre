package com.swissre.assessment.rest;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RestClientIT {

    private final RestClient restClient = new RestClient();
    private static final String FROM_SYMBOL_KEY = "fsym";
    private static final String FROM_SYMBOL_VALUE = "BTC";
    private static final String TO_SYMBOL_KEY = "tsyms";
    private static final String TO_SYMBOL_VALUE = "EUR";

    @Test
    void sendRequest() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put(FROM_SYMBOL_KEY, FROM_SYMBOL_VALUE);
        parameters.put(TO_SYMBOL_KEY, TO_SYMBOL_VALUE);

        String response = restClient.sendRequest(parameters);
        assertTrue(response.contains(TO_SYMBOL_VALUE));
    }
}
