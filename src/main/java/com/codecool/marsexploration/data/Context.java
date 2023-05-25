package com.codecool.marsexploration.data;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Context {

    private int stepNumber;
    private long timeout;
    private List<List<String>> realMap;
    private Coordinate landingCoordinate;
    private Rover rover;
    private Outcome outcome;
    private String logFile;
    private Queue<Coordinate> exploringPath;

    public Context(long timeout, List<List<String>> realMap, Coordinate landingCoordinate, Rover rover, String logFile) {
        this.stepNumber = 0;
        this.timeout = timeout;
        this.realMap = realMap;
        this.landingCoordinate = landingCoordinate;
        this.rover = rover;
        this.outcome = null;
        this.logFile = logFile;
        this.exploringPath = new LinkedList<>();
        rover.initializeDiscoveredMap(realMap.size());
    }

    public Rover getRover() {
        return rover;
    }

    public List<List<String>> getRealMap() {return realMap;}

    public void setOutcome(Outcome outcome) { this.outcome = outcome;}


    public int getStepNumber() {
        return stepNumber;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public String getLogFile() {
        return this.logFile;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public Coordinate getLandingCoordinate() {
        return landingCoordinate;
    }

    public long getTimeout() {
        return timeout;
    }

    public Queue<Coordinate> getExploringPath() {
        return exploringPath;
    }

    public void addToExploringPath(Coordinate position){
        exploringPath.add(position);
    }
}
