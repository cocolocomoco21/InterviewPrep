# Depth-First Search
## Overview

Depth-first search is a method for exploring a tree or graph where you prioritizing exploring as deep as possible first instead of going wide (hence _depth_-first). You explore as deep as possible down one path before backing up and trying a different one.

## Typical Use-Case

Exploring tree or graph:
- Find all nodes reachable from start node (both BFS and DFS)
- Path detection (UW notes below)
- Cycle detection (UW notes below)
- Topological numbering (UW notes below)

#
## Algorithms

Start at some node `n`, then follow an edge out of `n` to a new node, then another edge out of that node to another new node, etc., getting as far away from `n` as possible before visiting any more of `n`'s successors.

To prevent infinite loops with cycles, we must keep track of which nodes have been visited. This can be done by marking a flag on the node or keeping a separate set/array/map of visited nodes.

Basic algorithm:
1. Mark `n` as visited
2. Recursively do a DFS on all of `n`'s unvisited sucessors

## Psuedocode

```
dfs(node) {
    node.visited = true
    for (child : currNode.children)
        if (!child.isVisited)
            dfs(child)
}
```

## Ilustration

Depth-first search:

![Depth-first search](https://upload.wikimedia.org/wikipedia/commons/7/7f/Depth-First-Search.gif)

DFS vs. BFS:

![DFS vs. BFS](https://miro.medium.com/max/1280/1*GT9oSo0agIeIj6nTg3jFEA.gif)

#
## Time Complexity
**Worst/best/average case**: O(V + E), where V = number of vertices, E = number of edges (for adjacency list)

DFS visits each vertex (node) in the graph once, so O(V).

The for loops (iterating over all children/neighbors for each vertex) takes a total of O(E), since you must scan for all adjacent vertices (e.g. in an adjacency list).

So O(V + E).

#
## Space Complexity
**Memory**: O(h), where h = height of tree

You must simply keep track of the current recursive call stack, so the space complexity is just the longest depth (aka height) of the tree, so O(h).

#
## Distinguishing Features
- Uses recursion and is very simple/intuitive to write
- Simple yet fast

#
## Strengths and Weaknesses

**Strengths**:
- DFS on a binary tree _generally_ requires less memory than BFS
- DFS can be easily implemented with recursion 
- Decision trees for gaming/puzzles - if this decision leads to victory, we stop

**Weaknesses**:
- Doesn't necessarily find shortest path to a node, while BFS does

#
## Example uses
- Find shortest path between two nodes in graph
- BFS is just Dijkstra's algorithm with all edge weights equal to 1 

#
## Resources
- https://pages.cs.wisc.edu/~skrentny/cs367-common/readings/Graphs/#dfs
- https://www.interviewcake.com/concept/java/dfs
- https://stackoverflow.com/questions/26549140/breadth-first-search-time-complexity-analysis
- https://stackoverflow.com/a/27519276
- https://www.geeksforgeeks.org/difference-between-bfs-and-dfs/
- https://www.quora.com/What-would-be-the-space-complexity-of-DFS-Depth-First-Search

#