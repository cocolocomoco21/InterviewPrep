# Queues
## Overview

Queues provide a data structure that holds data in a FIFO (first-in, first-out) format. An analogy is a line at the grocery store, or as Brits call them, queues.

#
## Time Complexity (worst case)
**Access (at a given location)**: O(n)

This is not quite the intent of queues, and similarly to stacks, you would have to remove all elements and add to a new queue, find the element, and then requeue everything back into the original queue. O(n) time and O(n) space complexity.

**Enqueue/Add**: O(1)

Queues can be added to in constant time. It's essentially adding to the end of a linked list and keeping track of the head and tail. Since you keep track of the end, this is O(1).

**Dequeue/Remove**: O(1)

Since there is a head pointer, it is constant time to remove this item and shift the head pointer to the next element. Since you keep track of the head, it's O(1).

**Peek**: O(1)

Peek is essentially dequeue without removing the element. This happens in constant time because there will always be a pointer to the end of the queue. O(1).

#
## Space Complexity

O(n) to hold all n elements

#
## Distinguishing Features
- Four functions: `add(item)`, `remove()`, `peek()`, `isEmpty()`
- Probably best implemented with a doubly linked list with a head and tail pointer. Dequeue moves head back and returns, enqueue adds node at end.

#
## Strengths and Weaknesses

**Strengths**:
- Fast operations - constant time in all major operations
- Good for powerful operations (DFS of graph, traverse tree, reverse linked list)

**Weaknesses**:
- Not adequate data structure for lookup

#
## Example uses
- Breadth-first search
- Printers managing jobs
- Web servers for managing requests
- Process scheduling for a CPU
- Implementing cache

#
## Resources
- https://www.interviewcake.com/concept/python/queue
- 

#