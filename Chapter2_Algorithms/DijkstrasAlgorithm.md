# Dijkstra's Algorithm
## Overview

Dijkstra's algorithm finds the shortest path between nodes in a graph.

## Typical Use-Case

Find shortest path between nodes in a graph.

## More Details and Definitions

**Minimum spanning tree**: subset of edges on a connected, weighted, undirected graph that connects all the vertices together without cycles and with the minimum possible total edge weight.

Minimum spanning tree is the bolded lines set inside the entire connected graph:

![Minimum spanning tree](https://upload.wikimedia.org/wikipedia/commons/d/d2/Minimum_spanning_tree.svg)

**Spanning tree**: subgraph that is a tree which inclues all vertices of the graph G

**Shortest path tree**: connected subgraph of graph G that covers all the graph nodes with the minimum possible number of edges.
    - is a spanning tree 

Dijkstra's: generate a shortest path tree with a given source as the root. We maintain two sets: one contains vertices included in the shoftest path tree, the other includes vertices not yet included in the shortest path tree. At every step of the algorithm, we find a vertex that is in the other set (set of not yet included) and has a minimum distance from the source

Dijkstra's algorithm works on the basis that any subpath B -> D of the shortest path A -> D between vertices A and D is also the shortest path between vertices B and D. As such, Dijkstra's algorithm is a greedy algorithm.

#
## Algorithm

Dijkstra's algorithm:
1. Create an empty set `sptSet` (shortest path tree set) that keeps track of vertices included in the shortest path tree. That is, whose minimum distance from the source is calculated and finalized/
2. Assign a distance value to all vertices in the input graph. Initialize all distance values as INFINITE. Assign ditance value as 0 for the source vertex so it's picked first.
3. While `sptSet` doesn't include all vertices
    - Pick a vertex `u` which is not in `sptSet` and has a minimum distance value.
    - Add `u` to `sptSet`
    - Update distance value of all adjacent vertices to `u`. To update, iterate through all adjacent vertices, and for each adjacent vertex `v`, if the sum of distance value of `u` (from source) and weight of edge `u-v` is less than the distance value of `v` itself, then update the distance value at `v`.

## Psuedocode

Here we need to maintain the path distance of every vertex. We store that in array with size = number of vertices.

We also want to return shortest path, not just length. For this, we map each vertex to the vertex that last updated its path length.

Use a minimum priority queue to track vertex with minimum path.

```
function dijkstra(G, S)
    for each vertex V in G
        distance[V] <- infinite
        previous[V] <- NULL
        If V != S, add V to Priority Queue Q
    distance[S] <- 0
	
    while Q IS NOT EMPTY
        U <- Extract MIN from Q
        for each unvisited neighbour V of U
            tempDistance <- distance[U] + edge_weight(U, V)
            if tempDistance < distance[V]
                distance[V] <- tempDistance
                previous[V] <- U
    return distance[], previous[]
```

Java code:
```
// Dijkstra's Algorithm in Java

public class Dijkstra {

  public static void dijkstra(int[][] graph, int source) {
    int count = graph.length;
    boolean[] visitedVertex = new boolean[count];
    int[] distance = new int[count];
    for (int i = 0; i < count; i++) {
      visitedVertex[i] = false;
      distance[i] = Integer.MAX_VALUE;
    }

    // Distance of self loop is zero
    distance[source] = 0;
    for (int i = 0; i < count; i++) {

      // Update the distance between neighbouring vertex and source vertex
      int u = findMinDistance(distance, visitedVertex);
      visitedVertex[u] = true;

      // Update all the neighbouring vertex distances
      for (int v = 0; v < count; v++) {
        if (!visitedVertex[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])) {
          distance[v] = distance[u] + graph[u][v];
        }
      }
    }
    for (int i = 0; i < distance.length; i++) {
      System.out.println(String.format("Distance from %s to %s is %s", source, i, distance[i]));
    }

  }

  // Finding the minimum distance
  private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
    int minDistance = Integer.MAX_VALUE;
    int minDistanceVertex = -1;
    for (int i = 0; i < distance.length; i++) {
      if (!visitedVertex[i] && distance[i] < minDistance) {
        minDistance = distance[i];
        minDistanceVertex = i;
      }
    }
    return minDistanceVertex;
  }

  public static void main(String[] args) {
    int graph[][] = new int[][] { { 0, 0, 1, 2, 0, 0, 0 }, { 0, 0, 2, 0, 0, 3, 0 }, { 1, 2, 0, 1, 3, 0, 0 },
        { 2, 0, 1, 0, 0, 0, 1 }, { 0, 0, 3, 0, 0, 2, 0 }, { 0, 3, 0, 0, 2, 0, 1 }, { 0, 0, 0, 1, 0, 1, 0 } };
    Dijkstra T = new Dijkstra();
    T.dijkstra(graph, 0);
  }
}

```

Code from https://www.programiz.com/dsa/dijkstra-algorithm

## Ilustration

![Dijkstra's algorithm](https://upload.wikimedia.org/wikipedia/commons/5/57/Dijkstra_Animation.gif)

#
## Time Complexity
**Worst/best/average case**: O(V^2) for adjacenty list. Can be O(ElogV) with heap?

For each vertex v, extract-min is a linear search through all vertices v to determine which node to move to next. So O(V^2).

#
## Space Complexity
**Memory**: O(V)

??

#
## Distinguishing Features
- Shortest path algorithm
- Can be used for undirected or directed

#
## Strengths and Weaknesses

**Strengths**:
- Extensible: can be used to calculate shortest path between a source and destination nodes OR from a source to all other nodes
- Reasonably efficient?

**Weaknesses**:
- Edges cannot have negative values
- Blind search wastes time while processing?

#
## Example uses
- Find the shortest path
- Social network applications
- IP routing, telephone network
- Google Maps

#
## Resources
- https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
- https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
- https://en.wikipedia.org/wiki/Minimum_spanning_tree
- https://en.wikipedia.org/wiki/Shortest-path_tree
- https://www.baeldung.com/cs/minimum-spanning-vs-shortest-path-trees
- https://en.wikipedia.org/wiki/Spanning_tree
- https://www.programiz.com/dsa/dijkstra-algorithm

#