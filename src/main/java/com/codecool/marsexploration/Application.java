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
        Random random = new Random();
        LocalDateTime now = LocalDateTime.now();
        String filePath = "src/main/resources/exploration" + "-" +
            now.toString().replaceAll(":", "-").replaceAll("\\.","-")
            + ".log";

        ExplorationSimulator simulator = new ExplorationSimulator();
        SimulationInput input = new SimulationInput(
                "src/main/resources/exploration-1.map",
                new Coordinate(random.nextInt(2,21), random.nextInt(2, 21)), 400, filePath);
        simulator.simulate(input);

    }
}
