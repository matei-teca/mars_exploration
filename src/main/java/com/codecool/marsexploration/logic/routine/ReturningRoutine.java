package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.logic.algorithms.PathFinder;

import java.util.*;

public class ReturningRoutine implements Routine {
    @Override
    public void move(Context context) {

        Rover rover = context.getRover();

        List<Coordinate> returningPath = PathFinder.findPathToCoordinate(rover, context.getLandingCoordinate());
        for(Coordinate coordinate : returningPath){
            rover.getDiscoveredMap().get(coordinate.y()).set(coordinate.x(),"$");
        }
    }
}
