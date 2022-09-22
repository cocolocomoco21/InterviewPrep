package com.cocolocomoco;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    SolutionII solution = new SolutionII();
        int[] nums1 = {0,0,0,0,0};
        int[] nums2 = {-1,0,0,0,0,0,1};

        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
}

// NOTE: this does not work - there are many edge cases with reaching the end of iteration but not going past the end
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalSize = nums1.length + nums2.length;
        int numIterations = (int)Math.ceil(totalSize / 2.0);

        int nums1Itr = 0;
        int nums2Itr = 0;
        int nums1OverflowCount = 0;
        int nums2OverflowCount = 0;
        boolean isNums1LastIterated = false;

        while (numIterations > 0) {
            if (nums1Itr >= nums1.length) {
                nums2Itr++;
                nums1OverflowCount++;
                isNums1LastIterated = false;
            } else if (nums2Itr >= nums2.length) {
                nums1Itr++;
                nums2OverflowCount++;
                isNums1LastIterated = true;
            } else if (nums1[nums1Itr] < nums2[nums2Itr]) {
                nums1Itr++;
                isNums1LastIterated = true;
            } else {
                nums2Itr++;
                isNums1LastIterated = false;
            }

            numIterations--;
        }

        // Go back one if at max to avoid IndexOutOfBounds and point at valid value if we haven't overflowed past it
        if (nums1Itr >= nums1.length) {
            nums1Itr--;
        }
        if (nums2Itr >= nums2.length) {
            nums2Itr--;
        }

        if (totalSize % 2 == 1) {
            if (nums1OverflowCount > 1 || nums1.length == 0) {
                return nums2[nums2Itr];
            } else if (nums2OverflowCount > 1 || nums2.length == 0) {
                return nums1[nums1Itr];
            }

            return Math.min(nums1[nums1Itr], nums2[nums2Itr]);
        } else {
            if (nums1OverflowCount > 1 || nums1.length == 0) {
                return (nums2[nums2Itr] + nums2[nums2Itr + 1])/ 2.0;
            } else if (nums2OverflowCount > 1 || nums2.length == 0) {
                return (nums1[nums1Itr] + nums1[nums1Itr + 1]) / 2.0;
            }

            return (nums1[nums1Itr] + nums2[nums2Itr]) / 2.0;
        }
    }
}

class SolutionII {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalNums = nums1.length + nums2.length;
        List<Integer> sorted = new ArrayList<>(totalNums);

        int nums1Itr = 0;
        int nums2Itr = 0;

        while (nums1Itr < nums1.length && nums2Itr < nums2.length) {
            int num1 = nums1[nums1Itr];
            int num2 = nums2[nums2Itr];

            if (num1 < num2) {
                sorted.add(num1);
                nums1Itr++;
            } else {
                sorted.add(num2);
                nums2Itr++;
            }
        }

        // We've reached end of one array. Add all of remaining to end
        if (nums1Itr >= nums1.length) {
            while (nums2Itr < nums2.length) {
                sorted.add(nums2[nums2Itr]);
                nums2Itr++;
            }
        } else {
            while (nums1Itr < nums1.length) {
                sorted.add(nums1[nums1Itr]);
                nums1Itr++;
            }
        }

        // Subract 1 for zero-indexed
        int midpointIndex = (int)Math.ceil(totalNums / 2.0) - 1;
        if (totalNums % 2 == 1) {
            return sorted.get(midpointIndex);
        } else {
            return (sorted.get(midpointIndex) + sorted.get(midpointIndex + 1) ) / 2.0;
        }
    }
}
