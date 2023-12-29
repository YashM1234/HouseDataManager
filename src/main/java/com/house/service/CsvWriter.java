package com.house.service;

import com.house.helper.HouseFilter;
import com.house.helper.CsvConverter;
import com.house.model.House;

import java.io.*;
import java.util.List;

public class CsvWriter implements WriteOperation {

    @Override
    public void write(List<House> houses, int count, String path, String header) {
        List<House> houseCategory = HouseFilter.separateHouses(houses, count);
        File file = new File(path);
        StringBuilder buffer = new StringBuilder();
        buffer.append(header);
        buffer.append("\n");
        for(House house : houseCategory){
            String line = CsvConverter.toCsv(house);
            buffer.append(line);
            buffer.append("\n");
        }
        try(FileWriter writer = new FileWriter(file)){
            writer.write(buffer.toString());
            writer.flush();
        }catch (IOException ex){
            throw new RuntimeException("File " + path + " could not found!");
        }
    }
}
