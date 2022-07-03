# Hash Tables
## Overview
Hash tables, based on arrays, map keys to values for highly efficient lookup. 

Similarly to arrays, hash tables provide constant time lookup according to a lookup value (key for hash table, index for array). Differently from arrays, this lookup is calculated by a hash function and is unordered. This hash function maps to an index for the hash table/array, which then provides constant time lookup to the data stored there.

#
## Time Complexity (average case)
**Lookup**: O(1) (amortized)

Depending on number of collisions, worst case runtime is O(n) lookup. In the typical and best case, O(1).

**Insertion (at specific)**: O(1) (amortized)

In the worst case, the entire hash table is collided at one key and you must deal with n collisions (O(n)). Assuming a "good" hash function, the keys are spread across the hash table, which leads to no collisions and therefore O(1) insertion.

**Deletion**: O(1) (amortized)

In the worst case, you must iterate over n collisions to to find element you want to delete (O(n)), then depending on the collision data structure, O(n) to shift all elements. In the average case, the data is spread due to "good" hash function and it is constant time to delete.

#
## Space Complexity
O(n) for all elements that constitute a hash table.

#
## Distinguishing Features
- Requries computing index according to a hash function for a key. `index = hash(key)`
- Fast lookup, insert, delete
- Can have collisions - commonly, use pointer in array to point to linked list. No collisions = no lost efficiency, but collisions = extensible solution 

#
## Strengths and Weaknesses

**Strengths**:
- Fast lookup - O(1)
- Flexible keys - can use nearly any data type for key

**Weaknesses**:
- Relies on a "good" hash function. If hash does not distribute data well, you will have costly collisions
- Unordered, so no ordering of keys
- Single-directional lookup - can lookup value in O(1) time, but cannot lookup key for a given value in O(1) time
- Not cache friendly - many hash table impls use linked lists, which don't put data next to each other in memory. May need to load in chunks from memory (costly!).

#
## Example uses
- HashMap in Java
- Dictionary, phone book, caching, quick lookup of large dataset
- Sets - basically hash tables without the value

#
## Resources
- https://yourbasic.org/algorithms/time-complexity-arrays/#maps-and-dictionaries
- https://www.interviewcake.com/concept/python/hash-map?

#