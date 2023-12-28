package com.house.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.house.helper.HouseSeparator;
import com.house.helper.ToCsvConverter;
import com.house.model.House;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonWriter implements Operation{
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void read(String path) {

    }

    @Override
    public void write(List<House> houses, int count, String path, String header) {
        List<House> houseCategory = HouseSeparator.separateHouses(houses, count);
        File file = new File(path);

        try{
            String json = objectMapper.writeValueAsString(houseCategory);
            FileWriter writer = new FileWriter(file);
            writer.write(json);
            writer.flush();
            writer.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
