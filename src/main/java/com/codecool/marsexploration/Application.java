package com.codecool.marsexploration;

import com.codecool.marsexploration.data.*;
import com.codecool.marsexploration.logic.ExplorationSimulator;
import com.codecool.marsexploration.util.FileReader;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        String filePath = "src/main/resources/exploration" + "-" +
            now.toString().replaceAll(":", "-").replaceAll("\\.","-")
            + ".log";

        ExplorationSimulator simulator = new ExplorationSimulator();
        SimulationInput input = new SimulationInput(
                "src/main/resources/exploration-2.map",
                new Coordinate(29, 26), 235, filePath);
        simulator.simulate(input);

    }
}
