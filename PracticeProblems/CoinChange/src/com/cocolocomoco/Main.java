package com.cocolocomoco;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
//        int[] coins = new int[] {2};
//        int amount = 3;

//        int[] coins = new int[] {186,419,83,408};
//        int amount = 6249;

        int[] coins = new int[] {1, 2, 5};
        int amount = 11;

//        int[] coins = new int[] {1, 4, 6};
//        int amount = 8;

//        Solution solution = new Solution();
//        SolutionII solution = new SolutionII();
//        SolutionIII solution = new SolutionIII();
        SolutionIV solution = new SolutionIV();
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
    private HashSet<Integer> coinsSet;

    public Solution() {
        this.mapRemainingToLeastCoins = new HashMap<>();
        this.coinsSet = new HashSet<Integer>();
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        // Populate set for constant time lookup.
        this.coinsSet.clear();
        this.mapRemainingToLeastCoins.clear();
        for (int coin: coins) {
            this.coinsSet.add(coin);
            this.mapRemainingToLeastCoins.put(coin, 1);
        }

        int result = lookup(amount);
        return result;
    }

    private int lookup(int remainingAmount) {
        if (remainingAmount < 0) {
            return -1;
        }

        // Return if existing already
        if (this.mapRemainingToLeastCoins.containsKey(remainingAmount)) {
            return this.mapRemainingToLeastCoins.get(remainingAmount);
        }

        int min = Integer.MAX_VALUE;
        for (Integer coin: this.coinsSet) {
            // No viable count. Call again to try again
            int result = lookup(remainingAmount - coin) ;
            if (result < min && result != -1) {
                min = result + 1;
            }
        }

        this.mapRemainingToLeastCoins.put(remainingAmount, min == Integer.MAX_VALUE ? -1 : min);
        return this.mapRemainingToLeastCoins.getOrDefault(remainingAmount, -1);
    }
}


class SolutionIII {
    HashMap<Integer, Integer> mapRemainingAmountToLeastCoins;

    public SolutionIII (){
        this.mapRemainingAmountToLeastCoins = new HashMap<>();
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        for (int coin : coins) {
            this.mapRemainingAmountToLeastCoins.put(coin, 1);
        }

        if (this.mapRemainingAmountToLeastCoins.containsKey(amount)) {
            return 1;
        }

        return lookup(coins, amount);
    }

    private int lookup(int[] coins, int remainingAmount) {
        // 0 or negative remainingAmount is invalid - this remainingAmount does not have a valid coin scenario
        if (remainingAmount < 1) {
            return -1;
        }

        // If already discovered value for this remainingAmount, return it instead of researching
        if (this.mapRemainingAmountToLeastCoins.containsKey(remainingAmount)) {
            return this.mapRemainingAmountToLeastCoins.get(remainingAmount);
        }

        int minCoinsForRemainingAmount = Integer.MAX_VALUE;
        for (int coin : coins) {
            int minCoins = lookup(coins, remainingAmount - coin);
            if (minCoins != -1 && minCoins < minCoinsForRemainingAmount) {
                // Add one to account for current coin
                minCoinsForRemainingAmount = minCoins + 1;
            }
        }

        // We found a valid minCoins amount, update it
        if (minCoinsForRemainingAmount != Integer.MAX_VALUE) {
            this.mapRemainingAmountToLeastCoins.put(remainingAmount, minCoinsForRemainingAmount);
        } else {
            this.mapRemainingAmountToLeastCoins.put(remainingAmount, -1);
        }

        return this.mapRemainingAmountToLeastCoins.get(remainingAmount);
    }
}

class SolutionIV {
    private HashMap<Integer, Integer> mapRemainingAmountToNumberOfCoins;
    private List<Integer> coins;

    public SolutionIV() {
        this.mapRemainingAmountToNumberOfCoins = new HashMap<>();
        this.coins = new ArrayList<>();
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        // In case this is run successively
        this.coins.clear();
        this.mapRemainingAmountToNumberOfCoins.clear();

        Arrays.stream(coins).forEach(coin -> {
            this.mapRemainingAmountToNumberOfCoins.put(coin, 1);
            this.coins.add(coin);
        });

        return lookup(amount);
    }

    private int lookup(int remainingAmount) {
        if (remainingAmount <= 0) {
            return -1;
        }

        if (this.mapRemainingAmountToNumberOfCoins.containsKey(remainingAmount)) {
            return this.mapRemainingAmountToNumberOfCoins.get(remainingAmount);
        }

        int minCoins = Integer.MAX_VALUE;
        for (int coin: this.coins) {
            int min = lookup(remainingAmount - coin);
            if (min < minCoins && min != -1) {
                minCoins = min;
            }
        }

        minCoins = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins + 1;

        this.mapRemainingAmountToNumberOfCoins.put(remainingAmount, minCoins);

        return minCoins;
    }
}