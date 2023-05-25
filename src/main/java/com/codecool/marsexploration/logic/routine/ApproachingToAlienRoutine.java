package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.logic.algorithms.PathFinder;

import java.util.List;

public class ApproachingToAlienRoutine implements Routine {
    @Override
    public void move(Context context) {

        Rover rover = context.getRover();
        List<Coordinate> approachingPath = PathFinder.findPathToSymbol(rover, Symbol.ALIEN);
        for(Coordinate coordinate : approachingPath){
            rover.getDiscoveredMap().get(coordinate.y()).set(coordinate.x(),"@");
        }

    }
}
