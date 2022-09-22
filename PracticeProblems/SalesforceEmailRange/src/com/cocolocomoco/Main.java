package com.cocolocomoco;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    String input = "1:30 , 2:40, 5:30, 4:30, 4:15"; //args[0];
//        String input = "1:4 , 5:10,11:20"; //args[0];
//        String input = "5:10,1:2"; //args[0];
        EmailRangesHistory history = new EmailRangesHistory();
        String result = history.process(input);
        System.out.println(result);
    }
}

// Note: no boilerplate was given to me, so I was unable to test on HackerRank. I have attempted to create the main
// method, but have gotten runtime errors as the Solution class, or any containing main method, was not given to me.
class EmailRangesHistory {

    public EmailRangesHistory() {
    }

    public String process(String input) {
        // Trim to remove any whitespace
        input = input.replaceAll("\\s", "");

        // Form list of ranges
        List<String> rangesStr = Arrays.asList(input.split(","));

        // Populate ranges in usable Integer type
        List<List<Integer>> ranges = new ArrayList<>();
        for (String rangeStr : rangesStr) {
            int delimIndex = rangeStr.indexOf(':');
            Integer start = Integer.parseInt(rangeStr.substring(0, delimIndex));
            Integer end = Integer.parseInt(rangeStr.substring(delimIndex + 1));

            List<Integer> range = Arrays.asList(start, end);
            ranges.add(range);
        }

        // Sort according to start value, followed by ending value if same start value
        ranges.sort((r1, r2) -> {
            int comparison = r1.get(0).compareTo(r2.get(0));
            if (comparison != 0) {
                return comparison;
            } else {
                return r1.get(1).compareTo(r2.get(1));
            }
        });

        // Reduce ranges
        List<List<Integer>> compacted = new ArrayList<>();
        List<Integer> existingRange = ranges.get(0);
        for (int i = 1; i < ranges.size(); i++) {
            List<Integer> currentRange = ranges.get(i);
            if (currentRange.get(0) <= existingRange.get(1) + 1) {
                if (currentRange.get(1) > existingRange.get(1)) {
                    existingRange.set(1, currentRange.get(1));
                }
            } else {
                compacted.add(existingRange);
                existingRange = currentRange;
            }
        }

        // Add last "working" range since finished processing
        compacted.add(existingRange);

        // Form result string
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < compacted.size(); i++) {
            List<Integer> range = compacted.get(i);
            output.append(range.get(0));
            output.append(":");
            output.append(range.get(1));
            if (i != compacted.size() - 1) {
                output.append(",");
            }
        }

        return output.toString();
    }
}