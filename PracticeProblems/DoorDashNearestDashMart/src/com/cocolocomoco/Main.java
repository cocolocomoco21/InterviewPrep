package com.cocolocomoco;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

//        char[][] locationBoard = {
//                {'X', ' ', ' ', 'D', ' ', ' ', 'X', ' ', 'X'},
//                {'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', 'X'},
//                {' ', ' ', ' ', 'D', 'X', 'X', ' ', 'X', ' '},
//                {' ', ' ', ' ', 'D', ' ', 'X', ' ', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', 'X'},
//                {' ', ' ', ' ', ' ', 'X', ' ', ' ', 'X', 'X'}};

        List<List<Character>> locationBoard =
                Arrays.asList(
                        Arrays.asList('X', ' ', ' ', 'D', ' ', ' ', 'X', ' ', 'X'),
                        Arrays.asList('X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', 'X'),
                        Arrays.asList(' ', ' ', ' ', 'D', 'X', 'X', ' ', 'X', ' '),
                        Arrays.asList(' ', ' ', ' ', 'D', ' ', 'X', ' ', ' ', ' '),
                        Arrays.asList(' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', 'X'),
                        Arrays.asList(' ', ' ', ' ', ' ', 'X', ' ', ' ', 'X', 'X')
                );
        List<List<Integer>> locationList = Arrays.asList(Arrays.asList(2,2), Arrays.asList(4,0), Arrays.asList(0,4), Arrays.asList(2,6));


        List<Integer> result = solution.getClosestDashmart(locationBoard, locationList);
        System.out.println(result);
    }
}

/*
This solution approaches the problem from propagating the nearest dashmart to each road. So from each dashmart, do a
BFS to update the distance to nearest dashmart. This allows constant time lookup at the end.

NOTE: it's probably more straightforward to just do a BFS from each cell, keep a queue for cell and for level (or keep
the level as a field on a custom class). I've done that approach before and wanted to experiment. This took a big and is
unoptimized, so it's both easier, cleaner, and more optimal to just do BFS for each desired cell.
 */
class Solution {
    private final Character ROAD = ' ';
    private final Character BLOCKED_ROAD = 'X';
    private final Character DASHMART = 'D';

    public List<Integer> getClosestDashmart(List<List<Character>> locations, List<List<Integer>> deliveryLocations) {
        // Construct map of nearest dashmart for a given map
        for (int row = 0; row < locations.size(); row++) {
            for (int col = 0; col < locations.get(0).size(); col++) {
                Character currentChar = locations.get(row).get(col);

                // If currentChar is Dashmart, rerun nearest dashmart algorithm
                if (currentChar.equals(DASHMART)) {
                    Queue<Coordinate> queue = new LinkedList<>();
                    Queue<Integer> distanceQueue = new LinkedList<>();

                    // Add dashmart to queue
                    queue.add(new Coordinate(row, col));
                    distanceQueue.add(0);

                    while (!queue.isEmpty() || !distanceQueue.isEmpty()) {
                        // Get valid neighbors
                        Coordinate visitedCoord = queue.poll();
                        Integer visitedDistance = distanceQueue.poll();
                        Character visitedChar = locations.get(visitedCoord.row).get(visitedCoord.col);

                        // If we've found a closer dashmart, update the location
                        if (visitedChar.equals(ROAD) ||
                                (Character.isDigit(visitedChar) && visitedDistance < Character.digit(visitedChar, 10))) {
                            locations.get(visitedCoord.row).set(visitedCoord.col, Character.forDigit(visitedDistance, 10));
                        }

                        // Add all valid neighbors

                        // Below
                        if (visitedCoord.row < locations.size() - 1
                                && !locations.get(visitedCoord.row + 1).get(visitedCoord.col).equals(BLOCKED_ROAD)
                                && !locations.get(visitedCoord.row + 1).get(visitedCoord.col).equals(DASHMART)
                                && (locations.get(visitedCoord.row + 1).get(visitedCoord.col).equals(ROAD)
                                    || Character.digit(locations.get(visitedCoord.row + 1).get(visitedCoord.col), 10) > visitedDistance + 1)) {
                            queue.offer(new Coordinate(visitedCoord.row + 1, visitedCoord.col));
                            distanceQueue.offer(visitedDistance + 1);
                        }

                        // Above
                        if (visitedCoord.row > 0
                                && !locations.get(visitedCoord.row - 1).get(visitedCoord.col).equals(BLOCKED_ROAD)
                                && !locations.get(visitedCoord.row - 1).get(visitedCoord.col).equals(DASHMART)
                                && (locations.get(visitedCoord.row - 1).get(visitedCoord.col).equals(ROAD)
                                    || Character.digit(locations.get(visitedCoord.row - 1).get(visitedCoord.col), 10) > visitedDistance + 1)) {
                            queue.offer(new Coordinate(visitedCoord.row - 1, visitedCoord.col));
                            distanceQueue.offer(visitedDistance + 1);
                        }

                        // Left
                        if (visitedCoord.col > 0
                                && !locations.get(visitedCoord.row).get(visitedCoord.col - 1).equals(BLOCKED_ROAD)
                                && !locations.get(visitedCoord.row).get(visitedCoord.col - 1).equals(DASHMART)
                                && (locations.get(visitedCoord.row).get(visitedCoord.col - 1).equals(ROAD)
                                    || Character.digit(locations.get(visitedCoord.row).get(visitedCoord.col - 1), 10) > visitedDistance + 1)){
                            queue.offer(new Coordinate(visitedCoord.row, visitedCoord.col - 1));
                            distanceQueue.offer(visitedDistance + 1);
                        }

                        // Right
                        if (visitedCoord.col < locations.get(0).size() - 1
                                && !locations.get(visitedCoord.row).get(visitedCoord.col + 1).equals(BLOCKED_ROAD)
                                && !locations.get(visitedCoord.row).get(visitedCoord.col + 1).equals(DASHMART)
                                && (locations.get(visitedCoord.row).get(visitedCoord.col + 1).equals(ROAD)
                                    || Character.digit(locations.get(visitedCoord.row).get(visitedCoord.col + 1), 10) > visitedDistance + 1)) {
                            queue.offer(new Coordinate(visitedCoord.row, visitedCoord.col + 1));
                            distanceQueue.offer(visitedDistance + 1);
                        }

                    }
                }
            }
        }

        // Compile lookup values and return
        List<Integer> distances = new ArrayList<>();
        for (List<Integer> deliveryLocation: deliveryLocations) {
            Character locationDistance = locations.get(deliveryLocation.get(0)).get(deliveryLocation.get(1));
            if (Character.isDigit(locationDistance)) {
                distances.add(Character.digit(locationDistance, 10));
            } else {
                distances.add(-1);
            }
        }

        return distances;
    }
}

class Coordinate {
    int row;
    int col;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
