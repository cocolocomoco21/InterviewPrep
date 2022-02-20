package com.cocolocomoco;

public class Main {

    public static void main(String[] args) {
//        char[][] grid = {
//                {'1','1','0','0','0'},
//                {'1','1','0','0','0'},
//                {'0','0','1','0','0'},
//                {'0','0','0','1','1'}
//        };

//        char[][] grid = {
//                {'1','1','1'},
//                {'0','1','0'},
//                {'1','1','1'}
//        };

//        char[][] grid = {
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}
//        };

        char[][] grid = {
                {'1','0','1','1','1'},
                {'1','0','1','0','1'},
                {'1','1','1','0','1'}
        };


        Solution solution = new Solution();
        int result = solution.numIslands(grid);
        System.out.println(result);
    }
}


class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;

        int numRows = grid.length;
        int numCols = grid[0].length;

        for (int r = 0; r < numRows; r++){
            for (int c = 0; c < numCols; c++){
                // If current cell is water, cannot possibly be island - continue to next cell
                char currCell = grid[r][c];
                if (currCell == '0' || currCell == 'v') {
                    continue;
                }

                // Found new island - visit it
                if (currCell == '1') {
                    numIslands++;
                    visitIsland(r, c, grid);
                }
            }
        }

        return numIslands;
    }

    private void visitIsland(int r, int c, char[][] grid) {
        int above = r - 1;
        int below = r + 1;
        int left = c - 1;
        int right = c + 1;

        int numRows = grid.length;
        int numCols = grid[0].length;

        // Check above
        if (above >= 0 && grid[above][c] == '1') {
            grid[above][c] = 'v';
            visitIsland(above, c, grid);
        }

        // Check below
        if (below <= numRows - 1 && grid[below][c] == '1') {
            grid[below][c] = 'v';
            visitIsland(below, c, grid);
        }

        // Check left
        if (left >= 0 && grid[r][left] == '1') {
            grid[r][left] = 'v';
            visitIsland(r, left, grid);
        }

        // Check right
        if (right <= numCols - 1 && grid[r][right] == '1') {
            grid[r][right] = 'v';
            visitIsland(r, right, grid);
        }
    }
}