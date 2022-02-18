package com.cocolocomoco;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        int[] coins = new int[] {1,2,5};
        int amount = 10;

        Solution solution = new Solution();
        int fewestCoins = solution.coinChange(coins, amount);

        System.out.println(fewestCoins);
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

        // Populate set for constant time lookup
        this.coinsSet.clear();
        for (int coin: coins) {
            this.coinsSet.add(coin);
        }

        int fewestCoins = lookup(amount, 0);
        return fewestCoins;
    }

    private int lookup(int remainingAmount, int numCoins) {
        if (remainingAmount <= 0) {
            return Integer.MAX_VALUE;
        }

        for (Integer coin: coinsSet) {
            if (coin > remainingAmount) {
                continue;
            }

            int result = Integer.MAX_VALUE;

            if (coinsSet.contains(remainingAmount)) {
                result = numCoins + 1;
            } else {
                result = lookup(remainingAmount - coin, numCoins + 1);
            }

            int existingMinCoins = mapRemainingToLeastCoins.getOrDefault(remainingAmount, Integer.MAX_VALUE);
            if (result < existingMinCoins) {
                mapRemainingToLeastCoins.put(remainingAmount, result);
            }
        }

        return mapRemainingToLeastCoins.getOrDefault(remainingAmount, -1);
    }
}




//
//            if (coinsSet.contains(remainingAmount)) {
//                int totalAmount = numCoins + 1;
//                int existingMinCoins = mapRemainingToLeastCoins.getOrDefault(remainingAmount, Integer.MAX_VALUE);
//                if (totalAmount < existingMinCoins) {
//                    mapRemainingToLeastCoins.put(remainingAmount, totalAmount);
//                }
//
//                return totalAmount;
//            } else {
//                int result = lookup(remainingAmount - coin, numCoins + 1);
//                int existingMinCoins = mapRemainingToLeastCoins.getOrDefault(remainingAmount, Integer.MAX_VALUE);
//                if (result < existingMinCoins) {
//                    mapRemainingToLeastCoins.put(remainingAmount, result);
//                }
//
//                return mapRemainingToLeastCoins.getOrDefault(remainingAmount, Integer.MAX_VALUE);
//            }