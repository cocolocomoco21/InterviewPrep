# Clone Graph
## LC 133
https://leetcode.com/problems/clone-graph/

## Problem
Given a reference of a node in a **connected** undirected graph.

Return a **deep copy** (clone) of the graph.

Each node in the graph contains a value (`int`) and a list (`List[Node]`) of its neighbors.

```
class Node {
    public int val;
    public List<Node> neighbors;
}
```

The given node will always be the first node with `val = 1`. You must return the copy of the given node as a reference to the cloned graph.

## Example
Note: Leetcode gives examples with adjacency lists, though it works to just return the Node object rather than this output they give here:
```
Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation: There are 4 nodes in the graph.
1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
```
![Diagram](https://assets.leetcode.com/uploads/2019/11/04/133_clone_graph_question.png)

## Approach
**Summary**: Use HashMap to look up nodes and add conection to them while performing BFS.

Create a map of index -> new nodes. We know the nodes must be new objects due to OOP. Do a BFS for every existing node in existing graph. At every existing node: for every existing neighbor in the existing node, add a new neighbor corresponding to the same value for the existing neighbor. Maintain this list in the map so we can refer to the same new neighbor object across various nodes. Visit every node, since every node->neighbor relationship must be created. Return first new node from map when done. 

**Detailed explanation**:

Fundamentally, you must make a new Java object for each node (due to how references work in Java) to make a deep clone. We see the given Node class has a constructor to do this, given an int `val`.

Traverse the whole graph, adding each node's neighbor into the corresponding new node's own list of neighbors. Since the graph is undirected, it is not enough to just have one node in this node -> neighbor pair to have the neighbor "link" - both nodes must have the other node listed in their neighbors. 

As such, we must traverse each node in the original graph and each of its neighbors. Since we must traverse the graph, I chose BFS. We know that all neighbors of _each_ node must be traversed, regardless of if the node is "visited" or not, to add that linkage manually.

We know each node is unique based on the constraint that each node's value is the same as its index (e.g. first node has val = 1, second node has val = 2, etc.). Mathmatically, this means each node has a unique value. This gives a natural unique identifier to each node, and is a simple int to make it easy to operate on.

Imagine this: we are iterating through the graph and encounter a neighbor that is not yet "visited". We must still mark some "logical" node as the neighbor to keep record of this traversal and not lose this linkage. In practice, this is a Java object. As such, we must be able to make the nodes before we actually visit the nodes.

Therefore, since we're going to need to be able to look up nodes given _something_ unique about them, we can create a map that maps the index/value (unique) to the Node object itself. Since the object is a reference, it is that "logical" place (a place in memory) to maintain the record of the traversal and therefore sustain that node -> neighbor relationship.

For eacn new node, iterate over all neighbors. The neighbor may not exist, so if it does not, we need to create it and add it to the map of neighbors. If it does exist, just look it up from the map. Add this neighbor linkage to the current new node.

If the neighbor is not itself visisted, add it to the queue for BFS and add it to the visited set. The visited set can simply be a HashSet on the unique index, which is constant time.

Once the queue is empty and the graph has been traversed, just find the element corresponding to value 1 in the map, per the question's stipluation.


**Psuedocode**:
```
Node cloneGraph(node){
    HashMap<Integer, Node> mapValueToNode = new HashMap
    HashSet<Integer> visted = new HashSet
    Queue<Integer> queue = new LinkedList

    // Return null if null
    if (node == null)
        return null
    
    // Add first node to queue for BFS
    nodeQueue.offer(node)
    visited.add(node.val)

    // Run BFS to explore all nodes
    while (!queue.isEmpty())
        // Dequeue node from queue
        currentNode = queue.poll

        // Get node if it exists or create a new one otherwise
        currentNewNode = mapValueToNode.getNodeOrDefault(currentNode.val ? new Node(currentNode.val))
        
        // If new node was created, add it to map
        if (!mapValueToNode.contains(currentNode.val))
            mapValueToNode.put(currentNode.val, currentNewNode)
        }

        for (neighbor : currentNode.neighbors)
            if (mapValueToNode.contains(neighbor.val))
                // Add existing node as neighbor
                currentNewNode.neighbors.add(mapValueToNode.get(neighbor.val))
            else
                // Create new node and add as neighbor
                newNeighbor = new Node(neighbor.val)
                currentNewNode.neighbors.add(newNeighbor)

                // Since it's a new node, add to map
                mapValueToNode.put(neighbor.val, newNeighbor)

            // Add neighbor to queue if unvisted yet
            if (!visited.contains(neighbor.val))
                nodeQueue.offer(neighbor)
                visited.add(neighbor.val)

    
    // Return node with val 1, per the problem specs
    return mapValueToNode.getOrDefault(1, null)
}

// Given Node class
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
```

## Search Terms
lc-blind75, lc-graph, lc-bfs, lc-hashmap, lc-medium, lc-133 