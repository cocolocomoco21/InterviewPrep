package com.cocolocomoco;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> mapValueToNode = new HashMap<>();
        HashSet<Integer> visitedNodes = new HashSet<>();
        Queue<Node> nodeQueue = new LinkedList<>();

        // Return null if null
        if (node == null) {
            return null;
        }

        // Add first node to queue for BFS
        nodeQueue.offer(node);
        visitedNodes.add(node.val);

        // Run BFS to explore all nodes
        while (!nodeQueue.isEmpty()) {
            // Dequeue node from queue
            Node currentNode = nodeQueue.poll();

            // Get node if it exists or create a new one otherwise
            Node currentNewNode = mapValueToNode.getOrDefault(currentNode.val, new Node(node.val));

            // If new node was made, still need to put it into map
            if (!mapValueToNode.containsKey(currentNewNode.val)) {
                mapValueToNode.put(currentNewNode.val, currentNewNode);
            }

            for (Node neighbor : currentNode.neighbors) {
                if (mapValueToNode.containsKey(neighbor.val)) {
                    // Add existing node as neighbor
                    currentNewNode.neighbors.add(mapValueToNode.get(neighbor.val));
                } else {
                    // Create new node and add as neighbor
                    Node newNeighbor = new Node(neighbor.val);
                    currentNewNode.neighbors.add(newNeighbor);

                    // Since it's a new node, add to map
                    mapValueToNode.put(neighbor.val, newNeighbor);
                }

                // Add neighbor to queue if unvisted yet
                if (!visitedNodes.contains(neighbor.val)) {
                    nodeQueue.offer(neighbor);
                    visitedNodes.add(neighbor.val);
                }
            }
        }

        // Return node with val 1, per the problem specs
        return mapValueToNode.getOrDefault(1, null);
    }
}

// Definition for a Node.
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