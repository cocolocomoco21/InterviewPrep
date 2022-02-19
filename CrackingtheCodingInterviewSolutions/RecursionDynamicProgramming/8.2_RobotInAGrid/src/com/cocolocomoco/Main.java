package com.cocolocomoco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // Form grid
        int rows = 5;
        int cols = 6;

        List<List<Point>> grid = new ArrayList<>(rows);
        for (int r = 0; r < rows; r++) {
            List<Point> currentRow = new ArrayList<>(cols);
            for (int c = 0; c < cols; c++) {
                currentRow.add(new Point(r, c));
            }
            grid.add(currentRow);
        }

        // Manually add restricted cells
        grid.get(1).get(1).setIsRestricted(true);
        grid.get(2).get(3).setIsRestricted(true);
        grid.get(4).get(4).setIsRestricted(true);
        grid.get(3).get(4).setIsRestricted(true);
        grid.get(3).get(1).setIsRestricted(true);
        grid.get(4).get(2).setIsRestricted(true);



        // Run algorithm
        Solution solution = new Solution(grid);
        solution.printGrid(null);

        List<Point> path = solution.findPath();

        // Algo has returned path if it exists. Print for display
        if (path != null) {
            for (Point point : path) {
                System.out.print(point + " ");
            }
            System.out.println();
        } else {
            System.out.println("No path found");
        }

        solution.printGrid(path);
    }
}

class Solution {

    private Stack<Point> path;
    private List<List<Point>> grid;

    public Solution(List<List<Point>> grid) {
        this.path = new Stack<>();
        this.grid = grid;
    }

    public List<Point> findPath() {
        Point origin = this.grid.get(0).get(0);
        this.path.add(origin);

        boolean isPath = this.findPath(origin);
        if (!isPath) {
            return null;
        }

        Point[] pathList = new Point[this.path.size()];
        for (int i = path.size() - 1; i >= 0; i--) {
            pathList[i] = this.path.pop();
        }

        return Arrays.asList(pathList);
    }

    private boolean findPath(Point point) {
        if (this.grid == null || this.grid.size() == 0 || this.grid.get(0).size() == 0)
        {
            return false;
        }

        // We've reached end, return success
        if (point.getRow() == this.grid.size() - 1 && point.getColumn() == this.grid.get(0).size() - 1) {
            return true;
        }

        // Get potential moves, either down or right from current Point
        List<Point> potentialMoves = this.getPotentialMoves(point);

        boolean isPathFromCurrentPoint = false;
        for (Point potentialMovePoint : potentialMoves) {
            // Add next Point to stack, in case it's one point on successful path
            this.path.add(potentialMovePoint);

            // Determine if next Point has path. If so, early exit by returning true. Use current stack as path
            boolean result = findPath(potentialMovePoint);
            if (result) {
                return true;
            }
        }

        // If no path found for current potential moves, return false and remove current point from path stack
        if (!isPathFromCurrentPoint) {
            point.setIsRestricted(true);
            path.pop();
        }

        return isPathFromCurrentPoint;
    }

    private List<Point> getPotentialMoves(Point currentPoint) {
        List<Point> potentialMoves = new ArrayList<>();

        // Not eligible if current cell is restricted. This case covers the origin being blocked
        if (currentPoint.getIsRestricted()) {
            return potentialMoves;
        }

        // Not eligible if current row is bottom row OR if downward cell is restricted
        if (currentPoint.getRow() != this.grid.size() - 1) {
            Point downwardCell = this.grid.get(currentPoint.getRow() + 1).get(currentPoint.getColumn());
            if (!downwardCell.getIsRestricted()) {
                potentialMoves.add(downwardCell);
            }
        }

        // Not eligible if current column is rightmost column OR if rightward cell is restricted
        if (currentPoint.getColumn() != this.grid.get(0).size() - 1) {
            Point rightwardCell = this.grid.get(currentPoint.getRow()).get(currentPoint.getColumn() + 1);
            if (!rightwardCell.getIsRestricted()) {
                potentialMoves.add(rightwardCell);
            }
        }

        return potentialMoves;
    }

    // Utility method to print the grid. Not needed to answer the interview question, but fun little thing to type up
    // and useful for debugging
    public void printGrid(List<Point> path) {
        // Print headers
        System.out.print("   ");
        for (int c = 0; c < this.grid.get(0).size(); c++) {
            System.out.print(" " + c + "  ");
        }
        System.out.println();

        for (int r = 0; r < this.grid.size(); r++) {
            List<Point> currentRow = this.grid.get(r);
            for (int c = 0; c < currentRow.size(); c++) {
                if (c == 0) {
                    System.out.print(r + " ");
                }

                int finalR = r;
                int finalC = c;
                boolean isPointInPath = path != null && path.stream().anyMatch(p -> p.getRow() == finalR && p.getColumn() == finalC);
                System.out.print("| " + (isPointInPath ? "P " : currentRow.get(c).getIsRestricted() ? "x " : "  "));
            }

            System.out.println("|");
        }
    }
}

class Point {
    private int row;
    private int column;
    private boolean isRestricted;

    Point(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean getIsRestricted() {
        return this.isRestricted;
    }

    public void setIsRestricted(boolean value) {
        this.isRestricted = value;
    }

    @Override
    public String toString() {
        return "(" + this.row + ", " + this.column+ ")";
    }
}