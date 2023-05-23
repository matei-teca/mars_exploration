package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;

import java.util.List;

public class Scan implements Phase {

    @Override
    public void perform(Context context) {
        Rover rover = context.getRover();

        List<List<String>> roverMap = rover.getDiscoveredMap();
        List<List<String>> realMap = context.getRealMap();

        int SIGHT = rover.getSight();
        int roverY = rover.getPosition().y();
        int roverX = rover.getPosition().x();

        for(int i = roverY - SIGHT; i <= roverY + SIGHT; i++){
            for(int j = roverX - SIGHT; j <= roverX + SIGHT; j++){
                if(realMap.get(i).get(j).equals("*") && !roverMap.get(i).get(j).equals("*")){
                    rover.getCoordinateTrackRecords().get("minerals").add(new Coordinate(i, j));
                }
                if(realMap.get(i).get(j).equals("~") && !roverMap.get(i).get(j).equals("~")){
                    rover.getCoordinateTrackRecords().get("water").add(new Coordinate(i, j));
                }
                if(!roverMap.get(i).get(j).equals("@")){
                    roverMap.get(i).set(j, realMap.get(i).get(j));
                }
            }
        }
    }
}
