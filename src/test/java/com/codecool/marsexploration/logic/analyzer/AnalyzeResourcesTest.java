package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.logic.phase.Movement;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AnalyzeResourcesTest {

        TestingData testingData = new TestingData();
        AnalyzeResources analyzeResources = new AnalyzeResources();

        SimulationInput input = testingData.getInput();
        Movement movement = new Movement();
    @Test
    void analyzeValid1() {
        List<List<String>> discoveredMap1 = new ArrayList<>();
        discoveredMap1.add(new ArrayList<>(List.of("@", "@", "^", "^", "^")));
        discoveredMap1.add(new ArrayList<>(List.of(" ", "@", "^", "^", "^")));
        discoveredMap1.add(new ArrayList<>(List.of(" ", "@", "*", "^", "^")));
        discoveredMap1.add(new ArrayList<>(List.of(" ", "@", " ", "^", "^")));
        discoveredMap1.add(new ArrayList<>(List.of(" ", " ", " ", "^", "^")));

        Context context1 = new Context(input.timeout(), testingData.getRealMap(), input.landing(), testingData.getRover1(), input.logPath());
        context1.getRover().setDiscoveredMap(discoveredMap1);
        testingData.getRover1().setPosition(new Coordinate(1,1));
        movement.perform(context1);

        assertEquals(Outcome.NOT_COLONIZABLE_RESOURCES, analyzeResources.analyze(context1).get());
    }

    @Test
    void analyzeValid2() {
        List<List<String>> discoveredMap1 = new ArrayList<>();
        discoveredMap1.add(new ArrayList<>(List.of("@", "@", "^", "^", "?")));
        discoveredMap1.add(new ArrayList<>(List.of(" ", "@", "^", "^", "^")));
        discoveredMap1.add(new ArrayList<>(List.of(" ", " ", "*", "^", "^")));
        discoveredMap1.add(new ArrayList<>(List.of(" ", " ", " ", "^", "^")));
        discoveredMap1.add(new ArrayList<>(List.of(" ", " ", " ", "^", "^")));

        Context context1 = new Context(input.timeout(), testingData.getRealMap(), input.landing(), testingData.getRover1(), input.logPath());
        context1.getRover().setDiscoveredMap(discoveredMap1);
        testingData.getRover1().setPosition(new Coordinate(1,1));
        movement.perform(context1);
        assertEquals(Outcome.NOT_COLONIZABLE_RESOURCES, analyzeResources.analyze(context1).get());
    }
    @Test
    void analyzeInvalid() {
        List<List<String>> discoveredMap1 = new ArrayList<>();
        discoveredMap1.add(new ArrayList<>(List.of("@", "@", "^", "^", "?")));
        discoveredMap1.add(new ArrayList<>(List.of(" ", "@", "^", "^", "^")));
        discoveredMap1.add(new ArrayList<>(List.of(" ", " ", "*", "^", "^")));
        discoveredMap1.add(new ArrayList<>(List.of(" ", " ", " ", "^", "^")));
        discoveredMap1.add(new ArrayList<>(List.of(" ", "?", " ", "^", "^")));

        Context context1 = new Context(input.timeout(), testingData.getRealMap(), input.landing(), testingData.getRover1(), input.logPath());
        context1.getRover().setDiscoveredMap(discoveredMap1);
        testingData.getRover1().setPosition(new Coordinate(1,1));
        movement.perform(context1);
        assertEquals(Optional.empty(), analyzeResources.analyze(context1));
    }
}