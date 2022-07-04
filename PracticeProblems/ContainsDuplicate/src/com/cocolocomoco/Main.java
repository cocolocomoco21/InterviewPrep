package com.cocolocomoco;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {1,2,3,1};

        System.out.println(solution.containsDuplicate(nums));
    }
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seenValues = new HashSet<Integer>();

        for (int num : nums) {
            if (seenValues.contains(num)) {
                return true;
            }

            seenValues.add(num);
        }

        return false;
    }
}