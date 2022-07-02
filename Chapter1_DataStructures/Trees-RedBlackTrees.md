# Red Black Trees
## Overview

Red-black trees are self-balancing binary search trees which provide good complexity across many operations.

Each node has an extra bit to represent color (red or black), and there are 5 rules to uphold balance. This balance provides worst case O(logn) search, insert, and delete, which is the defining attribute of a red-black tree (and all self-balancing trees). 

Being a balanced binary search tree, red-black trees also uphold requirements for BSTs.

#
## More Details and Definitions
Example graph:
```
        Without sentinel nodes:          With sentinel nodes:    

                B                                B
              /   \                            /    \
            B       r                       B         r
          /       /   \                   /  \       /   \
         r       B     B                r   NULL    B       B
                     /   \            /   \       /  \     /   \
                    r     r        NULL NULL   NULL NULL  r     r
                                                        /  \   /   \
                                                     NULL NULL NULL NULL
```
Graph on left:
- **Rules for red-black trees** (simplified?):
1) Every node has a color: red or black
2) **Root property**: the root is always black
3) **Red property**: The children of a red node are black
4) **Black property**: For each node with at least one null child, the number of black nodes on the path from the root to the null child is the same

Graph on right, with "sentinel" nodes (aka NULL leaf nodes):
- **Rules for red-black trees**:
1) Every node has a color: red or black
2) The root is always black
3) There are no adjacent red nodes (the children of a red node are both black)
4) Every path from a node to a descendent leaf (NULL) node contains the same number of black nodes
5) All leaf (NULL) nodes are black nodes 


Features:
- When the tree is modified, the new tree is rearranged and "repainted" to restore coloring properties to ensure balance

#
## Algorithms for Operations (Lookup, Insert, and Delete)
- **Lookup(K key)**: 
    - Since red-black tree is balanced BST, it has BST rules. Just use <= and > conditional checks to find if element exists.
- **Insert(K key)**:
    - TODO. Truncated nodes below, but refer to references at bottom for full algorithm.
    - Gist: goal is to insert key into tree, maintaining red-black tree properties. `insert` method initially performs the same `insert` as BST, but then must perform steps to restore the red-black properties (rotations, restructuring, recoloring, etc).
- **Delete()**:
    - TODO. Truncated nodes below, but refer to references at bottom for full algorithm.
    - Gist: "more complicated than insert, so not included in these notes" - UW notes below. I won't include them either.

#
## Time Complexity (worst case) | Binary Search Tree
**Insertion**: O(logn)

Due to the properties of a red-black tree and the algorithm to maintain them and its self-balance, red-black tree insertion is O(logn).

**Deletion**: O(log n)

Due to the properties of a red-black tree and the algorithm to maintain them and its self-balance, red-black tree deletion is O(logn).

**Search (to find if element exists)/Lookup**: O(log n)

Red-black tree lookup functions the same as a BST lookup. Therefore, O(logn) since we guarantee the tree is balanced.

#
## Space Complexity
O(n) to house all n elements. There is one extra bit per node, but this is shown to not have an affect on the space compared to other trees.

#
## Distinguishing Features
- O(logn) operations: since red-black trees are self-balancing, they always have height logn. This ensures all operations (search, insert, delete) are O(logn).
- Set of rules (above) for preserving shape. This is unique to red-black trees to ensure they are self-balancing

#
## Strengths and Weaknesses

**Strengths**:
- O(logn) insert, delete, search operations

**Weaknesses**:
- Complicated insert and delete algorithms with various cases for each operation

#
## Example uses
- Trees where you want O(logn) operations. 
- "If application involves frequent insertions and deletions, red-black trees are preferred. If insertions and deletions are less frequent and search is a more frequent operation, then AVL trees should be preferred"
    - AVL are more balanced than red-black trees
- Most self-balancing BST library functions (e.g. TreeMap, TreeSet in Java) use red-black trees
- CPU scheduling linux
- K-means clustering algorithm
- MySQL for indexes on tables to reduce searching and complexity time


#
## Resources
- https://pages.cs.wisc.edu/~skrentny/cs367-common/readings/Red-Black-Trees/
- https://www.cs.auckland.ac.nz/software/AlgAnim/red_black.html
- https://www.geeksforgeeks.org/red-black-tree-set-1-introduction-2/
- https://en.wikipedia.org/wiki/Red%E2%80%93black_tree



#