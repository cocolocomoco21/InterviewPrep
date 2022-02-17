package com.cocolocomoco;

public class Main {

    public static void main(String[] args) {
	    String input = "3 + 8*2";
        Solution solution = new Solution();
        int result = solution.calculate(input);

        System.out.println(result);
    }
}


class Solution {
    private final static char END_OF_OPERATION_CHAR = '~';

    public int calculate(String s) {
        Node head = constructLinkedList(s);
        int result = computeResult(head);
        return result;
    }

    private Node constructLinkedList(String input) {
        int numberItrStart = 0;
        Node currentNode = null;
        Node head = null;

        for (int i = 0; i < input.length(); i++) {
            // Iterate to find next operation char
            if (this.isOperation(input.charAt(i))) {
                char operationChar = input.charAt(i);
                int numericalValue = Integer.parseInt(input.substring(numberItrStart, i).trim());

                // If previous operation is multiply/divide, don't need to make Node. Just do operation inline
                if (currentNode != null && this.isMultiplyOrDivide(currentNode.getOperation())) {
                    int result = this.operate(currentNode.getValue(), numericalValue, currentNode.getOperation());
                    currentNode.setValue(result);
                    currentNode.setOperation(operationChar);
                } else {
                    // Create new node since it's not multiply/divide
                    Node newNode = new Node(numericalValue, operationChar);
                    if (currentNode == null) {
                        currentNode = newNode;
                        head = newNode;
                    } else {
                        currentNode.setNext(newNode);
                        currentNode = currentNode.getNext();
                    }
                }


                numberItrStart = i + 1;
            }
        }



        // At this point, itr points to beginning of last number. Construct it separately
        int numericalValue = Integer.parseInt(input.substring(numberItrStart).trim());
        if (currentNode != null && this.isMultiplyOrDivide(currentNode.getOperation())) {
            int result = this.operate(currentNode.getValue(), numericalValue, currentNode.getOperation());
            currentNode.setValue(result);
            currentNode.setOperation(END_OF_OPERATION_CHAR);
        } else {
            Node newNode = new Node(numericalValue, END_OF_OPERATION_CHAR);
            if (currentNode == null) {
                // If currentNode == null, so does head. Set it here for return below
                head = newNode;
            } else {
                currentNode.setNext(newNode);
            }
        }

        return head;

    }

    private int computeResult(Node head) {
        int result = head.getValue();
        Node currentNode = head;

        while (currentNode.getOperation() != END_OF_OPERATION_CHAR) {
            result = operate(result, currentNode.getNext().getValue(), currentNode.getOperation());
            currentNode = currentNode.getNext();
        }

        return result;
    }

    private int operate(int val1, int val2, char operation) {
        switch (operation) {
            case '+':
                return val1 + val2;
            case '-':
                return val1 - val2;
            case '*':
                return val1 * val2;
            case '/':
                return val1 / val2;
            default:
                throw new IllegalArgumentException("Invalid operation character");
        }
    }

    private boolean isOperation(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private boolean isMultiplyOrDivide(char c) {
        return c == '*' || c == '/';
    }
}

class Node {
    private int value;
    private char operation;
    private Node next;

    public Node(int value, char operation) {
        this.value = value;
        this.operation = operation;
    }

    public int getValue() {
        return value;
    }

    public char getOperation() {
        return operation;
    }

    public Node getNext() {
        return next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public boolean isEndNode() {
        return this.next == null;
    }
}

//enum Operation {
//    ADDITION ('+'),
//    SUBTRACTION ('-'),
//    MULTIPLICATION ('*'),
//    DIVISION ('/');
//
//    private char operation;
//
//    Operation(char operation){
//        this.operation = operation;
//    }
//
//    public static boolean contains(char c) {
//        return c == '+' || c == '-' || c == '*' || c == '/';
//    }
//
//    public static boolean isMultiplyOrDivide(char c) {
//        return c == '*' || c == '/';
//    }
//
//    public char getOperation() {
//        return this.operation;
//    }
//}