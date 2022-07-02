# Binary Trees
## Overview

Binary trees are trees where every node has at most two children.

## More Details and Definitions
- **Binary tree** - tree where all nodes have either 0, 1, or 2 children. No more than two are allowed.
```
                A
              /   \
            B       C
           /       /  \
         D        E     F
                 /    /   \ 
                G    H     I
              / 
             J  
```

- **Full binary tree** - all nodes have two children, or zero children
```            
              A
            /   \
          B       C
                 /  \
                D     E
```
- **Complete binary tree** - tree is completely full when working top-down, left to right. I.e. if any nodes are not present, they are on the last level, and nodes are filled left to right.
```            
              A
            /   \
          B       C
        /  \     /
       D    E   F
```
- **Perfect binary tree** - full and complete binary tree. That is, adding a new node increases the tree's height.
```            
              A
            /   \
          B       C
        /  \     /  \
       D    E   F    G
```
- **Balanced binary tree** - a tree whose height is small relative to the number of nodes it has (roughly O(logn)) . "Balanced" really means more like "not terribly imbalanced." A balanced tree "looks full."
```            
              A    (balanced)                A     (imbalanced)
            /   \                          /   \
          B      C         vs.          B       C
        /  \    /                                \
       D    E  F                                  D
                                                   \
                                                    E
```

## Binary Tree Traversal
Example graph:
 ```
                A
              /   \
            B       C
           /       /  \
         D        E     F
                 /    /   \ 
                G    H     I
              / 
             J  
```
- **Pre-order** - visit current node before child nodes. Once visited current node, visit child nodes left to right (aka perform a recursive pre-order). Usually visits nodes in same order as DFS.
    - A B D C E G J F H I
- **Post-order** - visit current node after child nodes. Once visited all child nodes left to right (aka perform a recursive post-order), visit root.
    - D B J G E H I F C A
- **In-order** - visit left branch, then current node, then right branch. Do this recursively. Called "in-order" due to visiting nodes in ascending order for a BST.
    - D B A J G E C H F I
- **Level-order** - visit current node (or root), then all nodes "1 level away" (depth 2), then "2 levels away" (depth 3). (Essentially same mechanism as Breadth-First Search)
    - A B C D E F G H I J

#
## Time Complexity (worst case) | Binary Tree
**Note**: we don't specify binary _search_ tree here, just binary tree. Therefore we can't assume any shape or ordering benefits that BSTs provide. Time complexity is likely more useful and practical to know for binary search trees, since they're built for operational optimzation and would be used in practice, but we'll include it here for reference.

**Insertion**: O(n)

In the worst case, a binary search tree is a direct shot down and is not full at all. In this worst case, the node will be inserted as a leaf into the end of a contiguous line of nodes. Inserting at the end is O(height of tree), so O(n). (in the best case, it will be inserted into a full BST (O(logn)), but here we're talking binary trees, not BSTs)

**Deletion (at specific)**: O(n)

In the worst case, we have to traverse all elements to find the item to delete. Therefore, worst case is O(n).

**Search (to find if element exists)/Lookup**: O(n)

Similar to insert, in the worst case, a binary tree is a direct shot down and is not full at all. We must do a full breadth-first search, so O(n).

#
## Space Complexity
O(n) to hold all n elements. Nodes just point to children so there is no wasted memory.

#
## Distinguishing Features
- Enable hierarchical data storage. Can represent data and relationships between them
- Contains nodes and edges, rather than table (array) or linear (linked list) representation
- Enables search quicker than a linear data structure (e.g. BST = O(logn), linked list = O(n))
- No allocation issues, since nodes have pointers and are not allocated in memory block

#
## Example uses
- Binary search tree
- Decision tree
- Heaps
- Routing trees for network traffic

#
## Resources
- https://www.interviewcake.com/concept/python/tree
- 

#