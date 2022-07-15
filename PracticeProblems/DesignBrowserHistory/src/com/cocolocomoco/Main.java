package com.cocolocomoco;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class BrowserHistory {
    // Represents the history if you were to go backward
    private Stack<String> backwardStack;

    // Represents the history if you were to go forward
    private Stack<String> forwardStack;

    public BrowserHistory(String homepage) {
        this.backwardStack =  new Stack<>();
        this.forwardStack = new Stack<>();
        this.visit(homepage);
    }

    public void visit(String url) {
        this.backwardStack.push(url);
        this.forwardStack.clear();
    }

    public String back(int steps) {
        while (this.backwardStack.size() > 1 && steps > 0) {
            // Remove from backwardstack
            String site = this.backwardStack.pop();

            // Add to forwardStack if the user wants to renavigate forward
            this.forwardStack.push(site);

            steps--;
        }

        return this.backwardStack.peek();
    }

    public String forward(int steps) {
        while (!this.forwardStack.isEmpty() && steps > 0) {
            // Remove from forwardstack
            String site = this.forwardStack.pop();

            // Add to backwardStack if the user wants to renavigate backward
            this.backwardStack.push(site);

            steps--;
        }

        return this.backwardStack.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */