package com.swissre.assessment.io;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.swissre.assessment.io.FileUtils.readData;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class FileUtilsTest {

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
