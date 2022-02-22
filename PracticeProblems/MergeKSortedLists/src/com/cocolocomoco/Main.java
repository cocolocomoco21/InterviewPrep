package com.cocolocomoco;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

    }
}


/**
 * Original solution. Use a min heap, add all items into the min heap, the re-populate the linked list by polling the
 * heap
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        // Create min heap to add all items into
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        // Populate the minHeap
        for (ListNode linkedList : lists) {
            while(linkedList != null) {
                minHeap.offer(linkedList);
                linkedList = linkedList.next;
            }
        }

        // All linked lists were empty, so return null
        if (minHeap.isEmpty()) {
            return null;
        }

        // Create root
        ListNode node = minHeap.poll();
        ListNode root = node;

        // Populate new, sorted linked list
        while (!minHeap.isEmpty()) {
            node.next = minHeap.poll();
            node = node.next;
        }

        // Set last element to null to signify end of list
        node.next = null;

        return root;
    }
}


/**
 * Experimental solution to avoid the memory cost of creating an entire min heap. Use a map to map the value of a node
 * to the linked list node. Since the minimum values of each linked list are at the beginning, we can add them all to a
 * map and iterate from the min val to the max potential value (10000). When the index has an entry in the map, add it
 * to the final linked list, and add its "next" value into the map. Maintain the map by removing the entry if the
 * list of nodes is empty, and remove the node.
 *
 */
class SolutionII {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        HashMap<Integer, Queue<ListNode>> mapValueToListNodes = new HashMap<>();

        // Add the first node of each linked list
        int minValue = Integer.MAX_VALUE;
        for (ListNode linkedList : lists) {
            if (linkedList != null) {
                // Update min to know bottom iterator
                if (linkedList.val < minValue) {
                    minValue = linkedList.val;
                }

                // If val exists, update list to contain node. Otherwise create a new entry for val
                if (mapValueToListNodes.containsKey(linkedList.val)) {
                    mapValueToListNodes.get(linkedList.val).add(linkedList);
                } else {
                    Queue<ListNode> nodes = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
                    nodes.add(linkedList);
                    mapValueToListNodes.put(linkedList.val, nodes);
                }
            }
        }

        // All linked lists were empty, so return null
        if (mapValueToListNodes.isEmpty()) {
            return null;
        }

        ListNode root = null;
        ListNode currNode = null;

        // Iterate
        for (int i = minValue; i <= 10000; i++){
            if (mapValueToListNodes.containsKey(i)) {
                Queue<ListNode> nodes = mapValueToListNodes.get(i);
                while (!nodes.isEmpty()) {
                    ListNode node = nodes.poll();

                    if (root == null) {
                        root = node;
                    } else {
                        currNode.next = node;
                    }

                    currNode = node;

                    ListNode next = node.next;
                    if (next != null) {
                        if (mapValueToListNodes.containsKey(next.val)) {
                            mapValueToListNodes.get(next.val).add(next);
                        } else {
                            Queue<ListNode> newNodes = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
                            newNodes.add(next);
                            mapValueToListNodes.put(next.val, newNodes);
                        }
                    }
                }

                mapValueToListNodes.remove(i);
            }

            if (mapValueToListNodes.isEmpty()) {
                break;
            }
        }

        // Set last element to null to signify end of list
        currNode.next = null;

        return root;
    }
}



class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }