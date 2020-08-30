package com.swissre.assessment;

import com.swissre.assessment.rest.RestClient;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.swissre.assessment.utils.TestUtils.readData;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

class EuroPortfolioIT {

    private RestClient restClient = new RestClient();
    private static final String ENDPOINT = "https://min-api.cryptocompare.com/data/price";
    private static final String FROM_SYMBOL_KEY = "fsym";
    private static final String TO_SYMBOL_KEY = "tsyms";
    private static final String TO_SYMBOL_VALUE = "EUR";
    private static final int SYMBOL_POSITION = 0;
    private static final int AMOUNT_POSITION = 1;

    @Test
    void checkPortfolioIgnoringAmounts() {
        String file = "/payload/portfolio.txt";

        try {
            String portfolio = readData(file);
            for (String line : portfolio.split("\n")) {
                Map<String, String> parameters = new HashMap<>();
                String[] lineValues = line.split("=");
                parameters.put(FROM_SYMBOL_KEY, lineValues[SYMBOL_POSITION]);
                parameters.put(TO_SYMBOL_KEY, TO_SYMBOL_VALUE);

                try {
                    String response = restClient.sendRequest(ENDPOINT, parameters);
                    assertTrue(response.contains(TO_SYMBOL_VALUE));
                } catch (IOException e) {
                    fail();
                }
            }
        } catch (IOException e) {
            fail("Error loading file " + file);
        }
    }
}
