package com.cocolocomoco;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

// https://leetcode.com/discuss/interview-question/1379696/DoorDASH-Onsite
class DoorDashSolution {
    public List<String> closestStraightCity(List<String> c, List<Integer> xCoords, List<Integer> yCoords, List<String> queries) {
        // Construct maps: city name -> coordinates and coordinates -> city name
        Map<String, Coordinate> mapCityNameToCoordinate = new HashMap<>();
        Map<Coordinate, String> mapCoordinateToCityName = new HashMap<>();

        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int i = 0; i < c.size(); i++) {
            String cityName = c.get(i);
            int x = xCoords.get(i);
            int y = yCoords.get(i);
            Coordinate cityCoord = new Coordinate(x, y);

            mapCityNameToCoordinate.put(cityName, cityCoord);
            mapCoordinateToCityName.put(cityCoord, cityName);

            if (x > maxX) {
                maxX = x;
            }

            if (y > maxY) {
                maxY = y;
            }
        }

        List<String> result = new ArrayList<>();

        // Do lookup
        for (String query : queries) {
            Coordinate queryCoords = mapCityNameToCoordinate.get(query);
            int queryX = queryCoords.x;
            int queryY = queryCoords.y;

            // Lookup in each direction
            List<String> cityNames = new ArrayList<>();
            int level = 1;
            while (queryX + level <= maxX || queryX - level >= 0 || queryY + level <= maxY || queryY - level >= 0) {
                Coordinate above = new Coordinate(queryX, queryY + level);
                Coordinate below = new Coordinate(queryX, queryY - level);
                Coordinate left = new Coordinate(queryX - level, queryY);
                Coordinate right = new Coordinate(queryX + level, queryY);

                if (mapCoordinateToCityName.containsKey(above)) {
                    cityNames.add(mapCoordinateToCityName.get(above));
                }
                if (mapCoordinateToCityName.containsKey(below)) {
                    cityNames.add(mapCoordinateToCityName.get(below));
                }
                if (mapCoordinateToCityName.containsKey(right)) {
                    cityNames.add(mapCoordinateToCityName.get(right));
                }
                if (mapCoordinateToCityName.containsKey(left)) {
                    cityNames.add(mapCoordinateToCityName.get(left));
                }

                if (cityNames.size() > 0) {
                    break;
                }

                level ++;
            }

            if (cityNames.size() > 0) {
                cityNames.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
                result.add(cityNames.get(0));
            }

            result.add("NONE");
        }

        return result;
    }
}

class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Coordinate that = (Coordinate) other;
        return this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}

// https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
// Doesn't quite work. The return value on LC is cryptic and I think I misread what it's expecting
class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        HashSet<Coordinate> coordinates = new HashSet<>();

        for (int[] point : points) {
            coordinates.add(new Coordinate(point[0], point[1]));

            if (point[0] > maxX) {
                maxX = x;
            }

            if (point[1] > maxY) {
                maxY = y;
            }
        }

        // Kept for backwards compatabilty
        int queryX = x;
        int queryY = y;

        // Lookup in each direction
        int level = 0;
        List<Coordinate> nearestCoords = new ArrayList<>();
        while (queryX + level <= maxX || queryX - level >= 0 || queryY + level <= maxY || queryY - level >= 0) {
            Coordinate above = new Coordinate(queryX, queryY + level);
            Coordinate below = new Coordinate(queryX, queryY - level);
            Coordinate left = new Coordinate(queryX - level, queryY);
            Coordinate right = new Coordinate(queryX + level, queryY);

            if (coordinates.contains(above)) {
                nearestCoords.add(above);
            }
            if (coordinates.contains(below)) {
                nearestCoords.add(below);
            }
            if (coordinates.contains(right)) {
                nearestCoords.add(right);
            }
            if (coordinates.contains(left)) {
                nearestCoords.add(left);
            }

            if (nearestCoords.size() > 0) {
                break;
            }

            level ++;
        }

        if (level == 0) {
            return 0;
        } else if (nearestCoords.size() > 0) {
            Coordinate smallestSeenCoord = nearestCoords.get(0);
            for (Coordinate coord : nearestCoords) {
                if (Math.min(coord.x, coord.y) < Math.min(smallestSeenCoord.x, smallestSeenCoord.y)) {
                    smallestSeenCoord = coord;
                }
            }

            return Math.min(smallestSeenCoord.x, smallestSeenCoord.y);
        }

        return -1;
    }
}