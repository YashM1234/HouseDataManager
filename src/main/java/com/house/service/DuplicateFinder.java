package com.house.service;

import com.house.helper.CsvConverter;
import com.house.model.House;

import java.util.List;

public class DuplicateFinder {

    public void findDuplicate(List<House> houses) {
        houses.forEach(house -> {
            long count = duplicateCount(house, houses);
            if(count > 1){
                System.out.println(count + " times duplicate: " + CsvConverter.toCsv(house));
            }
        });
    }

    private long duplicateCount(House house, List<House> houses) {
        return houses.stream().filter(h -> isDuplicate(house, h)).count();
    }

    private boolean isDuplicate(House compare, House compareTo) {
        if(compare.getSquareFeet() != compareTo.getSquareFeet()) {
            return false;
        }
        if(compare.getBedrooms() != compareTo.getBedrooms()){
            return false;
        }
        if(compare.getBathrooms() != compareTo.getBathrooms()) {
            return false;
        }
        return !compare.getNeighborhood().equals(compareTo.getNeighborhood());
    }
}
