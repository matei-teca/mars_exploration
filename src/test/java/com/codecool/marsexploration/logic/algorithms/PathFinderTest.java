package com.codecool.marsexploration.logic.algorithms;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.logic.analyzer.TestingData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PathFinderTest {
    TestingData testingData = new TestingData();

    @Test
    void findPathToSymbol() {
        List<List<String>> discoveredMap1 = new ArrayList<>();
        discoveredMap1.add(new ArrayList<>(List.of("@", "@", "^", "^", "^")));
        discoveredMap1.add(new ArrayList<>(List.of(" ", "@", "^", "^", "^")));
        discoveredMap1.add(new ArrayList<>(List.of(" ", " ", "*", "^", "^")));
        discoveredMap1.add(new ArrayList<>(List.of(" ", " ", " ", "^", "^")));
        discoveredMap1.add(new ArrayList<>(List.of(" ", "?", " ", "^", "^")));

        testingData.getRover1().setDiscoveredMap(discoveredMap1);
        testingData.getRover1().setPosition(new Coordinate(1,1));
        List<Coordinate> actualRoute =  PathFinder.findPathToSymbol(testingData.getRover1(), Symbol.UNKNOWN.getSymbol());
        List<Coordinate> expectedRoute= new ArrayList<>(List.of(new Coordinate(2,1),new Coordinate(3,1),new Coordinate(4,1)));
        assertEquals(expectedRoute,actualRoute);

    }
}