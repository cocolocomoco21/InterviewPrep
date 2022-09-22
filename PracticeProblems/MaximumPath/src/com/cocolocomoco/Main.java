package com.cocolocomoco;

public class Main {

    public static void main(String[] args) {
        Node n1 = new Node(5);
        Node n2 = new Node(2);
        Node n3 = new Node(2);
        Node n4 = new Node(20);
        Node n5 = new Node(14);
        Node n6 = new Node(15);

        n1.left = n2;
        n2.left = n3;
//        n1.right = n4;
//        n4.left = n5;
//        n4.right = n6;

        Solution solution = new Solution();
        int result = solution.findMaximumPath(n1);
        int max = solution.maxSum;
        System.out.println(max);
    }
}

class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int findMaximumPath(Node node) {
        if (node == null) {
            return 0;
        }

        int leftSum = findMaximumPath(node.left);
        int rightSum = findMaximumPath(node.right);

        // If sum at node is greater than current sum, update. Must also be connecting two leaves. Null check enforces
        int nodeSum = leftSum + rightSum + node.value;
        if (nodeSum > maxSum && node.left != null && node.right != null) {
            maxSum = nodeSum;
        }

        return Math.max(leftSum, rightSum) + node.value;
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}
