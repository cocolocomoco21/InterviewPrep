package com.cocolocomoco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // www.api.stripe.com
        // w1w.a1i.s4e.c1m
        // w1w.a1i.s7m

	    String input = "stripe.com/payments/checkout/customer.john.doe";
        int minorParts = 2;

//        String input = "www.api.stripe.com/checkout";
//        int minorParts = 3;

        Solution solution = new Solution();
        String compressed = solution.compress(input, minorParts);

        System.out.println(compressed);
    }
}


class Solution {

    public Solution() {
    }

    public String compress(String input, int numMinorParts) {
        List<String> majorParts = List.of(input.split("/"));
        StringBuilder compressed = new StringBuilder();

        for (int k = 0; k < majorParts.size(); k++) {
            String majorPart = majorParts.get(k);
            List<String> minorParts = List.of(majorPart.split("\\."));

            if (minorParts.size() <= numMinorParts) {
                // Compress all minor parts, until you have one less than maximum
                for (int i = 0; i <= minorParts.size() - 1; i++) {
                    // Compress
                    String minorPart = minorParts.get(i);
                    String compressedPart = this.compress(minorPart);
                    compressed.append(compressedPart);

                    if (i != minorParts.size() - 1) {
                        compressed.append('.');
                    }
                }
            } else {
                // Compress all minor parts, until you have one less than maximum
                for (int i = 0; i < numMinorParts - 1; i++) {
                    // Compress
                    String minorPart = minorParts.get(i);
                    String compressedPart = this.compress(minorPart);
                    compressed.append(compressedPart);

                    if (i != minorParts.size() - 1) {
                        compressed.append('.');
                    }
                }

                char startChar = minorParts.get(numMinorParts - 1).charAt(0);
                int numCharsInFinalMinorPart = 0;
                char endChar = minorParts.get(minorParts.size() - 1).charAt(minorParts.get(minorParts.size() - 1).length() - 1);

                for (int i = numMinorParts - 1; i < minorParts.size(); i++) {
                    numCharsInFinalMinorPart += minorParts.get(i).length();
                }

                compressed.append(startChar);
                compressed.append(numCharsInFinalMinorPart - 2);
                compressed.append(endChar);
            }

            if (k != majorParts.size() - 1) {
                compressed.append('/');
            }
        }

        return compressed.toString();
    }

    private String compress(String input) {
        return String.valueOf(input.charAt(0)) +
                (input.length() - 2) +
                input.charAt(input.length() - 1);
    }
}