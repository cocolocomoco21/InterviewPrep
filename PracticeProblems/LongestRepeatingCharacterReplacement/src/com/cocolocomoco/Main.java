package com.cocolocomoco;

public class Main {

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;

        Solution solution = new Solution();
        int result = solution.characterReplacement(s, k);
    }
}


class Solution {
    public int characterReplacement(String s, int k) {
        // TODO input validation

        int lowerBound = 0;
        int upperBound = k - 1;


    }
}