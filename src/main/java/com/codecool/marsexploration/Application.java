package com.codecool.marsexploration;

import com.codecool.marsexploration.data.*;
import com.codecool.marsexploration.logic.ExplorationSimulator;
import com.codecool.marsexploration.util.FileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {



        ExplorationSimulator simulator = new ExplorationSimulator();
        SimulationInput input = new SimulationInput(
                "src/main/resources/exploration-1.map",
                new Coordinate(12, 12),
                100,
                "src/main/resources/exploration-1.log");
        simulator.simulate(input);

    }
}
