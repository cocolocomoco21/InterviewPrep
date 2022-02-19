package com.cocolocomoco;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        int n = 5;

        Solution solution = new Solution();
        int result = solution.compute(n);

        System.out.println(result);
    }
}

class Solution {
    private Integer[] steps = new Integer[] {1, 2, 3};
    private HashMap<Integer, Integer> mapRemainingStepsToCount = new HashMap<>();

    // A child is running up a staircase with n steps and can hop either 1, 2, or 3 steps at a time.
    // Implement a method to count how many possible ways the child can run up the stairs.
    public int tripleStep(int n) {
        int result = compute(n);
        return result;
    }


    public int compute(int remainingSteps) {
        if (this.mapRemainingStepsToCount.containsKey(remainingSteps)) {
            return this.mapRemainingStepsToCount.get(remainingSteps);
        }

        // Redundant since we don't call with negative numbers, but keep for safety
        if (remainingSteps < 0) {
            return 0;
        }

        if (remainingSteps == 0) {
            return 1;
        }

        int numSteps = 0;
        for (Integer step: this.steps) {
            if (step > remainingSteps) {
                continue;
            }

            int result = compute(remainingSteps - step);
            numSteps += result;

        }

        // At this point, numSteps contains total number of steps for given remainingStep number. Cache for faster lookup
        this.mapRemainingStepsToCount.put(remainingSteps, numSteps);
        return numSteps;
    }
}