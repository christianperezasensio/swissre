package com.swissre.assessment;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.swissre.assessment.utils.TestUtils.readData;

class EuroPortfolioTest {

    @Test
    void readFile() {
        String file = "/payload/portfolio.txt";
        try {
            String payload = readData(file);
            Assert.assertTrue(payload.contains("BTC=10"));
        } catch (IOException e) {
            Assert.fail("Error loading file " + file);
        }
    }
}
