package com.house.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HeaderReader {
    public static String getHeader(String path) {
        File file = new File(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.readLine();
        } catch (IOException ex) {
            throw new RuntimeException("File not Exist!");
        }
    }
}
