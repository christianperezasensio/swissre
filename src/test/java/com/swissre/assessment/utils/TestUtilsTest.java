package com.swissre.assessment.utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.swissre.assessment.utils.TestUtils.readData;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

final class TestUtilsTest {

    @Test
    void readFile() {
        String file = "/payload/portfolio.txt";
        try {
            assertTrue(readData(file).contains("BTC=10"));
        } catch (IOException e) {
            fail("Error loading file " + file);
        }
    }
}
