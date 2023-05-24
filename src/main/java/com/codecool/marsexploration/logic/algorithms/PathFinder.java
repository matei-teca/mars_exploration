package com.codecool.marsexploration.logic.algorithms;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;

import java.util.*;

public class PathFinder {

    private static final int[] DirectionUP = new int[]{-1, 0};
    private static final int[] DirectionLeft = new int[]{0, -1};
    private static final int[] DirectionRight = new int[]{0, 1};
    private static final int[] DirectionDown = new int[]{1, 0};
    private static final String FREE_SPACE = " ";
    private static final String PAST_WALKED_SPACE = "@";


    public static List<Coordinate> findPathToCoordinate(Rover rover, List<List<String>> map, Coordinate start, Coordinate end) {

//        for (List<String> list : map) {
//            System.out.println(list);
//        }


        int SIGHT = rover.getSight();


        int rows = map.size();
        int cols = map.get(0).size();


        // Create a visited matrix to keep track of visited cells
        boolean[][] trackedSpaces = new boolean[rows][cols];

        // Create a queue for BFS
        Queue<Coordinate> coordinatesToCheck = new LinkedList<>();

        // Enqueue the start point and mark it as visited
        coordinatesToCheck.add(new Coordinate(start.y(), start.x()));
        trackedSpaces[start.y()][start.x()] = true;

        // Create a matrix to store the previous points for each cell

        Coordinate[][] previousCoordinatesOnMatrix = new Coordinate[rows][cols];

        // Perform BFS
        while (!coordinatesToCheck.isEmpty()) {
            Coordinate currentCheckedCoordinates = coordinatesToCheck.poll();
            int y = currentCheckedCoordinates.y();
            int x = currentCheckedCoordinates.x();

            // Check if the target point is reached
            if (x == end.x() && y == end.y()) {
                break;
            }
            // Explore the neighboring cells
            for (int[] directions : new int[][]{DirectionUP, DirectionLeft, DirectionDown,  DirectionRight}) {
                int newY = y + directions[0];
                int newX = x + directions[1];

                // Check if the neighboring cell is valid and not visited
                if (newX >= SIGHT && newX < rows - SIGHT && newY >= SIGHT && newY < cols - SIGHT && !trackedSpaces[newY][newX] && (map.get(newY).get(newX).equals(PAST_WALKED_SPACE) || map.get(newY).get(newX).equals(FREE_SPACE))) {
                    coordinatesToCheck.add(new Coordinate(newY, newX));
                    trackedSpaces[newY][newX] = true;
                    previousCoordinatesOnMatrix[newY][newX] = new Coordinate(y, x);
                }
            }
        }
        // If the target point was not reached, return an empty path
        if (!trackedSpaces[end.y()][end.x()]) {
            return new ArrayList<>();
        }
        // Reconstruct the shortest path
        List<Coordinate> shortestPath = new ArrayList<>();
        Coordinate coordinateToAdd = new Coordinate(end.y(), end.x());

        while (coordinateToAdd != null) {
            shortestPath.add(new Coordinate(coordinateToAdd.y(), coordinateToAdd.x()));
            coordinateToAdd = previousCoordinatesOnMatrix[coordinateToAdd.y()][coordinateToAdd.x()];
        }

        Collections.reverse(shortestPath);

        return shortestPath;
    }



    public static List<Coordinate> findPathToSymbol(Rover rover, List<List<String>> map, Coordinate start, String symbol){

        for(List<String> list: map){
            System.out.println(list);
        }
        int SIGHT = rover.getSight();
        int rows = map.size();
        int cols = map.get(0).size();


        // Create a visited matrix to keep track of visited cells
        boolean[][] trackedSpaces = new boolean[rows][cols];

        // Create a queue for BFS
        Queue<Coordinate> coordinatesToCheck = new LinkedList<>();

        // Enqueue the start point and mark it as visited
        coordinatesToCheck.add(new Coordinate(start.y(), start.x()));
        trackedSpaces[start.y()][start.x()] = true;

        // Create a matrix to store the previous points for each cell

        Coordinate[][] previousCoordinatesOnMatrix = new Coordinate[rows][cols];

        Coordinate end = new Coordinate(-1,-1);
        // Perform BFS
        while (!coordinatesToCheck.isEmpty()) {
            Coordinate currentCheckedCoordinates = coordinatesToCheck.poll();

            int y = currentCheckedCoordinates.y();
            int x = currentCheckedCoordinates.x();


            // Check if the target point is reached
            if(map.get(y).get(x).equals(symbol)){
                System.out.println("end seted");
                end = new Coordinate(y, x);
                break;
            }

            // Explore the neighboring cells
            for (int[] directions : new int[][]{DirectionUP, DirectionLeft, DirectionDown, DirectionRight}) {
                int newY = y + directions[0];
                int newX = x + directions[1];

                // Check if the neighboring cell is valid and not visited
                if (newX >= SIGHT && newX < rows - SIGHT && newY >= SIGHT && newY < cols - SIGHT && !trackedSpaces[newY][newX] && (map.get(newY).get(newX).equals(PAST_WALKED_SPACE) || map.get(newY).get(newX).equals(FREE_SPACE) || map.get(newY).get(newX).equals(symbol))) {
                    coordinatesToCheck.add(new Coordinate(newY,newX));
                    trackedSpaces[newY][newX] = true;
                    previousCoordinatesOnMatrix[newY][newX] = new Coordinate(y, x);
                }
            }
        }
        // If the target point was not reached, return an empty path
        if ( end.y() == -1 && end.x() == -1) {
            return new ArrayList<>();
        }
        // Reconstruct the shortest path
        List<Coordinate> shortestPath = new ArrayList<>();
        Coordinate coordinateToAdd = new Coordinate(end.y(), end.x());

        while (coordinateToAdd != null) {
            shortestPath.add(new Coordinate(coordinateToAdd.y(), coordinateToAdd.x()));
            coordinateToAdd = previousCoordinatesOnMatrix[coordinateToAdd.y()][coordinateToAdd.x()];
        }

        Collections.reverse(shortestPath);

        return shortestPath;
    }

}
