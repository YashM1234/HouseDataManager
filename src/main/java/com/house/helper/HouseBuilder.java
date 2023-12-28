package com.house.helper;

import com.house.model.House;

public class HouseBuilder {
    public static House buildHouse(String line) {
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
