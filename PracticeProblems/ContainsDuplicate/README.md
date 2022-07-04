# Contains Duplicate
### LC 217
https://leetcode.com/problems/contains-duplicate/

### Problem
Given an integer array `nums`, return `true` if any value appears at least twice in the array, and return `false` if every element is distinct.

Example 1:
```
Input: nums = [1,2,3,1]
Output: true
```

### Approach
Set lookup. For each element, try to lookup if a value is in the set. If so, return true. If not, add to set and continue iterating. If reach the end, return false.

Initial response was to use a hashmap mapping the value to the count for that value. However, we simply want to return true if there is a duplicate, not enumerate all duplicates. As such, a hashmap would provide higher memory usage (populating an entire data structure), when we don't need to. Further, this approach would require us to iterate through the entire list, when we can exit early by using a set.

In an interview, you could mention that Java's HashSet uses a HashMap underneath, so potentially the performance increases are negligable, but theoretically we just need a set, not a map.

### Search Terms
lc-blind75, lc-set, lc-hashset, lc-hashmap, lc-arrays, lc-easy, lc-217 } 