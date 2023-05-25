package com.codecool.marsexploration.mapGenerator.data;

import com.codecool.marsexploration.mapGenerator.logic.CreateRegions;

import java.util.List;
import java.util.Map;


public class ConfigurationObject {
    private String fileName;
    private int mapWidth;
    private Map<Element, Integer> elements;
    private List<Region> mountainsRegions;
    private List<Region> pitsRegions;
    private String fullMap;

    public ConfigurationObject(String fileName, int mapWidth, Map<Element, Integer> elements) {
        this.mapWidth = mapWidth;
        validate();
        this.fileName = fileName;
        this.elements = elements;
        this.mountainsRegions = new CreateRegions().generateRegions(elements,new int [] {7,25}, Element.MOUNTAIN, Element.MINERAL);
        this.pitsRegions = new CreateRegions().generateRegions(elements,new int [] {4,12},Element.PIT,Element.WATER);
    }

    public List<Region> getMountainsRegions(){
        return this.mountainsRegions;
    }
    public List<Region> getPitsRegions(){
        return this.pitsRegions;
    }
    public int getMapWidth() {
        return mapWidth;
    }
    public String getFileName(){return fileName;}


    public boolean validate() {
        if (mapWidth < 10 || mapWidth > 100) {
            throw new IllegalArgumentException("The map width must be between 10 and 100");
        }
        return true;
    }



}
