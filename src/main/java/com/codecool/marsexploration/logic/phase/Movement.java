package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.logic.algorithms.PathFinder;
import com.codecool.marsexploration.util.MapPrinter;

import java.util.ArrayList;
import java.util.List;

public class Movement implements Phase {

    @Override
    public void perform(Context context) {
        Rover rover = context.getRover();

        addNewTargetToDiscoverIfEmpty(context);

        Coordinate nextPosition = context.getExploringPath().poll();
        if(nextPosition == null){
            context.stopExploring();
        } else {
            rover.setPosition(new Coordinate(nextPosition.y(),nextPosition.x()));
            rover.getDiscoveredMap().get(nextPosition.y()).set(nextPosition.x(), Symbol.USED_POSITION.getSymbol());
        }
        MapPrinter.printExploredMap(rover.getDiscoveredMap());
    }

    private void addNewTargetToDiscoverIfEmpty(Context context){
        if(context.getOutcome() == null){
            Rover rover = context.getRover();
            List<Coordinate> newExploringPath;

            if(context.getExploringPath().isEmpty()){
                newExploringPath = PathFinder.findPathToSymbol(rover, Symbol.UNKNOWN);
                context.addToExploringPath(newExploringPath);
            }
        }
    }

}
