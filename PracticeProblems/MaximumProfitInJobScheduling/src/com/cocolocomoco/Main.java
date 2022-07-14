package com.cocolocomoco;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] startTime = new int[] {1, 2, 3, 3};
//        int[] endTime = new int[] {3, 4, 5, 6};
//        int[] profit = new int[] {50, 10, 40, 70};

        int[] startTime = new int[] {1,2,3,4,6};
        int[] endTime = new int[] {3,5,10,6,9};
        int[] profit = new int[] {20,20,100,70,60};

        int result = solution.jobScheduling(startTime, endTime, profit);
        System.out.println(result);
    }
}

class Solution {
    HashMap<Integer, Integer> mapStartTimeToRollingProfit;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // Create jobs array sorted on startTime
        Job[] jobs = new Job[startTime.length];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.startTime));

        // Create DP hashmap to store max through a given job
        this.mapStartTimeToRollingProfit = new HashMap<>();

        return lookup(0, jobs);
    }

    private int lookup(int currentIndex, Job[] jobs) {
        if (currentIndex >= jobs.length) {
            return 0;
        }

        if (this.mapStartTimeToRollingProfit.containsKey(currentIndex)) {
            return this.mapStartTimeToRollingProfit.get(currentIndex);
        }

        int nextValidIndex = findNextValidIndex(currentIndex, jobs);
        int profitInclusive = jobs[currentIndex].profit + (nextValidIndex == -1 ? 0 : lookup(nextValidIndex, jobs));
        int profitExclusive = lookup(currentIndex + 1, jobs);

        int maxProfit = Math.max(profitInclusive, profitExclusive);
        this.mapStartTimeToRollingProfit.put(currentIndex, maxProfit);
        return maxProfit;
    }

    private int findNextValidIndex(int currentIndex, Job[] jobs) {
        int start = currentIndex + 1;
        int end = jobs.length - 1;
        Job currentJob = jobs[currentIndex];

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (jobs[mid].startTime >= currentJob.endTime) {
                if (jobs[mid - 1].startTime >= currentJob.endTime) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}

class Job {
    int startTime;
    int endTime;
    int profit;

    public Job(int startTime, int endTime, int profit) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }
}
