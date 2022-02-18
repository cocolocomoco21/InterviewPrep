package com.cocolocomoco;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        int[] coins = new int[] {186,419,83,408};
        int amount = 6249;

//        int[] coins = new int[] {1,2,5};
//        int amount = 100;

//        int[] coins = new int[] {1, 4, 6};
//        int amount = 8;

        Solution solution = new Solution();
//        SolutionII solution = new SolutionII();
        int fewestCoins = solution.coinChange(coins, amount);

        System.out.println(fewestCoins);
    }
}

// Borrowed from Leetcode for reference.
class SolutionII {

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return helper(coins, amount, new int[amount + 1]);
    }

    private int helper(int[] coins, int remainingAmount, int[] count) { // rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
        if (remainingAmount < 0) {
            return -1; // not valid
        }

        if (remainingAmount == 0) {
            return 0; // completed
        }

        if (count[remainingAmount] != 0) {
            return count[remainingAmount]; // already computed, so reuse
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = helper(coins, remainingAmount - coin, count);
            if (result != -1) {
                min = Math.min(result + 1, min);
            }
        }

        count[remainingAmount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[remainingAmount];
    }
}

class Solution {
    private HashMap<Integer, Integer> mapRemainingToLeastCoins;
    private TreeSet<Integer> coinsSet;

    public Solution() {
        this.mapRemainingToLeastCoins = new HashMap<>();
        this.coinsSet = new TreeSet<Integer>(Collections.reverseOrder());
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        // Populate set for constant time lookup. Use TreeSet to ensure descending-sorted order for optimal efficiency.
        this.coinsSet.clear();
        for (int coin: coins) {
            this.coinsSet.add(coin);
        }

        int result = lookup(amount, 0);
        return result == Integer.MAX_VALUE ? -1 :result;
    }

    private int lookup(int remainingAmount, int numCoins) {
        if (remainingAmount < 0) {
            return -1;
        }

        // Return if existing already
        if (mapRemainingToLeastCoins.containsKey(remainingAmount)) {
            return mapRemainingToLeastCoins.get(remainingAmount);
        }

        int min = Integer.MAX_VALUE;
        for (Integer coin: coinsSet) {
            int result;
            if (coinsSet.contains(remainingAmount)) {
                // Found viable total coin count. Use this below
                return 1;
            } else {
                // No viable count. Call again to try again
                result = lookup(remainingAmount - coin, numCoins + 1);
            }

            if (result <= min && result != -1) {
                min = result + 1;
            }
        }

        mapRemainingToLeastCoins.put(remainingAmount, min == Integer.MAX_VALUE ? -1 : min);
        return mapRemainingToLeastCoins.getOrDefault(remainingAmount, -1);
    }
}