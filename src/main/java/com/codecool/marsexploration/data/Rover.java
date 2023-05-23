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

    public Rover(String id, Coordinate position, int sight) {
        this.id = id;
        this.position = position;
        this.sight = sight;
        this.coordinateTrackRecords = new HashMap<>();
        coordinateTrackRecords.put("roverPositions", List.of(new Coordinate(position.y(), position.x())));
        coordinateTrackRecords.put("minerals", new ArrayList<>());
        coordinateTrackRecords.put("water", new ArrayList<>());
        coordinateTrackRecords.put("aliens", new ArrayList<>());
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

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }
    public Routine getRoutine(){return this.routine;}

    public String getId() {
        return id;
    }
}
