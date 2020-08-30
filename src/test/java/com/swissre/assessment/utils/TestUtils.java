package com.swissre.assessment.utils;

import org.junit.jupiter.api.Assertions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public final class TestUtils {

    public static String readData(String jsonFile) throws IOException {
        final InputStream inputstream = TestUtils.class.getResourceAsStream(jsonFile);
        Assertions.assertNotNull(inputstream, () -> "failed to read file " + jsonFile);
        try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputstream, StandardCharsets.UTF_8))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        }
    }
}
