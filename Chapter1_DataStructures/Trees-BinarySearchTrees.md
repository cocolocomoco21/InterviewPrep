# Binary Search Trees
## Overview

Binary search trees (BSTs) are binary trees where, for every node, every left child is less than or equal to the current node, and every right child is greater than the current node.

`all left descendents <= n < all right descendents`

Note that this inequality must be true for all of a node's descendents, not just its immediate children.

There is no order or shape guarantee for a BST - it simply must uphold the above rule. As such, in the worst case for complexity, it can be a contiguous string of nodes with no branches. In the best case, it can be a full tree.

#
## More Details and Definitions
Example graph:
```
                50
              /   \
            16      69
           /       /  \
         15      56     87
                /     /   \ 
               55    72    98
              / 
             52  
```
- **Binary search tree** - binary tree where all nodes are in a specific order: for any given node n, all left descendents are <= n, and all right descendents are > n
    - AKA: `left descendents <= n < right descendents`
    - Example: 52 is less than 69, 56, and 55, but is larger than 50, so it is placed right of 50 but left of the others

#
## Algorithms for Operations (Lookup, Insert, and Delete)
- **Lookup(K key)**: 
    - Start at root of tree and determine whether value we are looking for is 1) in the root, 2) in the left subtree, or 3) in the right subtree. 
    - The base cases are 1) if tree is empty return false, and 2) if value is in root return true.
    - Otherwise, recur down appropriate subtree, comparing the lookup value to the value in the current node. If smaller, recur down right subtree; if larger, recur down right.
    - Continue until either the key is found and return true, or until you've iterated to the current node being null, and return false.
- **Insert(K key)**:
    - Starting at root, if null, return new node.
    - Determine which subtree the value should be inserted in (similarly to `lookup()`), and recur using this method until reaching a leaf (aka current node is null).
    - During each recursive call to `insert()`, nest this within a `.setLeft(node)` or `.setRight(node)` call to allow this recursion to flow back up.
        - E.g. `n.setLeft(insert(n.getLeft(), key))` when key should be inserted on left. Base case is when node is null, and insert there.
- **Delete()**:
    - Generally, from root, recur down until you find the node. If not found, return null and the tree is left the same. If found, there are three cases: 
        1) node being deleted has no children
        2) node being deleted has one child
        3) node being deleted has two children
    - For case (1), just return null. The recursive call will then set the parent's child to null, effectively deleting the node
    - For case (2), just set parent's child to current node's child
    - For case (3):
        - Need to find a value to replace the current node. This is either a root (full tree) or a subtree, but either way, the logic is the same. Let's call the top node the root.
        - To uphold the BST rule (for each node, all left are smaller and all right are greater), we choose one of the middle-most leaves. That is, the smallest greater than element (leftmost after initially chosing the right subtree) or the greatest less than element (rightmost after initially chosing the left subtree). Let's choose the inorder successor (the smallest larger-than value).
        - Once inorder successor is found, set the root to this value.
        - Now, call `delete(root.rightChild, smallestValue)`. This will be recursive and will delete the previous inorder successor value. If this value has two children, the algorithm again recursively deletes (updates the value with the new inorder successor, recursively calls `delete()`. Therefore, the BST remains valid.
```
              50                            60
           /     \         delete(50)      /   \
          40      70       --------->    40    70 
                 /  \                         /  \ 
                60   80                     65    80
                 \
                  65
```

#
## Time Complexity (worst case) | Binary Search Tree
**Insertion**: O(n). O(log n) if balanced.

Following the same logic as Search/lookup (below), in the worst case, the node will be inserted into the end of a contiguous line of nodes. In the best case, it will be inserted into a complete BST.

**Deletion**: O(n). O(log n) if balanced.

If the node to be deleted just has zero or one children, the deletion process just has to navigate down to the node once. This is therefore proportional to the height of the tree. So O(n) worst case, with O(log n) if balanced.

In the case of deleting a node with two children, the process must navigate to that node, navigiate all the way to the smallest node, then after setting the deleted node to that value, navigate all the way down to that node. Although this is a lot of work, the two constant iterations don't matter, and the entire delete process for all three steps is worst case O(n) with O(log n) if balanced.    

**Search (to find if element exists)/Lookup**: O(n). O(log n) if balanced.

In the worst case, a binary search tree is a direct shot down and is not full at all. In this case, it is O(height of tree), so O(n). If the BST is balanced, it's O(log n).

#
## Space Complexity
O(n) to house all n elements.

#
## Distinguishing Features
- One rule for BST: left subtree must always contain elements less than the current node, and right subtree must always contain elements greater than the current node, for all subtrees within the tree. 
-  Not necessarily full (zero or two children for all), complete (full except last level), perfect (full and complete), or balanced (equally distributed nodes). This leads to a tricky O(n) worst case complexity in the case of a tree which is straight down vertically, in a line. Unless balanced, we cannot say O(logn).
- If you add specific rules in to a BST to ensure the BST is balanced (e.g. Red-Black trees), you can transform then into having O(logn) lookup, insert, and delete.
- Order data hierarchically rather than linearly. Good for searching

#
## Strengths and Weaknesses

**Strengths**:
- Good performance across the board (if balanced).  
    - Lookup is the same as sorted array (O(logn)), but insert and delete are faster (O(logn) vs O(n))
    - If tree is reasonably balanced (more full than linear), insert, lookup, and delete are all O(log n).
- BSTs are sorted
    - Can get sorted order by O(n) using in-order traversal
    - Can find element closest to a value in O(logn), if balanced

**Weaknesses**:
- Poor performance if unbalanced. If unbalanced, operations become O(n)
- No O(1) operations. BST is never fastest at anything

#
## Example uses
- Red-black trees (balanced BST), guarantees O(logn)
- AVL trees, 2-4 trees, B trees (also balanced BSTs), guarantee O(logn)
- Searching hierarchical data

#
## Resources
- https://www.interviewcake.com/concept/python/binary-search-tree
- https://www.interviewcake.com/concept/python/tree
- https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
- https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/

#