package com.cocolocomoco;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        int[][] obstacleGrid = new int[3][3];
//        obstacleGrid[0] = new int[] {0,0,1};
//        obstacleGrid[1] = new int[] {0,0,0};
//        obstacleGrid[2] = new int[] {0,0,0};

//        int[][] obstacleGrid = new int[5][4];
//        obstacleGrid[0] = new int[] {0,0,0,0};
//        obstacleGrid[1] = new int[] {0,1,0,0};
//        obstacleGrid[2] = new int[] {0,0,0,0};
//        obstacleGrid[3] = new int[] {0,0,1,0};
//        obstacleGrid[4] = new int[] {0,0,0,0};

        int[][] obstacleGrid = new int[][]{
                {0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,1,1,0,0,1,0,1,1,0,1,0,0,1,0,0,0,1,0,0},
                {0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0,0,1,0,0,0},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1,0,0,0,1,0,0,0,0,0,0,1,0,0,1,0,1},
                {0,0,0,1,0,0,0,0,0,0,0,1,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,1,0,0,0,1,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,1,0,0,1,0,0},
                {0,0,0,0,0,0,1,0,0,0,1,1,0,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0},
                {1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,1,0,0,0,1},
                {0,0,0,0,1,0,0,1,0,1,1,1,0,0,0,1,0,0,1,0,1,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,0,1,0,0,1,1,0,0,0,0,0,0,0,0,0,1,1,0,0,0},
                {1,0,1,0,1,1,0,1,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,1,1,0,0,0,0,1,0,0,0,1,0},
                {0,0,0,0,0,0,1,0,0,1,1,0,0,1,0,0,0,0,1,0,0,1,1,0,0,0,0,0,1,0,0,1,0,0,0,1},
                {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,1,0,0,1,0,0,0},
                {1,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
                {0,1,0,0,1,0,0,0,0,0,1,0,1,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,1,0,0,0,0,1,0,0,1,1,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
                {0,0,1,0,1,0,1,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0},
                {0,0,0,1,0,1,0,0,1,0,0,0,0,0,1,1,1,0,1,1,1,0,0,1,0,1,0,1,1,1,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,0,0,0,0,1,0,0,1,1,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
                {0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,1,0,0},
                {0,0,0,0,1,0,0,1,0,0,0,0,0,0,1,0,0,1,0,1,1,1,0,0,0,0,0,0,1,0,0,0,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0}
        };

        Solution solution = new Solution();
        int numUniquePaths = solution.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(numUniquePaths);
    }
}

class Solution {
    private HashMap<String, Integer> mapPointToNumUniquePaths;
    private int[][] obstacleGrid;
    private int numRows;
    private int numCols;

    Solution() {
        this.mapPointToNumUniquePaths = new HashMap<>();
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Initialize class vars to avoid redundant parameter
        this.obstacleGrid = obstacleGrid;
        this.numRows = obstacleGrid.length;
        this.numCols = obstacleGrid[0].length;

        int numUniquePaths = lookup(0,0);
        return numUniquePaths;
    }

    private int lookup(int row, int col) {
        // If obstacle, no path forward. Return 0
        if (this.obstacleGrid[row][col] == 1) {
            return 0;
        }

        // We've found the end tile, so return one since we've found one successful path
        if (row == this.numRows - 1 && col == this.numCols - 1) {
            return 1;
        }

        // If already exists in map, return to avoid recalculating
        // Note: I'd rather use the custom Point, but overriding hashCode is non-trival for an interview problem. Just
        // use a String instead and it's good enough to pass leetcode for the large-scale input :|
        String key = row+","+col;
        if (this.mapPointToNumUniquePaths.containsKey(key)) {
            return this.mapPointToNumUniquePaths.get(key);
        }

        int numUniquePaths = 0;

        // Get next downward move
        if (row + 1 < this.numRows && this.obstacleGrid[row + 1][col] != 1) {
            numUniquePaths += lookup(row + 1, col);
        }

        // Get next rightward move
        if (col + 1 < this.numCols && this.obstacleGrid[row][col + 1] != 1) {
            numUniquePaths += lookup(row, col + 1);
        }

        // If no paths from here, we mark as obstacle to avoid compute
        if (numUniquePaths == 0) {
            this.obstacleGrid[row][col] = 1;
            return 0;
        }

        this.mapPointToNumUniquePaths.put(key, numUniquePaths);
        return numUniquePaths;
    }
}

class Point {
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object other) {
        return other == this ||
                other instanceof Point point
                        && this.x == point.getX()
                        && this.y == point.getY();
    }
}
