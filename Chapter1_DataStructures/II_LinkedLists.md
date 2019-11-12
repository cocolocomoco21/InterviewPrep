# Linked Lists
## Overview

Linked list is a data structure which uses nodes, which contain data and pointers, in order to structure a sequence of data in, well, a linked list of this data. These nodes, connected by pointers, can point to the next node, previous node, both; you can have a head and tail pointer, etc. 

#
## Time Complexity (worst case)
**Access**: O(n)

To find an item in a linked list, in the worst case, you must traverse the entire list (assuming head and no tail). With a tail pointer included, the worst case is an item in the middle of the list, which would effectively be O(n/2), which is O(n) still.

**Insertion**: O(1)

Insertion is constant time due to having a head or tail pointer. Adding at this point, since there is no traversing, is constant.

**Deletion**: O(1)

Deletion is constant time, similarly to insertion, because of head or tail pointers. This allows access to one node (though not one specific node - that requires a search) in constant time. Since elements are not required to be shifted (like an array), constant.

**Search**: O(n)

Search is linear time because of the possible requirement to traverse the entire n-lengthed list to find the element.

#
## Space Complexity

#
## Distinguishing Features
- Can add or remove items from beginning (or end with a tail pointer) in constant O(1) time.
- No constant time access. Must iterate to find data.
- Singly vs. doubly linked lists:
    - Singly linked list - each node points to next. Acts as mono-directional queue.
    - Doubly linked list point to both next and previous nodes, and can be traversed in either direction. 

#
## Example uses

#
## Resources

#