# Graphs
## Overview

Graphs are a generalization of trees. Containing nodes and edges, they are similar to tree. However, nodes in a graph can have any number of nodes coming in or out of them. 

## More Details and Definitions
A lot of the terminology is self-explanatory and I've covered it before, so this list may not be comprehensive.
- There are two kinds of graphs:
    - **Directed** graphs have arrows as edges.
    - **Undirected** graphs have no direction.
- **Path** - a given route on a graph.
- Cycles in graphs - when a path exists where a node can be reached twice. 
    - **Cyclic** graph - there is a cycle on the graph.
    - **Acyclic** graph - the graph has no cycles. 
- **DAG (Directed Acyclic Graph)** - directed graph that contains no cycles.
- **Complete** graph - undirected graph with an edge between every pair of nodes.
- **Weighted** graph - graph where edges have a value associated with them.
- **Connected** graph - undirected graph has a path from every node to another node. There are no "islands".

## Representing Graphs in Programming
Adjacency List:
- Every vertex (node) stores a list of adjacent vertices.
    - Directed graph: the current node represents the source, and the list represents targets.
    - Undirected graph: the list will be duplicated. I.e. `(a, b)` will appear in `a`'s list, as well as `b`'s list.
- Can use array/hash table, but typically use simple Graph, Node classes.

Adjacency Matrix:
- NxN (N = number of nodes) matrix where true at `[i][j]` represents an edge from node `i` to node `j`.
    - Directed: keep one axis as source, one as target. Not necessarily symmestrical.
    - Undirected graph: will be symmetrical.

#
## Time Complexity (worst case)
**Access (at a given location)**: {val}

{explanation}

**Insertion**: {val}

{explanation}

**Deletion**: {val}

{explanation}

**Search (to find if element exists)**: {val}

- **Depth-first search** - graph traversal that favors depth over breadth. Visit one child, it's immediate children, recursively. Aka drill down (deep) on one child, its child, its child, etc. until you get to a leaf. Then return and visit the parents next child, etc.
    - Pre-order traversal
    - Visit a node, mark as visited. For each child/adjacent node, visit (pre-order). Stack not required, but can add "to-visit" nodes to the stack.

- **Breadth-first search** - graph traversal that favors breadth over depth. Visit one node, then all of its children. Once all children have been visited, visit the next "level" of children.
    - Level-order traversal
    - Visit a node, add its children to a queue. Pop node off queue, add its children to queue, and repeat.
#
## Space Complexity

#
## Distinguishing Features
- Generalized trees.
- Can pictorally represent a real-world problem, and then mathematically be solved for optimizations.

#
## Example uses
- Network arrangements (e.g. cities and flights, computer network structure)
- Flow charts
- State diagrams/tasks to be done

#
## Resources
- 
- 

#