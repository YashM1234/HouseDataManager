package com.house.helper;

import com.house.model.House;

import java.util.List;

public class HouseFilter {
    public static List<House> separateHouses(List<House> houses, int count) {
        return houses.stream()
                .filter(house -> house.getBedrooms() == count).toList();
    }
}
