package com.house.service;

import com.house.helper.HouseSeparator;
import com.house.helper.ToCsvConverter;
import com.house.model.House;

import java.io.*;
import java.util.List;

public class CsvWriter implements Operation{
    @Override
    public void read(String path) {

    }

    @Override
    public void write(List<House> houses, int count, String path, String header) {
        List<House> houseCategory = HouseSeparator.separateHouses(houses, count);
        File file = new File(path);
        StringBuffer buffer = new StringBuffer();
        buffer.append(header);
        buffer.append("\n");
        for(House house : houseCategory){
            String line = ToCsvConverter.toCsv(house);
            buffer.append(line);
            buffer.append("\n");
        }
        try{
            FileWriter writer = new FileWriter(file);
            writer.write(buffer.toString());
            writer.flush();
            writer.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
