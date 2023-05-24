package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.logic.algorithms.PathFinder;

import java.util.*;

public class ReturningRoutine implements Routine {
    @Override
    public void move(Context context) {
//        PathFinder pathFinder = new PathFinder();

        List<Coordinate> returningPath = PathFinder.findPathToCoordinate(context.getRover(), context.getRover().getDiscoveredMap(),
                context.getRover().getPosition(), context.getLandingCoordinate());
//        System.out.println("works");
//        System.out.println(returningPath);
    }
}
