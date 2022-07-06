package com.cocolocomoco;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();

        int numCourses = 2;
        int[][] prerequisites = new int [][] {{1, 0 }};

        solution.canFinish(numCourses, prerequisites);
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }

        // This will contain the result of the topological sort
        Queue<Node> sortedClassQueue = new LinkedList<>();

        // When a node's edges are gone, add to this queue to explore that node
        Queue<Node> processClassQueue = new LinkedList<>();

        // Prepopulate that all nodes have no incoming edges. Remove when we find they do
        Set<Integer> noIncomingEdgeCourses = new HashSet<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            noIncomingEdgeCourses.add(i);
        }

        // Keep track of all created nodes
        HashMap<Integer, Node> mapCourseNumberToNode = new HashMap<>();

        // Populate graph and potential starting nodes
        for (int i = 0; i < prerequisites.length; i++) {
            // Get indexes
            int[] currentEdges = prerequisites[i];
            int prerequisiteCourseNumber = currentEdges[1];
            int dependentCourseNumber = currentEdges[0];

            // Get nodes from map
            Node prerequisiteCourseNode = mapCourseNumberToNode.computeIfAbsent(prerequisiteCourseNumber, k -> new Node(prerequisiteCourseNumber));
            Node dependentCourseNode = mapCourseNumberToNode.computeIfAbsent(dependentCourseNumber, k -> new Node(dependentCourseNumber));

            // Set relationship
            prerequisiteCourseNode.outgoingNodes.add(dependentCourseNumber);
            dependentCourseNode.incomingNodes.add(prerequisiteCourseNumber);

            // Remove dependent node from eligibility as a starting node
            noIncomingEdgeCourses.remove(dependentCourseNumber);
        }

        // Load the nodes with no incoming edges in. These are all able to be started at
        for (Integer courseNumber : noIncomingEdgeCourses) {
            processClassQueue.offer(mapCourseNumberToNode.computeIfAbsent(courseNumber, k -> new Node(courseNumber)));
        }

        // Run traversal using BFS + topological sort
        while (!processClassQueue.isEmpty()) {
            Node currentNode = processClassQueue.poll();
            sortedClassQueue.offer(currentNode);
            if (sortedClassQueue.size() == numCourses) {
                return true;
            }

            for (Integer neighborCourseNumber : currentNode.outgoingNodes) {
                Node neighbor = mapCourseNumberToNode.get(neighborCourseNumber);
                neighbor.incomingNodes.remove(currentNode.courseNumber);

                if (neighbor.incomingNodes.size() == 0) {
                    processClassQueue.offer(neighbor);
                }
            }
        }

        return sortedClassQueue.size() == numCourses;
    }
}

class Node {
    int courseNumber;
    Set<Integer> incomingNodes;
    Set<Integer> outgoingNodes;

    public Node(int courseNumber) {
        this.courseNumber = courseNumber;
        this.incomingNodes = new HashSet<>();
        this.outgoingNodes = new HashSet<>();
    }
}