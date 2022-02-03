package com.cocolocomoco;


import java.util.*;


public class Main {

    public static void main(String[] args) {
        Solution soln = new Solution();

        int[] nums = new int[] {-3, 4, 3, 90};
        int target = 0;

        int[] res = soln.twoSum(nums, target);

        System.out.println(res[0] + " " + res[1]);
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mapValueToIndex = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int remainingValue = target - num;

            if (mapValueToIndex.containsKey(remainingValue)) {
                int existingIndex = mapValueToIndex.get(remainingValue);

                res[0] = existingIndex;
                res[1] = i;
                break;
            }

            mapValueToIndex.put(num, i);
        }

        return res;
    }
}
