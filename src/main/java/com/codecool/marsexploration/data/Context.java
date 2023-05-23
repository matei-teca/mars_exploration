package com.codecool.marsexploration.data;

import java.util.List;

public class Context {

    private int stepNumber;
    private long timeout;
    private List<List<String>> realMap;
    private Coordinate landingCoordinate;
    private Rover rover;
    private Outcome outcome;
    private String logFile;

    public Context(long timeout, List<List<String>> realMap, Coordinate landingCoordinate, Rover rover, String logFile) {
        this.stepNumber = 0;
        this.timeout = timeout;
        this.realMap = realMap;
        this.landingCoordinate = landingCoordinate;
        this.rover = rover;
        this.outcome = null;
        this.logFile = logFile;
    }

    public Rover getRover() {
        return rover;
    }

    public int getStepNumber() {
        return stepNumber;
    }
}
