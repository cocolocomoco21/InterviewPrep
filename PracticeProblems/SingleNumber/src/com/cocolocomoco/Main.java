package com.cocolocomoco;

public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
        int[] nums = {1, 2, 3, 2};

        int result = solution.singleNumber(nums);
        System.out.println(result);
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor |= num;
        }

        return xor;
    }

}