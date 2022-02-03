Problem: https://leetcode.com/problems/find-median-from-data-stream/

Use two heaps - a max heap for the smaller numbers, and a min heap for the larger numbers. Do conditional logic to pop
off when needing to swap, insert into heaps. Median is either on the heap or the average of the two values.

Helpful link: https://leetcode.com/problems/find-median-from-data-stream/discuss/74047/JavaPython-two-heap-solution-O(log-n)-add-O(1)-find