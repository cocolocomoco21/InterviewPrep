# Sets (HashSet)
## Overview

Sets store any number of unique values. Programatic sets model the mathematical set.

## More Details and Definitions
Set is an abstract type that can have various implementations. In Java, this can be HashSet, TreeSet, LinkedHashSet, EnumSet, etc. In Java, the underlying data structure is a HashMap. 

Per the Oracle docs,
```
There are three general-purpose Set implementations — HashSet, TreeSet, and LinkedHashSet. Which of these three to use is generally straightforward. HashSet is much faster than TreeSet (constant-time versus log-time for most operations) but offers no ordering guarantees. If you need to use the operations in the SortedSet interface, or if value-ordered iteration is required, use TreeSet; otherwise, use HashSet. It's a fair bet that you'll end up using HashSet most of the time.
```

As such, we'll use HashSet throughout this doc.

Oracle continues with:

```
LinkedHashSet is in some sense intermediate between HashSet and TreeSet. Implemented as a hash table with a linked list running through it, it provides insertion-ordered iteration (least recently inserted to most recently) and runs nearly as fast as HashSet. The LinkedHashSet implementation spares its clients from the unspecified, generally chaotic ordering provided by HashSet without incurring the increased cost associated with TreeSet.
```

#
## Time Complexity (average case)
Note: we'll use HashSet for this doc. See above.

**Lookup/Contains**: O(1)

Each element is hashed into the set. Looking up for the hashed value is constant time.

**Insert**: O(1)

Each element is hashed into the set (O(1)). When the element is hashed, you can do constant time lookup to see if it exists. If not, adding is also constant time.

**Delete**: O(1)

Similar to insert - hash element, see if it exists (O(1)), if so, remove it (O(1) since it's a hashmap).

#
## Space Complexity
O(n) for the n elements that constitute the array. Technically, HashSet can have overhead with the underlying HashMap interface, but that is a Java nuance and not necessarily true for all Set abstract types.

#
## Distinguishing Features
- No duplciates
- Allows for good (or great) lookup
- No order (if HashSet)

#
## Strengths and Weaknesses

**Strengths**:
- Fast operations if HashSet (O(1))
- Abstract data type allows for various implementations - if order matters TreeSet (or potentially LinkedHashSet, above)

**Weaknesses**:
- No order if HashSet
- Java - HashSet can have wasted space and time if capacity is too big or load factor is incorrect

#
## Example uses
- Keeping track of visited nodes
- Any extension of the mathematical set

#
## Resources
- https://tutorialedge.net/compsci/data-structures/sets-for-beginners/
- https://docs.oracle.com/javase/tutorial/collections/implementations/set.html
- https://simplenotions.wordpress.com/2009/05/13/java-standard-data-structures-big-o-notation/
- https://docs.oracle.com/javase/8/docs/api/java/util/HashSet.html

#