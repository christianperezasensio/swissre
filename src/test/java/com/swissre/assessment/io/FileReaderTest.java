package com.swissre.assessment.io;

import org.junit.jupiter.api.Test;

import static com.swissre.assessment.io.FileUtils.readData;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileReaderTest {

    @Test
    void readFileThrowsException() {
        assertThrows(RuntimeException.class, () -> readData("/payload/non-existing-file.txt"));
    }
}
