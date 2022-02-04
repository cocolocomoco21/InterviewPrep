package com.cocolocomoco;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[][] intervals = new int[6][2];

        intervals[0] = new int[] {1,3};
        intervals[1] = new int[] {2,6};
        intervals[3] = new int[] {8,10};
        intervals[2] = new int[] {15,18};
        intervals[4] = new int[] {8,11};
        intervals[5] = new int[] {12,16};

        // If given list, this step is unnecessary. Making the list is an additional O(n), but overall O(nlogn) anyway due to sort
        List<int[]> intervalsSorted = Arrays.stream(intervals).sorted(Comparator.comparingInt(o -> o[0])).toList();

        // Initialize to size of original incase of entirely disjoint groups
        int[][] mergedIntervals = new int[intervalsSorted.size()][2];
        int mergedIntervalItr = 0;
        mergedIntervals[mergedIntervalItr] = intervalsSorted.get(0);

        for (int i = 0; i < intervalsSorted.size() - 1; i++) {
            int[] interval = intervalsSorted.get(i);
            int[] nextInterval = intervalsSorted.get(i + 1);

            // Is next interval within bounds of current interval
            if (interval[1] >= nextInterval[0]) {
                mergedIntervals[mergedIntervalItr][1] = nextInterval[1];
            } else {
                mergedIntervals[mergedIntervalItr][1] = interval[1];
                mergedIntervalItr++;
                mergedIntervals[mergedIntervalItr] = nextInterval;
            }
        }



        System.out.println(mergedIntervals);
    }
}
