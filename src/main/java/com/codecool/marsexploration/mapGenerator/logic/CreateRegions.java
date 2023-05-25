package com.codecool.marsexploration.mapGenerator.logic;


import com.codecool.marsexploration.mapGenerator.data.Element;
import com.codecool.marsexploration.mapGenerator.data.Region;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CreateRegions {

    private double CHANCES_FOR_RESOURCE = 0.25;

    public List<Region> generateRegions(Map<Element, Integer> elements, int[] randomInterval, Element regionType, Element resourceType ){

        List<Integer> regionsSize = generateSizes(elements.get(regionType), randomInterval);

        List<Region> regions = new ArrayList<>();
        for(Integer size : regionsSize){
            regions.add(generateRegion(size, regionType.getSymbol(),elements,resourceType));
        }



        return regions;
    }

    private List<Integer> generateSizes(int totalElements, int[] randomInterval){

        List<Integer> regions = new ArrayList<>();
        boolean isFinished = false;
        while(!isFinished){
            if(totalElements < randomInterval[1]){
                regions.add(totalElements);
                isFinished = true;
            } else {
                int region = new Random().nextInt(randomInterval[1] - randomInterval[0] + 1) + randomInterval[0];
                regions.add(region);
                totalElements -= region;
            }

        }

        return regions;
    }

    private Region generateRegion(int size, String symbol, Map<Element, Integer> elements, Element resourceType){

        int regionDimension = (int) (Math.round(Math.sqrt(size)) + 1);
        ArrayList<String> symbols = new ArrayList<>((int)Math.pow(regionDimension,2));

        for(int i=0;i< (int)Math.pow(regionDimension,2);i++){
            if(i<size){
                symbols.add(i,symbol);
            }else{
                if(elements.get(resourceType) > 0 && Math.random() < CHANCES_FOR_RESOURCE){
                    symbols.add(i,resourceType.getSymbol());
                    elements.put(resourceType, elements.get(resourceType) - 1);
                }else
                    symbols.add(i," ");

            }
        }

        for(int i = size; i < symbols.size(); i++){
            int randIndex = new Random().nextInt(symbols.size());
            String c = symbols.get(i);
            symbols.set(i,symbols.get(randIndex));
            symbols.set(randIndex,c);
        }

        Region region = new Region(new ArrayList<>());
        for(int i = 0; i <= symbols.size() - regionDimension; i += regionDimension){

            region.getRegionMap().add(symbols.subList(i, i+regionDimension));
        }

        return region;
    }

}
