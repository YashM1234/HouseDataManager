package com.house.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.house.model.House;

import java.util.List;

public interface WriteOperation {
    void write(List<House> houses, int count, String path, String header) throws JsonProcessingException;

}
