package com.cocolocomoco;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
        Solution solution = new Solution();

        int[][] heights = new int[][] {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};

        List<List<Integer>> result = solution.pacificAtlantic(heights);
        int x = 3;

    }
}

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // Create list of nodes
        Node[][] allNodes = new Node[heights.length][heights[0].length];

        // Instantiate list of nodes
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                Node currentNode = new Node(i, j, heights[i][j]);
                allNodes[i][j] = currentNode;
            }
        }

        // Populate list of nodes - iterate over all elements, add potential moves to each node
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                // Populate all viable neighbors. Viable neighbors = is neighbor height >= current height
                int currentHeight = heights[i][j];
                Node currentNode = allNodes[i][j];

                // North
                if (i - 1 >= 0 && heights[i - 1][j] >= currentHeight) {
                    // Add north node to list of outgoing nodes
                    currentNode.outgoingNodes.add(allNodes[i - 1][j]);
                }

                // East
                if (j + 1 <= heights[i].length - 1 && heights[i][j + 1] >= currentHeight) {
                    // Add east node to list of outgoing nodes
                    currentNode.outgoingNodes.add(allNodes[i][j + 1]);
                }

                // South
                if (i + 1 <= heights.length - 1 && heights[i + 1][j] >= currentHeight) {
                    // Add south node to list of outgoing nodes
                    currentNode.outgoingNodes.add(allNodes[i + 1][j]);
                }

                // West
                if (j - 1 >= 0 && heights[i][j - 1] >= currentHeight) {
                    // Add west node to list of outgoing nodes
                    currentNode.outgoingNodes.add(allNodes[i][j - 1]);
                }
            }
        }

        // Create visited Sets for pacific and atlantic
        int numRows = heights.length;
        int numCols = heights[0].length;

        // Pre-load "coast" for BFS since we know it can reach pacific
        Queue<Node> queuePacific = new LinkedList<>();
        for (int i = 0; i < numCols; i++) {
            queuePacific.offer(allNodes[0][i]);
            allNodes[0][i].visitedPacific = true;
        }
        for (int i = 0; i < numRows; i++) {
            queuePacific.offer(allNodes[i][0]);
            allNodes[i][0].visitedPacific = true;
        }

        // Do BFS for pacific to see which nodes can be reached
        while (!queuePacific.isEmpty()) {
            Node currentNode = queuePacific.poll();
            for (Node outgoingNode : currentNode.outgoingNodes) {
                if (!outgoingNode.visitedPacific) {
                    queuePacific.offer(outgoingNode);
                    outgoingNode.visitedPacific = true;
                }
            }
        }

        // Pre-load "coast" for BFS since we know it can reach atlantic
        Queue<Node> queueAtlantic = new LinkedList<>();
        for (int i = 0; i < numCols; i++) {
            queueAtlantic.offer(allNodes[numRows - 1][i]);
            allNodes[numRows - 1][i].visitedAtlantic = true;
        }
        for (int i = 0; i < numRows; i++) {
            queueAtlantic.offer(allNodes[i][numCols- 1]);
            allNodes[i][numCols - 1].visitedAtlantic = true;
        }

        // Do BFS for atlantic to see which nodes can be reached
        while (!queueAtlantic.isEmpty()) {
            Node currentNode = queueAtlantic.poll();
            for (Node outgoingNode : currentNode.outgoingNodes) {
                if (!outgoingNode.visitedAtlantic) {
                    queueAtlantic.offer(outgoingNode);
                    outgoingNode.visitedAtlantic = true;
                }
            }
        }

        // Intersect visitedPacific and visitedAtlantic to find which nodes can reach both
        List<List<Integer>> intersection = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                Node currentNode = allNodes[i][j];
                if (currentNode.visitedPacific && currentNode.visitedAtlantic) {
                    intersection.add(Arrays.asList(i, j));
                }
            }
        }

        return intersection;
    }
}

class Node {
    int row;
    int col;
    int height;
    List<Node> outgoingNodes;
    boolean visitedPacific;
    boolean visitedAtlantic;

    public Node(int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
        this.outgoingNodes = new ArrayList<>();
        this.visitedPacific = false;
        this.visitedAtlantic = false;
    }

}