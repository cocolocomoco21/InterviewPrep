package com.cocolocomoco;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());


        medianFinder.addNum(2);
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(8);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(8);
        System.out.println(medianFinder.findMedian()); // 3

        medianFinder.addNum(4);
        medianFinder.addNum(6);
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian()); // 1 1 2 3 4 6 8 8
    }
}

class MedianFinder {
    // Create maxHeap for left side (smaller) and minHeap for right side (larger)
    private Queue<Integer> leftSide;
    private Queue<Integer> rightSide;
    private int itemCount;

    public MedianFinder() {
        this.leftSide = new PriorityQueue<>(Collections.reverseOrder());
        this.rightSide = new PriorityQueue<>();
        this.itemCount = 0;
    }

    public void addNum(int num) {
        // Add num into heaps according to value
        if (this.rightSide.isEmpty() || num >= this.rightSide.peek()) {
            rightSide.offer(num);
        } else if (this.leftSide.isEmpty() || num < this.leftSide.peek()) {
            this.leftSide.offer(num);
        } else {
        }

        this.itemCount++;

        // If odd, ensure that rightSide contains the extra
        if (this.itemCount % 2 == 1) {
            // leftSide is greater and has the extra
            if (this.leftSide.size() > this.rightSide.size()) {
                this.rightSide.offer(this.leftSide.poll());
            }
        } else {
            if (this.leftSide.size() > this.rightSide.size()) {
                this.rightSide.offer(this.leftSide.poll());
            } else if (this.rightSide.size() > this.leftSide.size()){
                this.leftSide.offer(this.rightSide.poll());
            }
        }
    }

    public double findMedian() {
        if (this.itemCount % 2 == 1) {
            return this.rightSide.peek();
        } else {
            return (this.leftSide.peek() + this.rightSide.peek()) / 2.0;
        }
    }
}