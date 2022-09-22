package com.cocolocomoco;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        Solution solution = new Solution();
        int result = solution.minPathSum(grid);
        System.out.println(result);
    }
}

class Solution {
    int[][] grid;
    HashMap<String, Integer> mapCellToMinNum;
    int numRows = 0;
    int numCols = 0;


    public int minPathSum(int[][] grid) {
        this.grid = grid;
        this.mapCellToMinNum = new HashMap<>();
        this.numRows = grid.length;
        this.numCols = grid[0].length;

        int minSum = lookup(0, 0);
        return minSum;

    }

    private int lookup(int row, int col) {
        if (row == this.numRows - 1 && col == this.numCols - 1) {
            return grid[row][col];
        }

        if (row >= this.numRows || col >= numCols) {
            // TODO change this?
            return Integer.MAX_VALUE;
        }

        String lookupKey = formMapKey(row, col);
        if (this.mapCellToMinNum.containsKey(lookupKey)) {
            return this.mapCellToMinNum.get(lookupKey);
        }

        int minDown = lookup(row + 1, col);
        int minRight = lookup(row, col + 1);

        this.mapCellToMinNum.put(lookupKey, Math.min(minDown, minRight) + this.grid[row][col]);

        return this.mapCellToMinNum.get(lookupKey);
    }

    static String formMapKey(int row, int col) {
        return row + "," + col;
    }
}