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
        if (n < 0) {
            return 0;
        }

        // Can get to stairs using one step, or got here using two steps
        if (n == 0 || n == 1 ) {
            return 1;
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
}