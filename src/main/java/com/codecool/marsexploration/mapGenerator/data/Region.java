package com.codecool.marsexploration.mapGenerator.data;

import java.util.List;

public class Region {
    private List<List<String>> regionMap;

    public Region(List<List<String>> regionMap) {
        this.regionMap = regionMap;
    }

    public List<List<String>> getRegionMap() {
        return regionMap;
    }
    public Integer getRegionSize() {return regionMap.size();


    }
}
