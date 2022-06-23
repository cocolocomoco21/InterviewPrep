package com.cocolocomoco;

public class Main2 {
    public static void main(String[] args) {
        SolutionII solution = new SolutionII();

        String instructions = "GGLLGG";

        boolean result = solution.isRobotBounded(instructions);
        System.out.println(result);
    }
}

class SolutionII {

    public SolutionII() {
    }

    public boolean isRobotBounded(String instructions) {
        char[] parsedInstructions = instructions.toCharArray();
        Robot2 robot = new Robot2();

        // No commands given
        if (parsedInstructions.length == 0) {
            return true;
        }

        // Try one iteration
        for (char instruction : parsedInstructions) {
            this.move(instruction, robot);
        }
        if (robot.isAtOrigin()) {
            return true;
        }

        for (char instruction : parsedInstructions) {
            this.move(instruction, robot);
        }
        if (robot.isAtOrigin()) {
            return true;
        }

        for (char instruction : parsedInstructions) {
            this.move(instruction, robot);
        }
        for (char instruction : parsedInstructions) {
            this.move(instruction, robot);
        }
        if (robot.isAtOrigin()) {
            return true;
        }

        return false;
    }


    private void move(char instruction, Robot2 robot) {
        switch (instruction) {
            case 'G':
                robot.moveForward();
                break;
            case 'L':
                robot.rotateLeft();
                break;
            case 'R':
                robot.rotateRight();
                break;
        }
    }

}

class Robot2 {
    private int x;
    private int y;
    private Direction2 direction;

    public Robot2() {
        this.x = 0;
        this.y = 0;
        this.direction = Direction2.NORTH;
    }

    public void moveForward() {
        switch (this.direction) {
            case NORTH:
                this.y++;
                break;
            case WEST:
                this.x--;
                break;
            case SOUTH:
                this.y--;
                break;
            case EAST:
                this.x++;
                break;
        }
    }

    public void rotateLeft() {
        switch (this.direction) {
            case NORTH:
                this.direction = Direction2.WEST;
                break;
            case WEST:
                this.direction = Direction2.SOUTH;
                break;
            case SOUTH:
                this.direction = Direction2.EAST;
                break;
            case EAST:
                this.direction = Direction2.NORTH;
                break;
        }
    }

    public void rotateRight() {
        switch (this.direction) {
            case NORTH:
                this.direction = Direction2.EAST;
                break;
            case WEST:
                this.direction = Direction2.NORTH;
                break;
            case SOUTH:
                this.direction = Direction2.WEST;
                break;
            case EAST:
                this.direction = Direction2.SOUTH;
                break;
        }
    }

    public boolean isAtOrigin() {
        return this.x == 0 && this.y == 0;
    }
}

