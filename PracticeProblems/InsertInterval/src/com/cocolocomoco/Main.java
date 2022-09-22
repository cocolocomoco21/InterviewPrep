package com.cocolocomoco;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = new int[][] {{1,3},{6,9}};
        int[] newInterval = new int[] {2,5};

        int[][] result = solution.insert(intervals, newInterval);
        int x = 0;

    }
}

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] insertIntervals = new int[intervals.length + 1][2];
        int insertItr = 0;

        Integer[] mergedInterval = null;


        for (int i = 0; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];

            // currentInterval is wholly before or after
            if (currentInterval[1] < newInterval[0] || currentInterval[0] > newInterval[1] && mergedInterval == null) {
                // Simply copy over
                insertIntervals[insertItr] = currentInterval;
                insertItr++;
            } else if (mergedInterval != null) {
                if (currentInterval[1] > mergedInterval[0] || currentInterval[0] < newInterval[1]){
                    int minIndex = Math.min(currentInterval[0], mergedInterval[0]);
                    int maxIndex = Math.max(currentInterval[1], mergedInterval[1]);

                    mergedInterval = new Integer[]{minIndex, maxIndex};

                } else {
                    insertIntervals[insertItr] = new int[] { mergedInterval[0], mergedInterval[1] };
                    insertItr++;

                    insertIntervals[insertItr] = new int[] { mergedInterval[0], mergedInterval[1] };
                    insertItr++;
                    mergedInterval = null;
                }

            } else {
                int minIndex = Math.min(currentInterval[0], newInterval[0]);
                int maxIndex = Math.max(currentInterval[1], newInterval[1]);
                mergedInterval = new Integer[] {minIndex, maxIndex};

//                insertIntervals[insertItr] = new int[] { mergedInterval[0], mergedInterval[1] };
//                insertItr++;

            }
        }

        if (mergedInterval != null) {
            insertIntervals[insertItr] = new int[] { mergedInterval[0], mergedInterval[1] };
        }

        return insertIntervals;
    }
}
