package com.cocolocomoco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Node a = new Node("a", 1, true);
        Node b = new Node("b", 2, true);
        Node c = new Node("c", 3, true);
        Node d = new Node("d", 4, true);
        Node e = new Node("e", 5, true);
        Node g = new Node("g", 7, true);

        a.children.add(b);
        a.children.add(c);

        b.children.add(d);
        b.children.add(e);

        //c.children.add(g);

        Node a1 = new Node("a", 1, true);
        Node b1 = new Node("b", 2, true);
        Node c1 = new Node("c", 3, true);
        Node d1 = new Node("d", 4, true);
        Node e1 = new Node("e", 5, true);
        Node f1 = new Node("f", 6, true);
        Node g1 = new Node("g", 7, false);

        a1.children.add(b1);
        a1.children.add(c1);

        b1.children.add(d1);
        //b1.children.add(e1);
        //b1.children.add(f1);

        c1.children.add(e1);

        int count = solution.getNumberModifiedItems(a, a1);
        System.out.println("Changed Items are: " + count);
    }
}

class Solution {
    public Solution() {

    }

    public int getNumberModifiedItems(Node oldMenu, Node newMenu) {
        if (oldMenu == null && newMenu == null) {
            return 0;
        }

        int count = 0;

        // Node doesn't equal or doesn't exist
        if (oldMenu == null || newMenu == null || !oldMenu.equals(newMenu)) {
            count++;
        }

        // Get all children. If a node is null, get empty and continue iterating down tree
        Map<String, Node> oldMenuChildren = getChildrenNodes(oldMenu);
        Map<String, Node> newMenuChildren = getChildrenNodes(newMenu);

        for (String key: oldMenuChildren.keySet()) {
            // Node has been removed
            count += getNumberModifiedItems(oldMenuChildren.get(key), newMenuChildren.getOrDefault(key, null));
        }

        for (String key: newMenuChildren.keySet()) {
            // Don't "double up" on counting diffs. Just count if oldMenu items were deleted
            if (!oldMenuChildren.containsKey(key)) {
                count += getNumberModifiedItems(null, newMenuChildren.get(key));
            }
        }

        return count;
    }

    Map<String, Node> getChildrenNodes(Node node) {
        Map<String, Node> mapKeyToNode = new HashMap<>();
        if (node == null || node.children == null || node.children.size() == 0) {
            // Return empty map if no children
            return mapKeyToNode;
        }

        for (Node child: node.children) {
            mapKeyToNode.put(child.key, child);
        }

        return mapKeyToNode;
    }

}


class Node {
    String key;
    int value;
    boolean active;
    List<Node> children;

    public Node(String key, int value, boolean active) {
        this.key = key;
        this.value = value;
        this.active = active;
        this.children = new ArrayList<>();
    }

    boolean equals(Node other) {
        if (other == null) {
            return false;
        }

        return this.key == other.key
                && this.value == other.value
                && this.active == other.active;
    }

    int countAllChildren() {
        if (this.children.size() == 0) {
            return 0;
        }

        int childrenCount = 0;
        for (Node child: this.children) {
            childrenCount += child.countAllChildren();
        }

        return childrenCount + 1;
    }
}