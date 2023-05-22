package com.codecool.marsexploration;

import com.codecool.marsexploration.data.*;
import com.codecool.marsexploration.data.Map;
import com.codecool.marsexploration.logic.ExplorationSimulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {

//        List<List<String>> realMap = new ArrayList<>();
//        Coordinate initialLanding = new Coordinate(100, 100);
//        Rover rover1 = new Rover();
//        String logFile = "testFileName";

//        Context context = new Context(1, 300, realMap, initialLanding, rover1, Outcome.COLONIZABLE, logFile);

        ExplorationSimulator simulator = new ExplorationSimulator();
        SimulationInput input = new SimulationInput(
                "src/main/resources/exploration-1.map",
                new Coordinate(12, 12),
                100,
                "src/main/resources/exploration-1.log");
        simulator.simulate(input);
    }
}
