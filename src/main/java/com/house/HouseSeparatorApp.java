package com.house;

import com.house.helper.HeaderReader;
import com.house.inmemory.InMemoryStorage;
import com.house.service.CsvReader;
import com.house.service.CsvWriter;
import com.house.service.JsonWriter;
import com.house.service.Operation;

public class HouseSeparatorApp {
    public static void main(String[] args) {

        Operation csvReader = new CsvReader();
        csvReader.read("src/main/resources/housing_price_dataset.csv");

        Operation csvWriter = new CsvWriter();
        //2bhk houses
        csvWriter.write(InMemoryStorage.houses, 2 ,"src/main/resources/bhk/houses2bhk.csv", HeaderReader.getHeader("src/main/resources/housing_price_dataset.csv"));

        //3bhk houses
        csvWriter.write(InMemoryStorage.houses, 3, "src/main/resources/bhk/houses3bhk.csv", HeaderReader.getHeader("src/main/resources/housing_price_dataset.csv"));

        //4bhk houses
        csvWriter.write(InMemoryStorage.houses, 4, "src/main/resources/bhk/houses4bhk.csv", HeaderReader.getHeader("src/main/resources/housing_price_dataset.csv"));

        //5bhk houses
        csvWriter.write(InMemoryStorage.houses, 5, "src/main/resources/bhk/houses5bhk.csv", HeaderReader.getHeader("src/main/resources/housing_price_dataset.csv"));

        Operation jsonWriter = new JsonWriter();
        //2bhk houses
        jsonWriter.write(InMemoryStorage.houses, 2 ,"src/main/resources/bhk/houses2bhk.json", null);

        //3bhk houses
        jsonWriter.write(InMemoryStorage.houses, 3, "src/main/resources/bhk/houses3bhk.json", null);

        //4bhk houses
        jsonWriter.write(InMemoryStorage.houses, 4, "src/main/resources/bhk/houses4bhk.json", null);

        //5bhk houses
        jsonWriter.write(InMemoryStorage.houses, 5, "src/main/resources/bhk/houses5bhk.json", null);

    }
}
