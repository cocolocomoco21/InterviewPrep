package com.cocolocomoco;


public class Main {

    public static void main(String[] args) {
	    Solution soln = new Solution();

        String instructions = "GLRR";
        boolean isRobotBounded = soln.isRobotBounded(instructions);

        System.out.println(isRobotBounded);
    }
}


class Solution {
    public boolean isRobotBounded(String instructions) {
        if (!this.isInputValid(instructions)) {
            throw new IllegalArgumentException(instructions + " are not valid");
        }

        // Create robot to track current coord
        Robot robot = new Robot();

        // Iterate four times. Mathematically, a closed object is bounded by a circle, and due to the constraint of at
        // most 90-degree turns, we know that four complete sequences of movements will determine if this a closed loop
        // As such, complete four iterations over the moves and determine if the ending Coordinate is the origin (0,0);
        // if less than four iterations complete a cycle, so will four.
        for (int iteration = 0; iteration < 4; iteration++) {
            for (char command: instructions.toCharArray()) {
                // Move the robot
                switch (command) {
                    case 'L' -> {
                        robot.turnLeft();
                    }
                    case 'R' -> {
                        robot.turnRight();
                    }
                    case 'G' -> {
                        robot.moveForward();
                    }
                    default -> {
                        throw new IllegalArgumentException("Instruction is not a recognized command");
                    }
                }
            }

            // If cyclical in less than four iterations, return early
            if (robot.getCurrentCoordinate().equals(CoordinateHelper.originCoordinate())) {
                return true;
            }
        }

        return robot.getCurrentCoordinate().equals(CoordinateHelper.originCoordinate());
    }

    private boolean isInputValid(String instructions) {
        return true;
    }
}

class Robot {
    private Coordinate currentCoordinate;
    private Direction direction;

    public Robot() {
        this.currentCoordinate = new Coordinate(0, 0);
        this.direction  = Direction.NORTH;
    }

    public Coordinate getCurrentCoordinate() {
        return this.currentCoordinate;
    }

    public void setCurrentCoordinate(Coordinate currentCoordinate) {
        this.currentCoordinate = currentCoordinate;
    }

    // Move in the direction the robot is facing
    public Coordinate moveForward() {
        switch (this.direction) {
            case NORTH -> {
                this.currentCoordinate = CoordinateHelper.moveNorth(this.currentCoordinate);
            }
            case WEST -> {
                this.currentCoordinate = CoordinateHelper.moveWest(this.currentCoordinate);
            }
            case SOUTH -> {
                this.currentCoordinate = CoordinateHelper.moveSouth(this.currentCoordinate);
            }
            case EAST -> {
                this.currentCoordinate = CoordinateHelper.moveEast(this.currentCoordinate);
            }
        }

        return this.currentCoordinate;
    }

    public Direction turnLeft() {
        switch (this.direction) {
            case NORTH -> {
                this.direction = Direction.WEST;
            }
            case WEST -> {
                this.direction = Direction.SOUTH;
            }
            case SOUTH -> {
                this.direction = Direction.EAST;
            }
            case EAST -> {
                this.direction = Direction.NORTH;
            }
        }

        return this.direction;
    }

    public Direction turnRight() {
        switch (this.direction) {
            case NORTH -> {
                this.direction = Direction.EAST;
            }
            case WEST -> {
                this.direction = Direction.NORTH;
            }
            case SOUTH -> {
                this.direction = Direction.WEST;
            }
            case EAST -> {
                this.direction = Direction.SOUTH;
            }
        }

        return this.direction;
    }
}

/**
 * Represents a coordinate on the xy plane. (0,0) is the origin, with negative x to the left and negative y below
 */
class Coordinate {
    private int x;
    private int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object coordinate) {
        if (this == coordinate) {
            return true;

        }

        return (coordinate instanceof Coordinate aCoordinate) && this.getX() == aCoordinate.getX() && this.getY() == aCoordinate.getY();
    }
}

enum Direction {
    NORTH,
    WEST,
    SOUTH,
    EAST
}

class CoordinateHelper {
    // Note: Although pass by value, since this is a reference, this is effectively pass by reference. Returning the
    // Coordinate is somewhat redundant, but for OOP explicit passing, I'll keep it
    public static Coordinate moveNorth(Coordinate coordinate) {
        coordinate.setY(coordinate.getY() + 1);
        return coordinate;
    }

    public static Coordinate moveWest(Coordinate coordinate) {
        coordinate.setX(coordinate.getX() - 1);
        return coordinate;
    }

    public static Coordinate moveSouth(Coordinate coordinate) {
        coordinate.setY(coordinate.getY() - 1);
        return coordinate;
    }

    public static Coordinate moveEast(Coordinate coordinate) {
        coordinate.setX(coordinate.getX() + 1);
        return coordinate;
    }

    public static Coordinate originCoordinate() {
        return new Coordinate(0, 0);
    }
}
