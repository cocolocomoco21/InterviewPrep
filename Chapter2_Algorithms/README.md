# Chapter 2: Algorithms
## Table of Contents
1. Sorting
    - Bubble Sort
    - Selection Sort
    - Insertion Sort
    - Merge Sort
    - Quicksort
    - Radix Sort
    - Heapsort
2. Searching
    - Linear/Sequential Search
    - Binary Search
    - Breadth-First Search
    - Depth-First Search
3. Dynamic Programming
4. Recursion
5. Divide and Conquer
6. Greedy Algorithms

#
## Complexity Summary
### Sorting
Bubble sort:
- **Worst/best/average**: O(n^2)
- **Space**: O(1)

Selection sort:
- **Worst/best/average**: O(n^2)
- **Space**: O(1)

Insertion sort:
- **Worst**: O(n^2)
- **Best**: O(n) (if array is already sorted)
- **Average**: O(n^2)
- **Space**: O(1)

Merge sort:
- **Worst/best/average**: O(nlogn)
- **Space**: O(n)

Quicksort:
- **Worst**: O(n^2) (if array is already sorted)
- **Best/average**: O(nlogn)
- **Space**: O(logn)

Radix sort:
- **Worst/best/average**: O(n) (technically O(k*(n + range)), but for 64-bit binary ints, it goes to O(n))
- **Space**: O(n) (technically O(n + range), but for 64-bit binary ints, it goes to O(n))

Heapsort:
- **Worst/average**: O(nlogn)
- **Best**: O(n) (if all items are identical)
- **Space**: O(1)

Cheat sheets:
- https://www.interviewcake.com/sorting-algorithm-cheat-sheet
- https://www.bigocheatsheet.com/

## Searching
Linear/Sequential search:
- **Worst/average**: O(n)
- **Best**: O(1)
- **Space**: O(1)

Binary search:
- **Worst/average**: O(logn)
- **Best**: O(1)
- **Space**: O(1)

Breadth-first search:
- **Worst/best/average**: O(V + E), where V = number of vertices, E = number of edges (for adjacency list)
- **Space**: O(V), where V = number of vertices (for adjacency list)

Depth-first search:
- **Worst/best/average**: O(V + E), where V = number of vertices, E = number of edges (for adjacency list)
- **Space**: O(h), where h = height of tree


#
## Dump of to-dos (TODO delete)
•	Sorting, searching, binary search
•	Divide and conquer
•	Dynamic programming and memorization
•	Greedy algorithms
•	Recursion
•	Graph traversal, BFS, DFS
