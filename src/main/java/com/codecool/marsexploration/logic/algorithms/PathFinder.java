package com.codecool.marsexploration.logic.algorithms;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.data.Symbol;

import java.util.*;

public class PathFinder {

    private static final int[] DirectionUP = new int[]{-1, 0};
    private static final int[] DirectionLeft = new int[]{0, -1};
    private static final int[] DirectionRight = new int[]{0, 1};
    private static final int[] DirectionDown = new int[]{1, 0};
    private static final int[] DirectionDownLeft = new int[]{1, -1};
    private static final int[] DirectionDownRight = new int[]{1, 1};
    private static final int[] DirectionUpLeft = new int[]{-1, -1};
    private static final int[] DirectionUpRight = new int[]{-1, 1};
    private static final String FREE_SPACE = " ";
    private static final String PAST_WALKED_SPACE = "o";


    //Breadth-First Search algorithm
    public static List<Coordinate> findPathToCoordinate(Rover rover, Coordinate end) {

        List<List<String>> map = rover.getDiscoveredMap();
        Coordinate start = rover.getPosition();
        List<Symbol> allowedSymbols = new ArrayList<>(List.of(Symbol.USED_POSITION,Symbol.EMPTY));

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

            // Explore the neighboring cells
            for (int[] directions : new int[][]{DirectionUP, DirectionRight, DirectionUpRight,
                    DirectionDown, DirectionDownRight, DirectionLeft ,
                    DirectionDownLeft,   DirectionUpLeft}){
                int newY = y + directions[0];
                int newX = x + directions[1];

                // Check if the neighboring cell is valid and not visited
                if (validCell(newY,newX,cols,trackedSpaces,map,allowedSymbols)) {
                    coordinatesToCheck.add(new Coordinate(newY, newX));
                    trackedSpaces[newY][newX] = true;
                    previousCoordinatesOnMatrix[newY][newX] = new Coordinate(y, x);

                    // Check if the target point is reached
                    if (newX == end.x() && newY == end.y()) {
                        coordinatesToCheck.clear();
                        break;
                    }
                }
            }
        }
        // If the target point was not reached, return an empty path
        if (!trackedSpaces[end.y()][end.x()]) {
            return new ArrayList<>();
        }
        // Reconstruct the shortest path
        List<Coordinate> shortestPath = extractShortestPath(end,previousCoordinatesOnMatrix);

        return shortestPath;
    }

    public static List<Coordinate> findPathToSymbol(Rover rover, Symbol symbol){

        List<List<String>> map = rover.getDiscoveredMap();
        Coordinate start = rover.getPosition();

        List<Symbol> allowedSymbols = new ArrayList<>(List.of(Symbol.USED_POSITION,Symbol.EMPTY));
        allowedSymbols.add(symbol);

        int SIGHT = rover.getSight();
        int cols = map.size();
        Coordinate end = new Coordinate(-1,-1);

        // Create a visited matrix to keep track of visited cells
        boolean[][] trackedSpaces = new boolean[cols][cols];

        // Create a queue for BFS
        Queue<Coordinate> coordinatesToCheck = new LinkedList<>();

        // Enqueue the start point and mark it as visited
        coordinatesToCheck.add(new Coordinate(start.y(), start.x()));
        trackedSpaces[start.y()][start.x()] = true;

        // Create a matrix to store the previous points for each cell
        Coordinate[][] previousCoordinatesOnMatrix = new Coordinate[cols][cols];

        // Perform BFS
        while (!coordinatesToCheck.isEmpty()) {
            Coordinate currentCheckedCoordinates = coordinatesToCheck.poll();
            int y = currentCheckedCoordinates.y();
            int x = currentCheckedCoordinates.x();

            // Explore the neighboring cells
            for (int[] directions : new int[][]{DirectionUP, DirectionRight, DirectionUpRight, DirectionDown, DirectionDownRight, DirectionLeft ,DirectionDownLeft,   DirectionUpLeft}) {
                int newY = y + directions[0];
                int newX = x + directions[1];

                // Check if the neighboring cell is valid and not visited
                if (validCell(newY,newX,cols,trackedSpaces,map,allowedSymbols)) {

                    coordinatesToCheck.add(new Coordinate(newY,newX));
                    trackedSpaces[newY][newX] = true;
                    previousCoordinatesOnMatrix[newY][newX] = new Coordinate(y, x);

                    // Check if the target point is reached
                    if(map.get(newY).get(newX).equals(symbol.getSymbol())){
                        end = new Coordinate(newY, newX);
                        coordinatesToCheck.clear();
                        break;
                    }
                }
            }
        }
        // If the target point was not reached, return an empty path
        if ( end.y() == -1 && end.x() == -1) {
            return new ArrayList<>();
        }
        // Reconstruct the shortest path
        List<Coordinate> shortestPath = extractShortestPath(end,previousCoordinatesOnMatrix);

        return shortestPath.subList(1, shortestPath.size());
    }
    private static boolean validCell(int newY,int newX,int cols,boolean[][] trackedSpaces,List<List<String>> map,List<Symbol>allowedSymbols){

        if(newY >= 0 && newX >= 0 && newY< cols && newX < cols && !trackedSpaces[newY][newX]){
            for (Symbol symbol: allowedSymbols){
                if(map.get(newY).get(newX).equals(symbol.getSymbol())) return true;
            }
        }
        return false;
    }

    private static List<Coordinate> extractShortestPath (Coordinate end,Coordinate[][] previousCoordinatesOnMatrix){

        List<Coordinate> shortestPath = new ArrayList<>();
        Coordinate coordinateToAdd = new Coordinate(end.y(), end.x());

        while (coordinateToAdd != null ) {
            shortestPath.add(new Coordinate(coordinateToAdd.y(), coordinateToAdd.x()));
            coordinateToAdd = previousCoordinatesOnMatrix[coordinateToAdd.y()][coordinateToAdd.x()];
        }
        Collections.reverse(shortestPath);
        return shortestPath;
    }
}

