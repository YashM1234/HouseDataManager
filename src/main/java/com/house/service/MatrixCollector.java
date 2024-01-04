package com.house.service;

import com.house.model.House;

import java.util.List;

public interface MatrixCollector {
    void collect(List<House> houses, String destination);
}
