# Trees
## Overview

Trees provide a non-linear data structure to represent data in a hierarchical format.

Trees use nodes to contain data and pointers to zero or more children nodes. Trees start at the root and cascade downward through children nodes. When a node has no further children, it is considered a leaf node, found at the "bottom" of the tree.

## More Details and Definitions
Example graph:

                        A
                    /   |   \
                B       C      D
            /               /  |  \
        E                 F    G   H     
                        /   \     /  \ 
                       I     J   K    L 
                       |     |        
                       M     N
                       |
                       O


- **Node** - contain data and pointers to zero or more children. "Guts" of a tree
    - Example: Nodes A through O
- **Root** - top node in a tree
- **Leaf node** - node which has no more children, or a node at the bottom of the tree
    - Example: Nodes C, E, G, K, L, N, O
- **Depth** - number of links from the root to a given node
    - Example: Node O has depth 5, J has depth 3, C has depth 1, A has depth 0, etc.
- **Height** - the largest depth of a tree, or the number of links to the furthest leaf
    - Example: height = 5, due to depth of node O

#
## Time Complexity (worst case) | Binary Search Tree
Depends on specific tree type. Refer to subsequent sections for specific types of trees and their complexities.

#
## Space Complexity
Depends on specific tree type. Refer to subsequent sections for specific types of trees and their complexities.

#
## Distinguishing Features
- Enable hierarchical data storage. Can represent data and relationships between them
- Contains nodes and edges, rather than table (array) or linear (linked list) representation
- Enables search quicker than a linear data structure (e.g. BST = O(logn), linked list = O(n))
- No allocation issues, since nodes have pointers and are not allocated in memory block

#
## Example uses
- File systems
- Comments
- Family trees (genealogy)
- Database indexing
- Heap

#
## Resources
- https://www.interviewcake.com/concept/python/tree
- https://www.geeksforgeeks.org/applications-of-tree-data-structure/

#