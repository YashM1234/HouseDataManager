package com.house.service;

import com.house.helper.PriceCompare;

public class CompareOperationImpl implements CompareOperation {

    @Override
    public void max(String path1, String path2) {
        double house2bhkMax = PriceCompare.getMaxPrice(path1);
        double house3bhkMax = PriceCompare.getMaxPrice(path2);

        if(house2bhkMax > house3bhkMax){
            System.out.println("Maximum value is " + house2bhkMax + " which is from 2bhk.");
        }else{
            System.out.println("Maximum value is " + house3bhkMax  + " which is from 3bhk.");
        }
    }

}
