package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;

public class Movement implements Phase {

    @Override
    public void perform(Context context) {
        Rover rover = context.getRover();
        int roverX = rover.getPosition().x();
        int roverY = rover.getPosition().y();
        for(int i = roverY-1;i<= roverY+1;i++){
            for(int j = roverX-1;j<= roverX+1;j++){
                if(rover.getDiscoveredMap().get(i).get(j).equals(" ")){
                rover.setPosition(new Coordinate( i,j ));
                rover.getDiscoveredMap().get(i).set(j,"@");
                return;
                }
            }
        }
        for(int i = roverY+1;i >= roverY-1; i--){
            for(int j = roverX+1; j>= roverX-1; j--){
                if(rover.getDiscoveredMap().get(i).get(j).equals("@")){
                    rover.setPosition(new Coordinate( i, j));
                    return;
                }
            }
        }
    }
}
