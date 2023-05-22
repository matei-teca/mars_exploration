package com.codecool.marsexploration.data;

import com.codecool.marsexploration.logic.routine.Routine;

import java.util.ArrayList;
import java.util.List;

public class Rover {
    private String id;
    private Coordinate position;
    private int sight;
    private Routine routine;
    private List<Coordinate> coordinateTrackRecords;
    private List<List<String>> discoveredMap;

    public Rover(String id, Coordinate position, int sight, Routine routine, List<Coordinate> coordinateTrackRecords) {
        this.id = id;
        this.position = position;
        this.sight = sight;
        this.routine = routine;
        this.coordinateTrackRecords = coordinateTrackRecords;
        this.discoveredMap = new ArrayList<>();
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
}
