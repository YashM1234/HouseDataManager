package com.house;

import com.house.model.House;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HouseSeparatorApp {
    public static void main(String[] args) {
        File file = new File("src/main/resources/housing_price_dataset.csv");
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = reader.readLine();
            String header = line;
            List<House> houses = new ArrayList<>();

            while((line = reader.readLine()) != null){
                House house = buildHouse(line);
                houses.add(house);
            }

            //2bhk houses
            dataWriter(separateHouses(houses, 2), "src/main/resources/bhk/houses2bhk.csv", header);

            //3bhk houses
            dataWriter(separateHouses(houses, 3), "src/main/resources/bhk/houses3bhk.csv", header);

            //4bhk houses
            dataWriter(separateHouses(houses, 3), "src/main/resources/bhk/houses4bhk.csv", header);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    private static List<House> separateHouses(List<House> houses, int count) {
        return houses.stream()
                .filter(house -> house.getBedrooms() == count).toList();
    }

    private static void dataWriter(List<House> houses, String path, String header) {
        File file = new File(path);
        StringBuffer buffer = new StringBuffer();
        buffer.append(header);
        buffer.append("\n");
        for(House house : houses){
            String line = toCsv(house);
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

    private static String toCsv(House house) {
        return house.getSquareFeet()
                + "," + house.getBedrooms()
                + "," + house.getBathrooms()
                + "," + house.getNeighborhood()
                + "," + house.getYearBuilt()
                + "," + house.getPrice();
    }


    private static House buildHouse(String line) {
        String[] fields = line.split(",");
        return House.builder()
                .squareFeet(Integer.parseInt(fields[0]))
                .bedrooms(Integer.parseInt(fields[1]))
                .bathrooms(Integer.parseInt(fields[2]))
                .neighborhood(fields[3])
                .yearBuilt(Integer.parseInt(fields[4]))
                .price(Double.parseDouble(fields[5]))
                .build();
    }
}
