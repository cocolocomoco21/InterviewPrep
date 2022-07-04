package com.cocolocomoco;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        /*
        [1, 4, 5, 10]
        [200, 50, 40, 20]

        [1, 1, 4, 20]
        [200, 50, 10, 1]
         */

        Solution solution = new Solution();
//        int[] nums = new int[] {1, 2, 3, 4};
        int[] nums = new int[] {-1, 1, 0, -3, 3};

        System.out.println(Arrays.toString(solution.productExceptSelf(nums)));


    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Represent products up until index i, from the respective side.
        // So e.g. leftProduct[3] = nums[0] * nums[1] * nums[2], or rightProduct[n-3] means nums[n-1] * nums[n-2]
        int[] leftProducts = new int[nums.length];
        int[] rightProducts = new int[nums.length];
        int[] combinedProducts = new int[nums.length];

        // Assemble left products
        int totalProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            leftProducts[i] = totalProduct;
            totalProduct *= nums[i];
        }

        // Assemble right products
        totalProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            rightProducts[i] = totalProduct;
            totalProduct *= nums[i];
        }

        // Assemble combined products
        for (int i = 0; i < nums.length; i++) {
            combinedProducts[i] = leftProducts[i] * rightProducts[i];
        }

        return combinedProducts;
    }
}