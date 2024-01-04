package com.house.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;
@Data
@Builder
public class BedRoomCount {
    private Map<Integer, NeighborhoodCount> bedrooms;
}
