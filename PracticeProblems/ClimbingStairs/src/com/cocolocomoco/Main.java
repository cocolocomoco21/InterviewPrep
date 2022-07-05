package com.cocolocomoco;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int stairs = 3;
        int result = solution.climbStairs(stairs);

        System.out.println(result);
    }
}

class Solution {
    HashMap<Integer, Integer> mapStairToStepsToTop;

    public Solution() {
        this.mapStairToStepsToTop = new HashMap<>();
    }

    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }

        // Can get to stairs using one step
        if (n == 1 ) {
            return 1;
        }

        // Can get to stairs in two ways from second step (2 or 1+1)
        if (n == 2) {
            return 2;
        }

        // If we've already found the amount for this stair, return it
        if (mapStairToStepsToTop.containsKey(n)) {
            return mapStairToStepsToTop.get(n);
        }

        // Add total amount to map for lookup in future calls
        int totalForStair = climbStairs(n - 2) + climbStairs(n - 1);
        mapStairToStepsToTop.put(n, totalForStair);

        return totalForStair;
    }

    // "Bottom up" dynamic programming approach. Just use a table and the current value is the sum of the "max"
    // values from the previous two.
    // This could be further optimized by just using two trailing varibles instead of an array.
    public int climbStairs_bottomUp(int n) {
        if (n <= 0) {
            return 0;
        }

        // Can get to stairs using one step
        if (n == 1 ) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int[] memo = new int[n];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;

        for (int i = 3; i < n; i++) {
            memo[i] = memo[i - 1] + memo [i - 2];
        }

        return memo[n - 2] + memo[n - 1];
    }
}