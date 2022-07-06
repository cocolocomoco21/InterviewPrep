# Topological Sort
## Overview

Topological sorts of a directed graph are a way of ordering the list of nodes such that if `(a, b)` is an edge in the graph, then `a` will appear before `b`.

If a graph has cycles or is not directed, then there is no topological sort.

## Typical Use-Case

Graph problems with dependencies or prerequesites (e.g. dependency resolution, parts on an assembly line course schedule). Directed graphs. 

#
## Algorithm

1. Identify all nodes with no incoming edges and add those to our topological sort
    - We know they're safe to add since they hve nothing that needs to combe before. Get them over with
    - We know that such a node must exist if there's no cycle
2. When we do the above, remove each node's output edges from the graph
    - Those nodes have already been added to topological sort, so they're basically irrelevant. Don't violate these edges
3. Repeat above, adding nodes with no incoming edges and removing their outbound edges. When all nodes hve abeen added to topological sort, we're done

**Formal algorithm**:
1. Create a queue `order`, which will eventually store the topological sort. It's empty
2. Create a queue `processNext`. This queue will store the next node to process.
3. Count the number of incoming edges of each node and set a class variable `node.inbound`. Count the inbound edges by walking through each node `n` and, for each its outgoing edge `(n, x)`, increment `x`.inbound
    - Could also keep a set of vertices that point into it?
4. Walk through the nodes again and add to `processNext` any node where `x.inbound == 0`.
5. While `processNext` is not empty, do the following:
    - Remove the first node `n` from `processNext`
    - For each edge `(n, x)`, decrement `x.inbound`. If `x.inbound == 0`, append `x` to `processNext`.
    - Append `n` to `order`
6. If `order` contains all the nodes, then it has succeeded. Otherwise, the topological sort has failed due to a cycle,

## Psuedocode

Refer to "formal algorithm" above.

Below is Kahn's algorithm from Wikipedia:
```
L ← Empty list that will contain the sorted elements
S ← Set of all nodes with no incoming edge

while S is not empty do
    remove a node n from S
    add n to L
    for each node m with an edge e from n to m do
        remove edge e from the graph
        if m has no other incoming edges then
            insert m into S

if graph has edges then
    return error   (graph has at least one cycle)
else 
    return L   (a topologically sorted order)

```

## Ilustration

![Topolgical sort](https://upload.wikimedia.org/wikipedia/commons/thumb/0/03/Directed_acyclic_graph_2.svg/458px-Directed_acyclic_graph_2.svg.png)

The graph shown to the left has many valid topological sorts, including:
- 5, 7, 3, 11, 8, 2, 9, 10 (visual top-to-bottom, left-to-right)
- 3, 5, 7, 8, 11, 2, 9, 10 (smallest-numbered available vertex first)
- 5, 7, 3, 8, 11, 10, 9, 2 (fewest edges first)
- 7, 5, 11, 3, 10, 8, 9, 2 (largest-numbered available vertex first)
- 5, 7, 11, 2, 3, 8, 9, 10 (attempting top-to-bottom, left-to-right)
- 3, 7, 8, 5, 11, 10, 2, 9 (arbitrary)

#
## Time Complexity
**Worst/best/average case**: O(|V| + |E|)

In a completed topological sort, every edge must be removed and every vertex is "visited" to remove those edges connecting them. So therefore it's the sum of the number of vertexes O(|V|) and number of edges O(|E|), or O(|V| + |E|).

#
## Space Complexity
**Memory**: O(|V|)

We make an additional queue for processing and a queue for the actual sort. Both are to hold the vertices. Therefore, O(2V) = O(V)

#
## Distinguishing Features
- Able to sort a directed acyclic graph
- Show how to resolve dependent connection (see "example uses")

#
## Strengths and Weaknesses

**Strengths**:
- Sorting for dependent relationshis

**Weaknesses**:
- A specific use case

#
## Example Uses
- Course Schedule (LC-207:))
- Parts on an assembly line
- Dependency resolution

#
## Resources
- CtCI (Advanced Topics section)
- https://en.wikipedia.org/wiki/Topological_sorting

#