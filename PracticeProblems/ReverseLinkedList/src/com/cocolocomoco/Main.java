package com.cocolocomoco;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        Solution solution = new Solution();
        solution.reverseList(n1);
    }
}


class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        // Populate reversal stack
        Stack<ListNode> reversalStack = new Stack<>();
        while (head != null) {
            reversalStack.push(head);
            head = head.next;
        }

        // Repopulate linked list
        ListNode reversedHead = reversalStack.pop();
        ListNode currentNode = reversedHead;
        while (!reversalStack.isEmpty()) {
            currentNode.next = reversalStack.pop();
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
        currentNode.next = null;

        return reversedHead;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}