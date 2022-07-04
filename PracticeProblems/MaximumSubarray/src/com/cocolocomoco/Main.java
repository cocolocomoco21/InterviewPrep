package com.cocolocomoco;

public class Main {

    public static void main(String[] args) {
	    /*
	    max: 6

	    [-2,1,-3,4,-1,2,1,-5,4]

	    [-2,1,-2,4, 3,5,6,-1,4]

        [5,4,-1,7,8]

        [5,9,8,15,23]

	     */


        Solution solution = new Solution();
        int[] nums = new int[] {5,4,-1,7,8};

        System.out.println(solution.maxSubArray(nums));
    }
}


class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        return max;
    }
}
