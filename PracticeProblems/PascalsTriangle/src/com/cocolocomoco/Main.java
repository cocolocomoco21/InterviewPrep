package com.cocolocomoco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();

        int numRows = 1;
        List<List<Integer>> result = solution.generate(numRows);
        System.out.println(result.toString());
    }
}


class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> allCompletedRows = new ArrayList<List<Integer>>(numRows);

        // Form all rows
        for (int row = 1; row <= numRows; row++) {
            // Base cases - simply add first row of "1" and second row of "1, 1"
            if (row == 1) {
                allCompletedRows.add(Arrays.asList(1));
                continue;
            } else if (row == 2) {
                allCompletedRows.add(Arrays.asList(1, 1));
                continue;
            }

            // Populate row. Since row is 1-indexed, subtract 2 to get index
            allCompletedRows.add(formRow(row, allCompletedRows.get(row - 2)));
        }

        return allCompletedRows;
    }


    private List<Integer> formRow(int currentRowNumber, List<Integer> previousRow) {
        // We know numElementsInRow == rowNumber. Use interchangeably
        List<Integer> currentRow = new ArrayList<Integer>(currentRowNumber);

        for (int i = 0; i < currentRowNumber; i++) {
            if (i == 0 || i == currentRowNumber - 1) {
                currentRow.add(1);
                continue;
            }

            // Sum is above two elements
            int currentValue = previousRow.get(i - 1) + previousRow.get(i);
            currentRow.add(currentValue);
        }

        return currentRow;
    }
}