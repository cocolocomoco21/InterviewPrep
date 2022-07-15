package com.cocolocomoco;

import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    private final char EMPTY = '.';

    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> mapRowToValues = new HashMap<>();
        HashMap<Integer, HashSet<Character>> mapColToValues = new HashMap<>();
        HashMap<Integer, HashSet<Character>> mapQuadrantToValues = new HashMap<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                char currChar = board[row][col];
                if (currChar != EMPTY) {
                    if (!mapRowToValues.containsKey(row)) {
                        mapRowToValues.put(row, new HashSet<>());
                    }

                    if (!mapColToValues.containsKey(col)) {
                        mapColToValues.put(col, new HashSet<>());
                    }

                    // Add to row values and check if present
                    boolean isRowValueAbsent = mapRowToValues.get(row).add(currChar);
                    if (!isRowValueAbsent) {
                        return false;
                    }

                    // Add to col values and check if present
                    boolean isColValueAbsent = mapColToValues.get(col).add(currChar);
                    if (!isColValueAbsent) {
                        return false;
                    }

                    if (!addToQuadrantMap(row, col, currChar, mapQuadrantToValues)) {
                        return false;
                    }
                }
            }
        }

        return true;

    }

    private boolean addToQuadrantMap(int row, int col, char value, HashMap<Integer, HashSet<Character>> mapQuadrantToValues) {
        int quadrantNumber = -1;
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            // Quadrant 0
            quadrantNumber = 0;
        } else if (row >= 0 && row <= 2 && col >= 3 && col <= 5) {
            // Quadrant 1
            quadrantNumber = 1;
        } else if (row >= 0 && row <= 2 && col >= 6 && col <= 8) {
            // Quadrant 2
            quadrantNumber = 2;
        } else if (row >= 3 && row <= 5 && col >= 0 && col <= 2) {
            // Quadrant 3
            quadrantNumber = 3;
        } else if (row >= 3 && row <= 5 && col >= 3 && col <= 5) {
            // Quadrant 4
            quadrantNumber = 4;
        } else if (row >= 3 && row <= 5 && col >= 6 && col <= 8) {
            // Quadrant 5
            quadrantNumber = 5;
        } else if (row >= 6 && row <= 8 && col >= 0 && col <= 2) {
            // Quadrant 6
            quadrantNumber = 6;
        } else if (row >= 6 && row <= 8 && col >= 3 && col <= 5) {
            // Quadrant 7
            quadrantNumber = 7;
        } else if (row >= 6 && row <= 8 && col >= 6 && col <= 8) {
            // Quadrant 8
            quadrantNumber = 8;
        } else {
            // error
        }

        if (!mapQuadrantToValues.containsKey(quadrantNumber)) {
            mapQuadrantToValues.put(quadrantNumber, new HashSet<>());
        }

        boolean isQuadrantValueAbsent = mapQuadrantToValues.get(quadrantNumber).add(value);
        if (!isQuadrantValueAbsent) {
            return false;
        }

        return true;
    }
}
