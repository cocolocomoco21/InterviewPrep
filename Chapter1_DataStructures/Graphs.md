# Graphs
## Overview

Graphs organize data in an interconnected network of nodes and edges. 

Graphs are a generalization of trees. A tree is a type of graph, but not all graphs are trees. Simply put, a tree is a graph with no cycles.

A graph is simply a collection of nodes with edges between (some of) them. Nodes in a graph can have any number of nodes coming in or out of them and can connect with any other node.

## More Details and Definitions
Example graph:
```
        Graph 1                 Graph 2             Graph 3             Graph 4           Graph 5

            E1                                                                                E1
      (A)-------(B)         (A)-------->(B)      (A)----->(B)         (A)-------(B)      (A)---4---(B)
       |  \      |           ^                    ^      /             | \     / |
     E4|    \ E2 | E3        |                    |     /              |   \ /   |            E2
       |      \  |           |                    |    /               |   / \   |       (C)---7---(D)
      (C)-------(D)         (C)                  (C)<-/                | /     \ |
            E5                                                        (C)-------(D)
```

Terminology:
- **Node**: similar to node in tree, also called vertex
    - Example: A, B, C, D (Graph 1)
- **Edge**: connects nodes together, also called arcs
    - Example: E1, E2, E3, E4, E5 (Graph 1)
- **Path** - a specified route on a graph
    - Example: C -> A -> B, or simply CAB (Graph 2)
- There are two kinds of graphs:
    - **Directed graph**: edges point from a node at one end to a node at the other end. Directed graphs have arrows as edges and paths can only go from node to node following the direction of the arrows.
        - Example: Graph 2, Graph 3
    - **Undirected graph**: edges do not have arrows and graph is bi-directional. Edges simply connect the nodes at each end and paths can go in both directions.
        - Example: Graph 1
- **Cycle**: an unbroken series of nodes with no repeating nodes or edges, or when a path exists where a node can be reached twice. Basically, "does it have a loop?"
    - **Cyclic graph**: there is a cycle on the graph
        - Example: Graph 1, Graph 3
    - **Acyclic graph**: the graph has no cycles
        - Example: Graph 2
- **Weight**: an edge has a value, signifying the "weight" of this path
    - **Weighted graph**: graph where edges have a value associated with them
        - Example: Graph 5, where weights are E1 = 4, E2 = 7
    - **Unweighted graph**: graph does not have edges with weights/values
        - Example: Graph 1, Graph 2, Graph 3, Graph 4
- **Coloring**: assign colors to each node in a graph
    - **Legal coloring**: no adjacent nodes have the same color
        - Example: refer to InterviewCake link below
- Special kinds of graphs:
    - **Directed Acyclic Graph (DAG)**: directed graph that contains no cycles
        - Example: Graph 2
    - **Complete graph**: undirected graph with an edge between every pair of nodes. Every node is each other node's neighbor.
        - Example; Graph 4
    - **Connected graph**: undirected graph has a path from every node to another node. There are no "islands"
        - Example: Graph 1, Graph 4. Not Graph 2 or Graph 3 because directed, and not Graph 5 because not connected.

#
## Representing Graphs in Programming
There are different ways to store and represent graphs. 

Example graph:
```
      (3)-------(1)------(0)
          \      | 
            \    | 
              \  | 
               (2)
```

**Edge list**:
- A list of all edges in the graph
    - Example: `graph = [[0, 1], [1, 2], [1, 3], [2,3]]`
- This fails if a node has no edges - can be useful to pair with list of nodes

**Adjacency list** :
- A list where the index represents the node and the value at that index is a list of the node's neighbors
    - Example: 
        ```
        graph = [
            [1],
            [0, 2, 3],
            [1, 3],
            [1, 2],
        ]
         ```
        Here, index 0 corresponds to node 0. Node 0 has neighbor node 1, so `graph[0] = [1]`. Node 1 (index 1) has neighbor nodes 0, 2, and 3, so `graph[1] = [0, 2, 3]`, etc.
- Alternatively, you can use a complex class for Graph/Node:
    - Every node stores a list of adjacent nodes
        - Directed graph: the current node represents the source, and the list represents targets
        - Undirected graph: there will be duplication between neighbors, i.e. the edge `(a, b)` will appear in `a`'s children list, as well as `b`'s children list
    - ```
        class Graph {
            public Node[] nodes;
        }

        class Node {
            public String name;
            public Node[] children;
        }
      ```
- Can use array/hash table/dictionary
    - Map node to list of neighbors
    - Useful if nodes are represented by strings, objects, or something that doesn't map cleanly to a list index
    - "Typically use simple Graph and Node classes unless compelling reason not to" - CtCI
    - Example:
        ```
        graph = {
            0: [1],
            1: [0, 2, 3],
            2: [1, 3],
            3: [1, 2],
        }
         ```

**Adjacency Matrix**:
- Matrix representing if node `i` connects to node `j`
    - Element at `[i][j]` represents the presence/absence of an edge from node `i` to node `j`.
        - True (or 1) means there is an edge between `i` and `j`; false (or 0) represents there is no edge
        - N = number of nodes
    - Example:
        ```
        graph = [
            [false, true, false, false],
            [true, false, true, true],
            [false, true, false, true],
            [false, true, true, false],
        ]
        ```
        or 
        ```
        graph = [
            [0, 1, 0, 0],
            [1, 0, 1, 1],
            [0, 1, 0, 1],
            [0, 1, 1, 0],
        ]
        ```
- Directed graph: keep one axis as source, one as target. Not necessarily symmestrical.
- Undirected graph: will be symmetrical
- Same algorithms that are used on adjacency lists (e.g. BFS) can be used on adjacency matrices, but may be less efficient due to having to iterate through all nodes to identify a given neighbor's nodes.

#
## Algorithms for Operations (Lookup, Insert, and Delete)
**Searching/Lookup**: two most common are depth-first search (DFS) and breadth-first search (BFS)
- DFS: start at root (or arbitrary node) and explore each branch completely before moving to next branch. Go _deep_ first (hence _depth_-first search).
    - Use-case: preferred if we want to visit every node in the graph (simpler than BFS)
    - Algorithm: visit node `a`, then iterate through node `a`'s neighbors. When visiting node `b` (that's neighbor of `a`), visit all of `b`'s neighbors before going to `a`'s other neighbors. Keep track of visited!
        - This is like pre-order tree traversal, but for graphs, key difference is that you must keep track of visited, otherwise the algorithm will infinite loop. Can be done by flag on each Node object or a set of visited nodes (if unique names, and depending on problem).
- BFS: start at root (or arbitrary node) and explore each neighbor before going on to any children. Go _wide_ first (hence _breadth_-first search).
    - Use-case: find shortest path (or any path)between two nodes
    - Stays "as close" to the root for as long as possible
    - Algorithm: Node `a` visits each of `a`'s neighbors before visiting any of their neighbors. This is iterative, using a queue, NOT recursive. Basically: mark root as visited and enqueue root. While the queue is not empty, dequeue node and visit that node. Then, for each child of that node, if not marked (aka added to queue), mark and add to queue.
        - Note: we could potentially keep a set to track visited nodes, or just have a flag (`n.marked`) on each node for if it's been added already or not.
- Bidirectional search: used to find shortest path between source and destination node. Basically run two simultaneous BFSs from each node and when their searches collide, we've found a path.
    - If node has `k` adjacent nodes and the shortest paths from node `s` and `t` are length `d`, then we experience `k` nodes for first "level" of BFS, `k` nodes for second level (now `k^2`), and since length is `d`, we'd do this `d` times for O(`k^d`) nodes.
    - For bidirectional, we have two searches collide after `d/2` levels (midpoint). `s` which visits approximately `k^(d/2)` nodes and so does `t`. That's `2k^(d/2)`, or O(`k^(d/2)`) nodes total, which is the square root of how long simple BFS takes.

#
## Time Complexity (worst case)
TODO

**Access (at a given location)**: 

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
TODO

#
## Distinguishing Features
- Generalized trees
- Can pictorally represent a real-world problem, and then mathematically be solved for optimizations.
- Trees but with less rules - any node can connect to any node
- Edges can have weight, signifying the "cost" of taking that path
- Graphs can be directed to show a one-way relationship between nodes

#
## Strengths and Weaknesses
**Strengths**:
- Representing links - great when working with things that connect to other things

**Weaknesses**:
- Scaling challenges - most graph algorithms are O(nlogn) or even slower. Depending on size of graph, running algorithms across nodes may not be feasible.

#
## Example uses
- Network arrangements (e.g. cities and flights, social network, computer network structure, etc.)
- Flow charts
- State diagrams/tasks to be done
- Routers and ethernet cables
- Travelling salesman problem

#
## Resources
- https://pages.cs.wisc.edu/~skrentny/cs367-common/readings/Graphs/
- https://www.interviewcake.com/concept/python/graph?

#