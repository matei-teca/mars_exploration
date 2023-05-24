package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.logic.algorithms.PathFinder;

import java.util.ArrayList;
import java.util.List;

public class Movement implements Phase {

    @Override
    public void perform(Context context) {
        Rover rover = context.getRover();
        String EXPLORING_SPACE = "?";
        List<Coordinate> newExploringPath;
        if(context.getExploringPath().isEmpty()){

            newExploringPath = PathFinder.findPathToSymbol(rover, rover.getDiscoveredMap(),rover.getPosition(), EXPLORING_SPACE);
            System.out.println(newExploringPath);
            for(Coordinate coordinate : newExploringPath){
                context.addToExploringPath(coordinate);
            }
        }

        Coordinate nextPosition = context.getExploringPath().poll();

        rover.setPosition(new Coordinate(nextPosition.y(),nextPosition.x()));
        rover.getDiscoveredMap().get(nextPosition.y()).set(nextPosition.x(), "@");

    }
}
