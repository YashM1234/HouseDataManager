package com.house.helper;

import com.house.model.House;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HeaderReader {
    public static String getHeader(String path){
        File file = new File(path);
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = reader.readLine();
            return line;
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
