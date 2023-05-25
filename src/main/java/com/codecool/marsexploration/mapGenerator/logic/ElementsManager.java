package com.codecool.marsexploration.mapGenerator.logic;



import com.codecool.marsexploration.mapGenerator.data.Element;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ElementsManager {

    private final int MAX_ELEMENTS_FOR_MOUNTAINS = 13;
    private final int MIN_ELEMENTS_FOR_MOUNTAINS = 9;
    private final int MAX_ELEMENTS_FOR_PITS = 7;
    private final int MIN_ELEMENTS_FOR_PITS = 4;
    private final double MAX_ELEMENTS_FOR_MINERALS = 1.5;
    private final double MIN_ELEMENTS_FOR_MINERALS = 0.8;
    private final double MAX_ELEMENTS_FOR_WATER = 1.5;
    private final double MIN_ELEMENTS_FOR_WATER = 0.5;

    public Map<Element, Integer> createMapElements(int mapWidth){
        Random random = new Random();
        double proportionMap = (Math.pow(mapWidth, 2) / 100);
//        lowerBound + random.nextDouble() * (upperBound - lowerBound)
        int mountainElements =(int) ((MIN_ELEMENTS_FOR_MOUNTAINS +
                random.nextDouble() * (MAX_ELEMENTS_FOR_MOUNTAINS - MIN_ELEMENTS_FOR_MOUNTAINS))
                * proportionMap);
        int pitsElements = (int) ((MIN_ELEMENTS_FOR_PITS +
                random.nextDouble() * (MAX_ELEMENTS_FOR_PITS - MIN_ELEMENTS_FOR_PITS))
                * proportionMap);
        int mineralsElements = (int) ((MIN_ELEMENTS_FOR_MINERALS +
                random.nextDouble() * (MAX_ELEMENTS_FOR_MINERALS - MIN_ELEMENTS_FOR_MINERALS))
                * proportionMap);
        int waterElements = (int) ((MIN_ELEMENTS_FOR_WATER +
                random.nextDouble() * (MAX_ELEMENTS_FOR_WATER - MIN_ELEMENTS_FOR_WATER))
                * proportionMap);

        Map<Element, Integer> elementsForMap = new HashMap<>();

        elementsForMap.put(Element.MOUNTAIN, mountainElements);
        elementsForMap.put(Element.PIT, pitsElements);
        elementsForMap.put(Element.MINERAL, mineralsElements);
        elementsForMap.put(Element.WATER, waterElements);
        System.out.println(mountainElements);
        System.out.println(pitsElements);
        System.out.println(mineralsElements);
        System.out.println(waterElements);

//        ArrayList<String> strings = new ArrayList<>();

        return elementsForMap;
    }
}
