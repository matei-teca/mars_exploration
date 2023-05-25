package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.logic.ExplorationSimulator;

import java.time.LocalDateTime;
import java.util.List;

public class TestingData {
    private LocalDateTime now = LocalDateTime.now();
    private String filePath = "src/main/resources/exploration" + "-" +
            now.toString().replaceAll(":", "-").replaceAll("\\.","-")
            + ".log";

    private SimulationInput input = new SimulationInput(
            "src/main/resources/exploration-2",
            new Coordinate(1, 1), 235, filePath);

    private ExplorationSimulator explorationSimulator = new ExplorationSimulator();
    private List<List<String>> realMap = explorationSimulator.convertMap(input.mapPath());
    private Rover rover1 = new Rover("rover-1", new Coordinate(input.landing().y(), input.landing().x()), 2);

    public SimulationInput getInput() {
        return input;
    }

    public List<List<String>> getRealMap() {
        return realMap;
    }

    public Rover getRover1() {
        return rover1;
    }
}