package com.house.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PriceCompare  {
    public static double getMaxPrice(String path) {
        File file = new File(path);
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            double max = Double.MIN_VALUE;
            while((line = reader.readLine() )!= null){
                String[] fields = line.split(",");
                if(max < Double.parseDouble(fields[5])){
                    max = Double.parseDouble(fields[5]);
                }
            }
            return max;
        }catch(IOException ex){
            ex.printStackTrace();
            return 0;
        }
    }
}
