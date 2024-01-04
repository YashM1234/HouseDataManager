package com.house.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RowCounter {
    public static int getRowCount(String path){
        File file = new File(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line=  reader.readLine();
            String[] lines = line.split(",");
            int count = lines.length;
            return count;
        } catch (IOException ex) {
            throw new RuntimeException("File not Exist!");
        }
    }
}
