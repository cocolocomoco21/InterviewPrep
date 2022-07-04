# Breadth-First Search
## Overview

Breadth-first search is a method for exploring a tree or graph where you prioritize exploring breadth instead of depth (hence _breadth_-first). You explore all nodes one step away, then two steps away, etc.

## Typical Use-Case

Exploring tree or graph:
- Finding the shortest path between two nodes in a graph
- Find all nodes reachable from start node (both BFS and DFS)
- If tree, level-order traversal
- Find shortest distance in unweighted graph (add distance field to each node, when enqueuing, set node's distance to current node + 1)
- Searching for vertices which are closer to the source

#
## Algorithms

Create a queue to track the "next-to-be-visited" nodes. Mark the first node as visited and add it to the queue.

While the queue is not empty, pop off the next node to be visited. For each neighbor of this node, if it is unvisited, mark as visited and add to queue.

The algorithm will visit all of a node's neighbors first, since they are all added to the queue, rather than visiting the neighbors of a neighbor first (i.e. DFS).

## Psuedocode

```
bfs(node) {
    queue = new Queue()

    node.visited = true
    queue.enqueue(node)

    while (!queue.isEmpty())
        currNode = queue.dequeue()
        for (child : currNode.children)
            if (!child.isVisited)
                child.visited = true
                queue.enqueue(child)
}
```

## Ilustration

Breadth-first search:

![Breadth-first search](https://upload.wikimedia.org/wikipedia/commons/4/46/Animated_BFS.gif?20070330182553)

BFS vs. DFS:

![BFS vs. DFS](https://miro.medium.com/max/1280/1*GT9oSo0agIeIj6nTg3jFEA.gif)

#
## Time Complexity
**Worst/best/average case**: O(V + E), where V = number of vertices, E = number of edges (for adjacency list)

The while loop in the algorithm runs V times, for each vertex (node) in the graph once, so O(V).

The for loops (iterating over all children/neighbors for each vertex) takes a total of O(E), since you must scan for all adjacent vertices (e.g. in an adjacency list).

So O(V + E).

#
## Space Complexity
**Memory**: O(V), where V = number of vertices (for adjacency list)

You must make an additional queue to track which vertices will be visited next. This must be the number of vertices to not require additional expansions (e.g. if one node is connected to every other node).

#
## Distinguishing Features
- Uses a queue, is iterative (rather than recursion like DFS) - queue holds "nodes to be visisted"
- Simple yet fast

#
## Strengths and Weaknesses

**Strengths**:
- BFS will find the shortest path between a starting and any other reachable node. DFS will not necessarily find shortest
- Searching for vertices which are closer to the source

**Weaknesses**:
- BFS on a binary tree _generally_ requires more memory than DFS

#
## Example uses
- Find shortest path between two nodes in graph
- BFS is just Dijkstra's algorithm with all edge weights equal to 1 

#
## Resources
- https://pages.cs.wisc.edu/~skrentny/cs367-common/readings/Graphs/#bfs
- https://www.interviewcake.com/concept/java/bfs
- https://stackoverflow.com/questions/26549140/breadth-first-search-time-complexity-analysis
- https://stackoverflow.com/a/27519276
- https://www.geeksforgeeks.org/difference-between-bfs-and-dfs/

#