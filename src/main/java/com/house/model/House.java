package com.house.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class House {
    private int squareFeet;
    private int bedrooms;
    private int bathrooms;
    private String neighborhood;
    private int yearBuilt;
    private double price;
}
