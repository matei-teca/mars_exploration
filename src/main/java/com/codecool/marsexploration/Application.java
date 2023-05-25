package com.codecool.marsexploration;

import com.codecool.marsexploration.data.*;
import com.codecool.marsexploration.logic.ExplorationSimulator;
import com.codecool.marsexploration.mapGenerator.data.ConfigurationObject;
import com.codecool.marsexploration.mapGenerator.logic.ElementsManager;
import com.codecool.marsexploration.mapGenerator.logic.MapCreator;
import com.codecool.marsexploration.mapGenerator.ui.InputScanner;
import com.codecool.marsexploration.util.FileReader;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Random random = new Random();
        LocalDateTime now = LocalDateTime.now();
        ElementsManager elementsManager = new ElementsManager();
        InputScanner inputScanner = new InputScanner();
        int width = inputScanner.getNumericInput("Type width: ");

        ConfigurationObject newMap =
                new ConfigurationObject("exploration", width, elementsManager.createMapElements(width));

        MapCreator mapCreator = new MapCreator(newMap);
        mapCreator.drawMap();
        String filePath = mapCreator.getFilePath() + ".log";


        ExplorationSimulator simulator = new ExplorationSimulator();
        SimulationInput input = new SimulationInput(
                mapCreator.getFilePath(),
                new Coordinate(random.nextInt(2,21), random.nextInt(2, 21)), 400, filePath);
        simulator.simulate(input);

    }
}
