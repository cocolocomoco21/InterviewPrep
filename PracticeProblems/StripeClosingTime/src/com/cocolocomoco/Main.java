package com.cocolocomoco;

import java.util.List;

public class Main {

    /*
    A shop has a log of if a customer was present for each hour, signified by space-separated string containing Y or N
    e.g. "Y N Y N N" = customer was seen first hour, not second hour, was seen third, and not fourth or fifth

    The shop has closing time, specified as int.
    e.g. "Y N Y N N", closing time = 2 means "Y N [Close here] Y N N"

    Part 1: Create method to find penalty. Penalty means no customer visited during an hour when the shop is open, or
        a customer did visit when the shop is closed. If penalty case, +1 to penalty.

    Part 2: Given a log (e.g. "Y Y N Y N"), find the best closing time.

    Part 3: Employees do their best to put "BEGIN" and "END" at each log entry, but don't always do it. If a log is
        contained within one BEGIN and one END, it is valid. No nested BEGIN and END are allowed, and we know that if
        there is a proper BEGIN and END, it is a proper entry (i.e. no beginning from one day and end from another).
        There can also be newline characters in addition to the spaces (i.e. \n).
        For each valid entry within a given log file (i.e. all complete or incomplete entries), find the best closing
        time. That is, find all valid entries and for each valid entry, find the best closing time.

    -----

    Approach:

    Part 1: computePenalty
        Split input. Now you have array of values. Keep count for penalty
        for each index in array of values
            if index < closing time and if value is N, increment
            if index >= closing time and if value is Y, increment

    Part 2: findBestClosingTime
        Store minPenalty and minPenaltyIndex
        for i=0 -> i=number of log entries
            call compute with i being closing time
            get penalty. if less than minPenalty, update minPenalty and minPenaltyIndex (aka closing time)
        return minPenalty

    Part 3: getBestClosingTimes
        Did not fully finish. Approach was:

        Instantiate array for returning best closing time
        String.split on "BEGIN".
        for each string in split array
            if string contains "END"    (by the given constraints, we know this is a complete log line)
                (somehow) remove whitespace. This could likely be done via regex in the above split call
                call findBestClosingTime (part 2)
                Save in array
        return array

     */


    public static void main(String[] args) {
        Solution solution = new Solution();

        // Part 1
//        int result = solution.computePenalty("Y Y N Y", 0);
//        System.out.println(result);
//
//        result = solution.computePenalty("N Y N Y", 2);
//        System.out.println(result);
//
//        result = solution.computePenalty("Y Y N Y", 4);
//        System.out.println(result);
//
//        // Other cases
//        System.out.println("new test cases");
//        result = solution.computePenalty("Y Y Y Y", 4);
//        System.out.println(result);
//
//        result = solution.computePenalty("N N N N", 4);
//        System.out.println(result);
//
//        result = solution.computePenalty("Y Y Y Y", 0);
//        System.out.println(result);
//
//        result = solution.computePenalty("N N N N", 0);
//        System.out.println(result);
//
//        result = solution.computePenalty("Y N N N", 2);
//        System.out.println(result);
//
//        result = solution.computePenalty("Y Y Y N", 2);
//        System.out.println(result);


        /////////////////////////////////////////////////////////////////
        // Part 2

//        int result = solution.findBestClosingTime("Y N Y N");
//        System.out.println(result);
//
//        assertEquals(3, solution.findBestClosingTime("Y Y Y N N N N"));
//        assertEquals(0, solution.findBestClosingTime(""));
//        assertEquals(1, solution.findBestClosingTime("Y"));
//        assertEquals(0, solution.findBestClosingTime("N N N N"));
//        assertEquals(4, solution.findBestClosingTime("Y Y Y Y"));
//        assertEquals(5, solution.findBestClosingTime("N Y Y Y Y N N N Y N N Y Y N N N N Y Y N N Y N N N"));
//        assertEquals(0, solution.findBestClosingTime("N N N N N Y Y Y N N N N Y Y Y N N N Y N Y Y N Y N"));
//        assertEquals(25, solution.findBestClosingTime("Y Y N N N Y Y N Y Y N N N Y Y N N Y Y Y N Y N Y Y"));


        ///////////////////////////////
        // Part 3

        solution.getBestClosingTimes("BEGIN BEGIN \nBEGIN N N BEGIN Y Y\n END N N END");
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("expected != actual");
        }

        System.out.println("pass");
    }
}

class Solution {

    public Solution() {
    }

    // Returns penalty
    public int computePenalty(String inputLog, int closingTime) {
        List<String> log = List.of(inputLog.split(" "));
        int penalty = 0;

        for (int i = 0; i < log.size(); i++) {
            // Shop is open - check for no visitors. Penalty if no visitors
            if (i < closingTime && log.get(i).equals("N")) {
                penalty++;
            }

            // Shop is closed - check for presence of visitors. Penalty if visitors
            if (i >= closingTime && log.get(i).equals("Y")) {
                penalty++;
            }
        }

        return penalty;
    }

    public int findBestClosingTime(String inputLog) {
        if (inputLog.equals("") || inputLog.equals(" ")) {
            return 0;
        }

        List<String> log = List.of(inputLog.split(" "));
        int minPenalty = Integer.MAX_VALUE;
        int minPenaltyIndex = -1;       // closing time

        for (int i = 0; i <= log.size(); i++) {
            int result = computePenalty(inputLog, i);
            if (result <= minPenalty) {
                minPenalty = result;
                minPenaltyIndex = i;
            }
        }

        return minPenaltyIndex;
    }

    public List<Integer> getBestClosingTimes(String inputLog) {
        List<String> logLines = List.of(inputLog.split("BEGIN"));
        // instantiate array

        for (String logLine : logLines) {
            if (logLine.contains("END")) {
                // trim newlines
                // result = findBestClosingTime(logLine)
                // add result to array
            }
        }

        // return array
    }
}
