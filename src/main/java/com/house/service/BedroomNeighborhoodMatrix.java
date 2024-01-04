package com.house.service;

import com.house.model.BedRoomCount;
import com.house.model.House;
import com.house.model.NeighborhoodCount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BedroomNeighborhoodMatrix implements MatrixCollector{
    @Override
    public void collect(List<House> houses, String destination) {
        Map<Integer, List<House>> bedrooms =
                houses.stream().collect(Collectors.groupingBy(House::getBedrooms));

        Map<Integer, NeighborhoodCount> countHouse = new HashMap<>();
        bedrooms.forEach((bhk, records) -> {
            Map<String, List<House>> bhkNeighborhood = records.stream()
                    .collect(Collectors.groupingBy(House::getNeighborhood));
            System.out.println(bhk + "BHK: " + records.size());
            NeighborhoodCount neighborhoodCount = NeighborhoodCount.builder().total(records.size()).build();
            bhkNeighborhood.entrySet().forEach((entity) -> {
                setValues(entity, neighborhoodCount);
            });
            countHouse.put(bhk, neighborhoodCount);
        });
        BedRoomCount count = BedRoomCount.builder().bedrooms(countHouse).build();
        JsonWriter.write(count, destination);
    }

    private static void setValues(Map.Entry<String, List<House>> entry, NeighborhoodCount neighbourhoodCount) {
        if("Rural".equals(entry.getKey())){
            neighbourhoodCount.setRural(entry.getValue().size());
        } else if("Suburb".equals(entry.getKey())){
            neighbourhoodCount.setSuburb(entry.getValue().size());
        } else if("Urban".equals(entry.getKey())){
            neighbourhoodCount.setUrban(entry.getValue().size());
        }
    }
}
