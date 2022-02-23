    package com.cocolocomoco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[] {1,15,16,15,16,15,16,1};

        Solution solution = new Solution();
        int max = solution.rob(nums);
        System.out.println(max);

    }
}

class Solution {
    public int rob(int[] nums) {
        // For nums.length == 1, 2, or 3, we know it's just the max of all nums present
        if (nums.length >= 1 && nums.length <= 3) {
            int maxMoney = 0;
            for (int num : nums) {
                if (num > maxMoney) {
                    maxMoney = num;
                }
            }

            return maxMoney;
        }

        // Account for circular neighbors by having two iterations
        int includeFirstIndex = lookup(0, nums.length - 2, nums);
        int includeLastIndex = lookup(1, nums.length - 1, nums);

        return Math.max(includeFirstIndex, includeLastIndex);
    }

    private int lookup(int start, int end, int[] nums) {
        // Keep track of most money seen at a given index
        int[] money = new int[nums.length + 1];

        // Initialize the start two indexes
        money[start] = nums[start];
        money[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            // Take the max of either 1) the sum of the 2nd previous + current, or 2) the previous
            money[i] = Math.max(nums[i] + money[i - 2], money[i - 1]);
        }

        return money[end];
    }
}