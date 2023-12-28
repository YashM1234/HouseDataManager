package com.house.service;

import com.house.model.House;

import java.util.List;

public interface Operation {

    void read(String path);

    void write(List<House> houses,int count, String path, String header);
}
