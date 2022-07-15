package com.cocolocomoco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        DoorDashSolution doorDashSolution = new DoorDashSolution();
        Location desiredLocation = new Location(0, 0);
        List<Dasher> result = doorDashSolution.getClosestDashers(desiredLocation);
        result.forEach(x -> System.out.println(x.id));
    }
}

class DoorDashSolution {
    private final int NUM_DASHERS = 3;

    public List<Dasher> getClosestDashers(Location desiredLocation) {
        List<Dasher> dashers = this.getDashers();
        dashers.sort((o1, o2) -> {
            double o1Distance = getDistance(desiredLocation, o1.lastLocation);
            double o2Distance = getDistance(desiredLocation, o2.lastLocation);

            if (Double.compare(o1Distance, o2Distance) == 0) {
                return o2.rating - o1.rating;
            }

            return Double.compare(o1Distance, o2Distance);
        });

        return dashers.subList(0, NUM_DASHERS);
    }


    private List<Dasher> getDashers() {
        Dasher d1 = new Dasher(1, new Location(2.0, 0.0), 80);
        Dasher d2 = new Dasher(2, new Location(0.0, 2.0), 90);
        Dasher d3 = new Dasher(3, new Location(3.5, 1.0), 70);
        Dasher d4 = new Dasher(4, new Location(1.0, 1.0), 75);
        Dasher d5 = new Dasher(5, new Location(1.0, 1.0), 76);

        return Arrays.asList(d1, d2, d3, d4);
    }

    private double getDistance(Location start, Location end) {
        double deltaLat = end.latitude - start.latitude;
        double deltaLong = end.longitude - start.longitude;
        return Math.sqrt(Math.pow(deltaLat, 2) + Math.pow(deltaLong, 2));
    }
}


class Dasher {
    long id;
    Location lastLocation;
    int rating;

    public Dasher(long id, Location lastLocation, int rating) {
        this.id = id;
        this.lastLocation = lastLocation;
        this.rating = rating;
    }
}

class Location {
    double longitude;
    double latitude;

    Location(double longitude, double lattitude) {
        this.longitude = longitude;
        this.latitude = lattitude;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = Arrays.stream(points)
                .sorted((o1, o2) ->  Double.compare(getDistanceFromOrigin(o1[0], o1[1]), getDistanceFromOrigin(o2[0], o2[1])))
                .limit(k)
                .toArray(int[][]::new);

        return result;
    }

    private double getDistanceFromOrigin(int x, int y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}