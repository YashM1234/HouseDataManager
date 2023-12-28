package com.house.helper;

import com.house.model.House;

public class ToCsvConverter {
    public static String toCsv(House house) {
        return house.getSquareFeet()
                + "," + house.getBedrooms()
                + "," + house.getBathrooms()
                + "," + house.getNeighborhood()
                + "," + house.getYearBuilt()
                + "," + house.getPrice();
    }
}
