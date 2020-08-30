package com.swissre.assessment.io;

import java.io.IOException;

import static com.swissre.assessment.io.FileUtils.readData;

public class FileReader {

    public String readFile(String file) {
//        String filePath = "/payload/portfolio.txt";
        try {
            return readData(file);
        } catch (IOException e) {
            throw new RuntimeException("Error opening file " + file);
        }
    }
}
