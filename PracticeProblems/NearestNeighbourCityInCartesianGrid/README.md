# Find Nearest Point That Has the Same X or Y Coordinate / Nearest Neighbour City


## LC 1779 / DoorDash Onsite
- https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
- https://leetcode.com/discuss/interview-question/1379696/DoorDASH-Onsite

## Problem
Given an array of cities, specified by their Cartesian x, y coordinates, find the nearest city on the same line.

There are two variations:

1) LC says to find the nearest point
2) DoorDash Onsite says to return the name of the nearest city 

## Example
```
Input: x = 3, y = 4, points = [[1,2],[3,1],[2,4],[2,3],[4,4]]
Output: 2
Explanation: Of all the points, only [3,1], [2,4] and [4,4] are valid. Of the valid points, [2,4] and [4,4] have the smallest Manhattan distance from your current location, with a distance of 1. [2,4] has the smallest index, so return 2.
```

## Approach
Depends on which problem you do, but the gist is construct a map for lookup and find the nearest city. My approach was BFS by incrementing a `level` value, but it probably just makes more sense to make a map of `x -> list of cities with that x` and `y -> list of cities with that y`, then lookup the x and y for the given point, and iterate over the list of cities to find the closest city.

## Search Terms
lc-doordashonsite, lc-bfs, lc-arrays, lc-easy, lc-medium, lc-1779