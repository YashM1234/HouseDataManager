package com.house.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class NeighborhoodCount {
    private long total;
    private int rural;
    private int suburb;
    private int urban;
}
