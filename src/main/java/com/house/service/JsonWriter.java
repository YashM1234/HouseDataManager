package com.house.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.house.helper.HouseFilter;
import com.house.model.BedRoomCount;
import com.house.model.House;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonWriter implements WriteOperation {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void write(List<House> houses, int count, String path, String header) {
        List<House> houseCategory = HouseFilter.separateHouses(houses, count);
        File file = new File(path);
        String json = null;
        try {
            json = objectMapper.writeValueAsString(houseCategory);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException("Json not processed!");
        }

        try(FileWriter writer = new FileWriter(file);){
            writer.write(json);
            writer.flush();
        }catch (IOException ex){
            throw new RuntimeException("File " + path + " could not found!");
        }
    }

    public static void write(BedRoomCount matrixResult, String path ){
        ObjectMapper objectMapper1 = new ObjectMapper();
        File file = new File(path);
        String json = null;
        try {
            json = objectMapper1.writeValueAsString(matrixResult);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException("Json not processed!");
        }

        try(FileWriter writer = new FileWriter(file);){
            writer.write(json);
            writer.flush();
        }catch (IOException ex){
            throw new RuntimeException("File " + path + " could not found!");
        }
    }
}
