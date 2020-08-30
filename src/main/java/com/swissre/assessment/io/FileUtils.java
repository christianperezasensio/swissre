package com.swissre.assessment.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.stream.Collectors.joining;

public final class FileUtils {

    public static String readData(String jsonFile) throws IOException {
        final InputStream inputstream = FileUtils.class.getResourceAsStream(jsonFile);
        try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputstream, UTF_8))) {
            return bufferedReader.lines().collect(joining("\n"));
        }
    }
}
