# Arrays
## Overview
Arrays provide a simple method of storing data in a table-like structure in memory.

#
## Time Complexity (worst case)
**Lookup**: O(1) (amortized)

Depending on number of collisions, worst case runtime is O(n) lookup. In the typical and best case, O(1).

**Insertion**: O(n)

In the worst case, the array is full and insertion requires doubling space and copying the values to the new array (or doubling already existing array).

**Deletion**: O(n)

O(n) to find element you want to delete, then O(n) to shift all elements on the right to the left to fill gap.


**Search**: O(n)

O(n) because you must traverse, in worst case, all elements to find the element with specified value.

#
## Space Complexity

#
## Distinguishing Features
- Always fixed size
- Integer indexing allows for constant time lookup 

#
## Example uses
- Hash table: map keys to values, stored in array. Use hash function to derive index, and store value at that index. Lookup is then constant.
- Dynamic/resizeable arrays - essentially Lists (e.g. ArrayList)
- Binary search tree

#
## Resources
- https://yourbasic.org/algorithms/time-complexity-arrays/

#