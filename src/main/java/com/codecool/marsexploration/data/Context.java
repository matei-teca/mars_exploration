package com.codecool.marsexploration.data;

import java.util.List;

public class Context {

    private int stepNumber;
    private int timeout;
    private List<List<String>> realMap;
    private Coordinate landingCoordinate;
    private Rover rover;
    private Outcome outcome;
    private String logFile;

    public Context(int stepNumber, int timeout, List<List<String>> realMap, Coordinate landingCoordinate, Rover rover, Outcome outcome, String logFile) {
        this.stepNumber = stepNumber;
        this.timeout = timeout;
        this.realMap = realMap;
        this.landingCoordinate = landingCoordinate;
        this.rover = rover;
        this.outcome = outcome;
        this.logFile = logFile;
    }

    public Rover getRover() {
        return rover;
    }

    public int getStepNumber() {
        return stepNumber;
    }
}
