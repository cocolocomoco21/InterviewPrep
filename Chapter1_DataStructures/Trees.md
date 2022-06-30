# Trees
## Overview

Trees provide a non-linear data structure to represent data in a hierarchical format. Using nodes to contain data and pointers to children nodes, trees start at the root and cascade downward through children nodes (their parent nodes point to them), until the leaves, meaning the nodes with no children nodes, are found at the bottom of the tree.

## More Details and Definitions
- **Binary tree** - tree where all nodes have either 0, 1, or 2 children. No more than two are allowed.
- **Binary search tree** - binary tree where all nodes are in a specific order: for any given node n, all left descendents are <= n, and all right descendents are > n. 
    - AKA: _left descendents <= n < right descendents_
- **Balanced vs. Unbalanced**
    - **Complete binary tree** - tree is completely full, when working top down and from left to right. I.e. if any nodes are not present, it is working left to right on the leaf nodes.
    - **Full binary tree** - all nodes have two children, or zero children.
    - **Perfect binary tree** - full and complete binary tree.

## Binary Tree Traversal
Example graph:

                        A
                    /       \
                B               C
            /               /       \
        D               E               F
                            \       /       \ 
                               G H              I

- **Pre-order** - visit current node before child nodes. Once visited current node, visit child nodes left to right (aka perform a recursive pre-order).
    - A B D C E G F H I
- **Post-order** - visit current node after child nodes. Once visited all child nodes left to right (aka perform a recursive post-order), visit root
    - D B G E H I F C A
- **Level-order** - visit current node (or root), then all nodes "1 level away" (depth 2), then "2 levels away" (depth 3). (Essentially same mechanism as Breadth-First Search)
    - A B C D E F G H I 
- **In-order** - visit left branch, then current node, then right branch. Do this recursively.
    - D B A E G C H F I


# Binary Search Tree
## Overview
Binary tree where all nodes are in a specific order: for any given node n, all left descendents are <= n, and all right descendents are > n. That is, the only rule is:

    left descendents <= n < right descendents

There is no order or shape guarantee for a BST - it simply must uphold the above rule. As such, in the worst case for complexity, it can be a contiguous string of nodes with no branches. In the best case, it can be a full tree.

## Lookup and Insert Algorithms
- **Lookup(K key)**: 
    - Start at root of tree and determine whether value we are looking for is 1) in the root, 2) in the left subtree, or 3) in the right subtree. 
    - The base cases are 1) if tree is empty return false, and 2) if value is in root return true.
    - Otherwise, recur down appropriate subtree, comparing the lookup value to the value in the current node. If smaller, recur down right subtree; if larger, recur down right.
    - Continue until either the key is found and return true, or until you've iterated to the current node being null, and return false.
- **Insert()**:
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
        - To uphold the BST rule (for each node, all left are smaller and all right are greater), we choose one of the middle-most leaves. That is, the smallest greater than element (leftmost after initially chosing the right subtree) or the greatest less than element (rightmost after initially chosing the left subtree).
        - Swap this value with the root.
        - Now, recursively call `delete(n.{whatever side you moved the value up from}, smallestValue)`. This will delete the previous value and the BST remains valid.

## Time Complexity (worst case) | Binary Search Tree
**Insertion**: O(n). O(log n) average case.

Following the same logic as Search/lookup (below), in the worst case, the node will be inserted into the end of a contiguous line of nodes. In the best case, it will be inserted into a full BST.

**Deletion**: O(n). O(log n) average case.

If the node to be deleted just has zero or one children, the deletion process just has to navigate down to the node once. This is therefore proportional to the height of the tree. So O(n) worst case, with O(log n) average case.

In the case of deleting a node with two children, the process must navigate to that node, navigiate all the way to the smallest node, then after setting the deleted node to that value, navigate all the way down to that node. Although this is a lot of work, the two constant iterations don't matter, and the entire delete process for all three steps is worst case O(n) with O(log n) average case.    

**Search (to find if element exists)/lookup()**: O(n). O(log n) average case.

In the worst case, a binary search tree is a direct shot down and is not full at all. In this case, it is O(height of tree), so O(n). The average case, however, is roughly O(log n).

#
## Space Complexity

#
## Distinguishing Features
- One rule for BST: left subtree must always contain elements less than the current node, and right subtree must always contain elements greater than the current node, for all subtrees within the tree. 
-  Not necessarily full (zero or two children for all), complete (full except last level), or perfect (full and complete). This leads to a tricky O(n) worst case complexity in the case of a tree which is straight down vertically, in a line.
- Advantage: if tree is reasonably balanced (more full than linear), insert, lookup, and delete are all O(log n). Opposed to linked list, where lookup can be O(1), but lookup and delete are O(n).
- Red-Black trees - guaranteed to have O(log n) lookup, insert, and delete. This is because it uses a whole lot of rules which guarantee balance, which is average case for any tree (hence why O(log n) but worst case O(n)).
    - Other trees that guarantee O(log n): AVL trees, 2-4 trees, B trees

#
## Example uses
- 
- 

#
## Resources
- 
- 

#