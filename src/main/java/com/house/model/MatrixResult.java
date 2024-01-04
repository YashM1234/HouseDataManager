package com.house.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class MatrixResult {
    private List<BedRoomCount> bedrooms;
}
