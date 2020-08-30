package com.swissre.assessment.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public final class TestUtils {

    public static String readData(String jsonFile) throws IOException {
        final InputStream inputstream = TestUtils.class.getResourceAsStream(jsonFile);
        assertNotNull(inputstream, () -> "failed to read file " + jsonFile);
        try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputstream, UTF_8))) {
            return bufferedReader.lines().collect(joining("\n"));
        }
    }
}
