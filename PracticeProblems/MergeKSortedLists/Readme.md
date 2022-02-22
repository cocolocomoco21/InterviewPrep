### Problem
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order. Merge all the 
linked-lists into one sorted linked-list and return it.

```
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
```

### Approach

Approach 1 (Solution class | original solution submitted - cleaner and faster): 

Use a min heap, add all items into the min heap in one iteration. Then re-populate the linked list by polling the heap 
continually. Don't forget to set the last node's next to null


Approach 2 (SolutionII class | experimental solution to avoid memory cost of approach #1):

Use a map to map the value of a node to the linked list node itself. Since the minimum values of each linked list are at
the beginning, we can add them all to a map and iterate from the min val to the max potential value (10000 - this could
be optimized). When the index has an entry in the map, add it to the final linked list, and add its "next" value into 
the map. Maintain the map by removing the entry if the list of nodes is empty, and remove the node.
