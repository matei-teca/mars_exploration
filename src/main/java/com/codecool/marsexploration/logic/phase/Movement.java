package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;

import java.util.ArrayList;
import java.util.List;

public class Movement implements Phase {

    @Override
    public void perform(Context context) {
        Rover rover = context.getRover();

        int roverY = rover.getPosition().y();
        int roverX = rover.getPosition().x();

        for(int i = roverY-1;i<= roverY+1;i++){
            for(int j = roverX-1;j<= roverX+1;j++){
                if(rover.getDiscoveredMap().get(i).get(j).equals(" ")){

                    rover.setPosition(new Coordinate( i,j ));
                    rover.getCoordinateTrackRecords().get("roverPositions").add(new Coordinate(i, j));
                    rover.getDiscoveredMap().get(i).set(j, "@");
                    return;
                }
            }
        }
        for(int i = roverY+1;i >= roverY-1; i--){
            for(int j = roverX+1; j>= roverX-1; j--){
                if(rover.getDiscoveredMap().get(i).get(j).equals("@")){

                    rover.getCoordinateTrackRecords().get("roverPositions").add(new Coordinate(i, j));
                    rover.setPosition(new Coordinate( i, j));
                    return;
                }
            }
        }
    }
}
