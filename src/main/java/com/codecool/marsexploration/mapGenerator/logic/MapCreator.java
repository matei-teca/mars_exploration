package com.codecool.marsexploration.mapGenerator.logic;


import com.codecool.marsexploration.mapGenerator.data.ConfigurationObject;
import com.codecool.marsexploration.mapGenerator.data.Region;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapCreator {

    private ConfigurationObject configObj;

    private String filePath;

    public MapCreator(ConfigurationObject configObj){
        this.configObj = configObj;
    }

    public void drawMap() {
        List<Region> mountains = configObj.getMountainsRegions();
        List<Region> pits = configObj.getPitsRegions();

        int mapWidth = configObj.getMapWidth();

        List<List<String>> map2D = new ArrayList<>();
        for (int i = 0; i < mapWidth; i++){
            ArrayList<String> newrow = new ArrayList<>();
            for(int j = 0; j < mapWidth; j++){
                newrow.add(" ");
            }
            map2D.add(newrow);
        }
        drawRegions(mountains, map2D);
        drawRegions(pits, map2D);

        fileWriter(configObj.getFileName(), convertMapToString(map2D));


    }

    private void fileWriter(String fileName,String content){
        LocalDateTime now = LocalDateTime.now();
        filePath = "src/main/resources/" + fileName + "-" +
                now.toString().replaceAll(":", "-").replaceAll("\\.","-")
                ;
        try {
            Files.writeString(Paths.get(filePath+ ".map"), content, StandardCharsets.UTF_8);
            System.out.println("File saved successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file.");
            e.printStackTrace();
        }
    }

    private void drawRegions(List<Region> regions,  List<List<String>> map2D){

        int mapWidth = configObj.getMapWidth();

        for(Region region : regions) {
            List<List<String>> mountainArray = region.getRegionMap();
            System.out.println(mountainArray);
            boolean search = true;
            while (search) {

                int randomI = new Random().nextInt(mapWidth - region.getRegionSize());
                int randomJ = new Random().nextInt(mapWidth - region.getRegionSize());

                boolean checkIfAreaAvailable = true;

                for (int i = randomI; i < randomI + region.getRegionSize() ; i++) {
                    for (int j = randomJ; j < randomJ + region.getRegionSize(); j++) {

                        if (!map2D.get(i).get(j).equals(" ")) {
                            System.out.println("Not here!");
                            checkIfAreaAvailable = false;
                        }
                    }
                }

                if (checkIfAreaAvailable) {
                    System.out.println(randomI+" "+randomJ);
                    for (int i = randomI; i < (randomI+region.getRegionSize()); i++) {

                        for (int j = randomJ; j < (randomJ+region.getRegionSize()); j++) {
//                            System.out.println("*"+i);
                            map2D.get(i).set(j,mountainArray.get(i-randomI).get(j-randomJ));
                        }

                    }
                    for(List<String> line :map2D){
                        System.out.println(line);
                    } //print map after modification
                    search = false;
                }

            }

        }

    }

    private String convertMapToString (List<List<String>> map2D){

        String s = "";

        for(int i = 0 ; i < map2D.size(); i++){
            for(int j = 0; j < map2D.size(); j++){
                s+= map2D.get(i).get(j);
            }
            s+= "\n";
        }

        return s;
    }

    public String getFilePath(){
        return filePath;
    }

}
