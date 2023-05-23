package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;

import java.util.*;

public class ReturningRoutine implements Routine {
    @Override
    public void move(Context context) {
        List<List<Integer>> returningPath = findShortestPath(context.getRealMap(),
                context.getRover().getPosition(),context.getLandingCoordinate());
        System.out.println(returningPath);
    }
    private static List<List<Integer>> findShortestPath(List<List<String>> map, Coordinate start, Coordinate end) {
        int rows = map.size();
        int cols = map.get(0).size();

        // Create a visited matrix to keep track of visited cells
        boolean[][] visited = new boolean[rows][cols];

        // Create a queue for BFS
        Queue<List<Integer>> queue = new LinkedList<>();

        // Enqueue the start point and mark it as visited
        queue.add(Arrays.asList(start.x(), start.y()));
        visited[start.x()][start.y()] = true;

        // Create a matrix to store the previous points for each cell
        Coordinate[][] previous = new Coordinate[rows][cols];

        // Perform BFS
        while (!queue.isEmpty()) {
            List<Integer> current = queue.poll();
            int x = current.get(0);
            int y = current.get(1);

            // Check if the target point is reached
            if (x == end.x() && y == end.y()) {
                break;
            }

            // Explore the neighboring cells
            for (int[] direction : new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                // Check if the neighboring cell is valid and not visited
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY] && map.get(newX).get(newY).equals(" ")) {
                    queue.add(Arrays.asList(newX, newY));
                    visited[newX][newY] = true;
                    previous[newX][newY] = new Coordinate(x, y);
                }
            }
        }

        // If the target point was not reached, return an empty path
        if (!visited[end.x()][end.y()]) {
            return new ArrayList<>();
        }

        // Reconstruct the shortest path
        List<List<Integer>> shortestPath = new ArrayList<>();
        Coordinate current = end;
        while (current != null) {
            shortestPath.add(Arrays.asList(current.x(), current.y()));
            current = previous[current.x()][current.y()];
        }

        Collections.reverse(shortestPath);
        return shortestPath;
    }
}
