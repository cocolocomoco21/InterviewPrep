package com.cocolocomoco;

public class Main {

    public static void main(String[] args) {
        SolutionII solution = new SolutionII();
        int[] prices = new int[] {7,1,5,3,6,4};
//        int[] prices = new int[] {7,6,4,3,1};


        System.out.println(solution.maxProfit(prices));
    }
}

// [7,1,5,0,6,4]

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0];
        int maxPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];

            // If current price > max price seen, update and conditionally update profit if larger than existing
            if (currentPrice > maxPrice) {
                maxPrice = currentPrice;
                profit = Math.max(maxPrice - minPrice, profit);
            }

            // If current price < min price seen, update both min and max price
            if (currentPrice < minPrice) {
                minPrice = currentPrice;

                // Update maxPrice as well since we can't consider any previous maxPrice from this point forward
                maxPrice = currentPrice;
            }
        }

        return profit;
    }
}

class SolutionII {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentMin = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < currentMin) {
                currentMin = price;
            } else {
                if (price - currentMin > maxProfit) {
                    maxProfit = price - currentMin;
                }
            }
        }

        return maxProfit;
    }
}
