package com.codecool.marsexploration.data;

import com.codecool.marsexploration.logic.routine.Routine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rover {
    private String id;
    private Coordinate position;
    private int sight;
    private Routine routine;
    private Map<String, List<Coordinate>> coordinateTrackRecords;
    private List<List<String>> discoveredMap;

    public Rover(String id, Coordinate position, int sight, Routine routine, List<Coordinate> coordinateTrackRecords) {
        this.id = id;
        this.position = position;
        this.sight = sight;
        this.routine = routine;
        this.coordinateTrackRecords = coordinateTrackRecords;
        this.discoveredMap = new ArrayList<>();
    }

    public void initializeDiscoveredMap(int width){
        this.discoveredMap = new ArrayList<>();
        for(int i = 0; i < width; i++){
            this.discoveredMap.add(new ArrayList<>());
            for(int j = 0; j < width; j++){
                this.discoveredMap.get(i).add("?");
            }
        }
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public List<List<String>> getDiscoveredMap() {
        return discoveredMap;
    }

    public int getSight() {return sight;}

    public Map<String, List<Coordinate>> getCoordinateTrackRecords() {return coordinateTrackRecords;}
}
