package com.house.service;

import com.house.model.BedRoomCount;
import com.house.model.House;
import com.house.model.NeighborhoodCount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BedroomNeighborhoodMetrics implements MetricsCollector {
    @Override
    public void collect(List<House> houses, String destination) {
        Map<Integer, NeighborhoodCount> countHouse = new HashMap<>();

        Map<Integer, List<House>> bedroomGroup =
                houses.stream().collect(Collectors.groupingBy(House::getBedrooms));

        bedroomGroup.forEach((bhk, records) -> {
            Map<String, List<House>> neighborhoodGroup = records.stream()
                    .collect(Collectors.groupingBy(House::getNeighborhood));

            NeighborhoodCount count = NeighborhoodCount.builder().total(records.size()).build();
            neighborhoodGroup.entrySet().forEach((entity) -> {
                setValues(entity, count);
            });
            countHouse.put(bhk, count);
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
