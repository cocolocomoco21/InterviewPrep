# Arrays
## Overview
Arrays provide a simple method of storing data in-order in a table-like structure in memory.

Arrays provide quick lookups at a specific index and organize items sequentially. Items are accessed via index.  

#
## Time Complexity (worst case)
**Access**: O(1) (amortized)

Depending on number of collisions, worst case runtime is O(n) lookup. In the typical and best case, O(1).

**Insertion (at specific)**: O(n)

Inserting at a specific index requires the array to be shifted. In the worst case, this is at the beginning, and the entire n elements must be moved. Therefore, O(n).

**Append (at end)**: O(1)

Adding at the end of an array is constant insertion since you're just writing one value at one index, assuming the end or the array size is tracked. (Technically, this can be O(n) if the static array needs to be doubled, but this amortizes to O(1)).

**Deletion**: O(n)

O(n) to find element you want to delete, then O(n) to shift all elements on the right to the left to fill gap.

**Search**: O(n)

O(n) because you must traverse, in worst case, all elements to find the element with specified value.

#
## Space Complexity
O(n) for the n elements that constitute the array.

#
## Distinguishing Features
- Always fixed size
- Integer indexing allows for constant time lookup 

#
## Strengths and Weaknesses

**Strengths**:
- Fast lookup (O(1))
- Fast append (O(1))

**Weaknesses**:
- Fixed size
- Slow/costly search, insert and delete  (O(n))

#
## Example uses
- Hash table: map keys to values, stored in array. Use hash function to derive index, and store value at that index. Lookup is then constant.
- Dynamic/resizeable arrays - essentially Lists (e.g. ArrayList). O(1) access, amortized O(1) insertion
- Binary search tree

#
## Resources
- https://yourbasic.org/algorithms/time-complexity-arrays/
- https://www.interviewcake.com/concept/python/array
- https://www.interviewcake.com/concept/python/dynamic-array

#