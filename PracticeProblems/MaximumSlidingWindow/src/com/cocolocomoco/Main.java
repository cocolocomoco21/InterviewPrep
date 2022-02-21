package com.cocolocomoco;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
	    int k = 3;
        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};

//        int[] nums = new int[] {
//
//        };

        Solution solution = new Solution();
        int[] result = solution.maxSlidingWindow(nums, k);

        Arrays.stream(result).forEach(System.out::println);
    }
}


class SolutionOriginal {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Create maxHeap to keep the current window's maximum on top
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int[] maxSlidingWindow = new int[nums.length - k + 1];

        // Pre-load with beginning elements
        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }
        maxSlidingWindow[0] = maxHeap.peek();

        for (int i = 1; i <= nums.length - k; i++) {
            int windowUpperIndex = i + k - 1;
            int windowLowerIndex = i;

            // Add new window upper bound
            maxHeap.add(nums[windowUpperIndex]);

            // Remove previous window lower bound
            maxHeap.remove(nums[windowLowerIndex - 1]);

            // Add max sliding window
            maxSlidingWindow[i] = maxHeap.peek();
        }

        return maxSlidingWindow;
    }
}



class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Create maxHeap to keep the current window's maximum on top
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        // Create HashMap to count deletes
        HashMap<Integer, Integer> mapDeletedNumToCount = new HashMap<>();

        int[] maxSlidingWindow = new int[nums.length - k + 1];

        // Pre-load with beginning elements
        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }
        maxSlidingWindow[0] = maxHeap.peek();

        for (int i = 1; i <= nums.length - k; i++) {
            int windowUpperIndex = i + k - 1;
            int windowLowerIndex = i;

            // Add new window upper bound
            maxHeap.add(nums[windowUpperIndex]);

            // Remove previous window lower bound
            int removed = nums[windowLowerIndex - 1];
            mapDeletedNumToCount.put(removed, mapDeletedNumToCount.getOrDefault(removed, 0) + 1);

            // Add max sliding window
            while (mapDeletedNumToCount.containsKey(maxHeap.peek())) {
                int currentMax = maxHeap.peek();

                int numOccurrences = mapDeletedNumToCount.get(currentMax);
                numOccurrences--;
                if (numOccurrences == 0) {
                    mapDeletedNumToCount.remove(currentMax);
                } else {
                    mapDeletedNumToCount.put(currentMax, numOccurrences);
                }

                maxHeap.remove();

            }

            maxSlidingWindow[i] = maxHeap.peek();
        }

        return maxSlidingWindow;
    }
}