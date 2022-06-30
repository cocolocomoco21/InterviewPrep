# Linked Lists
## Overview

Linked lists are a data structure that represent a sequence of nodes. 

Nodes are comprised of data and pointers. These nodes, connected by pointers, can point to the next node, previous node, or both; you can have a head and tail pointer, etc.  

#
## Time Complexity (worst case)
**Access/Search/Lookup**: O(n)

To find an item in a linked list, in the worst case, you must traverse the entire list (assuming head and no tail). With a tail pointer included, the worst case is an item in the middle of the list, which would effectively be O(n/2), which is O(n) still.

**Insert (at specific)**: O(n)

Must traverse up to n elements to insert at specific "index", so O(n). If head and tail, worst case O(n/2) -> O(n). 

**Append/Prepend (at beginning/end)**: O(1)

Insertion is constant time due to having a head or tail pointer. Adding at this point, since there is no traversing, is constant.

**Deletion**: O(n)

Must traverse up to n elements to find element to delete, so O(n). If head and tail, worst case O(n/2) -> O(n). 

#
## Space Complexity

O(n) due to n elements.

#
## Distinguishing Features
- Can add or remove items from beginning (or end with a tail pointer) in constant O(1) time.
- No constant time access. Must iterate to find data.
- Singly vs. doubly linked lists:
    - Singly linked list - each node points to next. Acts as mono-directional queue.
    - Doubly linked list point to both next and previous nodes, and can be traversed in either direction. 

#
## Strengths and Weaknesses

**Strengths**:
- Fast operations at the ends (insert/delete) - O(1)
- Flexible size - dynamically just keep pointing to next elements

**Weaknesses**:
- Costly lookups
- Costly non-end operations (delete or insert at specific point)
- Not cache friendly since data is not stored adjacent

#
## Example uses
- Stacks and queues - only need operations on ends 

#
## Resources
- https://www.interviewcake.com/concept/python/linked-list?

#