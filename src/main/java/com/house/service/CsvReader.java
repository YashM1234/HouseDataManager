package com.house.service;

import com.house.helper.HouseBuilder;
import com.house.inmemory.InMemoryStorage;
import com.house.model.House;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader implements ReadOperation {
    @Override
    public void read(String path) {
        File file = new File(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                House house = HouseBuilder.buildHouse(line);
                InMemoryStorage.houses.add(house);
            }
        } catch (IOException ex) {
            throw new RuntimeException("File not found!");
        }
    }
}