# Queues
## Overview

Queues provide a data structure that holds data in a FIFO (first-in, first-out) format, imitating a line, or as Brits call them, queues.

#
## Time Complexity (worst case)
**Access (at a given location)**: O(n)

This is not quite the intent of queues, and as such, similar to stacks, you would have to remove all elements, find the element, and then requeue everything back in.

**Peek()**: O(1)

Peek is essentially the access function or capability for a queue. This can happen in constant time, because there will always be a pointer to the end of the queue.

**Insertion/Add(item)**: O(1)

Queues can be added to in constant time. It's essentially adding to the end of a linked list and keeping track of the head and tail.

**Deletion/Remove()**: O(1)

Since there is a tail pointer, it is constant time to remove this item and shift the tail pointer back.

**Search (to find if element exists)**: O(n)

Similar to access, this is against the nature of a queue. O(n).

#
## Space Complexity

#
## Distinguishing Features
- Four functions: `add(item)`, `remove()`, `peek()`, `isEmpty()`
- Probably best implemented with a linked list

#
## Example uses
- Breadth-first search
- Implementing cache

#
## Resources
- 
- 

#