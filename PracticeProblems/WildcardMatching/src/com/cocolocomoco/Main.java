package com.cocolocomoco;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String s = "cb";
        String p = "*b";

//        String s = "acdcb";
//        String p = "a*c?b";

//        String s = "abcabczzzde";
//        String p = "*abc???de*";

        Solution solution = new Solution();
        System.out.println(solution.isMatch(s, p));
    }
}


class Solution {
    public boolean isMatch(String s, String p) {
//        if (p.contains("*")) {
//            return true;
//        }
//
//        HashMap<Integer, Character> mapPatternIndexToChar = new HashMap<>();
//        int firstCharIndex = -1;
//        char firstChar = '~';
//        boolean isSingleCharWildcard = false;
//
//        for (int i = 0; i < p.length(); i++) {
//            if (p.charAt(i) != '?') {
//                if (firstCharIndex == -1) {
//                    firstCharIndex = i;
//                    firstChar = p.charAt(i);
//                }
//
//                mapPatternIndexToChar.put(i, p.charAt(i));
//            } else {
//                isSingleCharWildcard = true;
//            }
//        }
//
//        if (!isSingleCharWildcard && p.length() < s.length()) {
//            return false;
//        }
//
//        for (int i = firstCharIndex; i <= s.length() - p.length() + 1; i++) {
//            char currentChar = s.charAt(i);
//            if (currentChar == firstChar) {
//                for (int j = firstCharIndex; j < p.length(); j++) {
//                    if (mapPatternIndexToChar.containsKey(j) && mapPatternIndexToChar.get(j) != s.charAt(j)) {
//                        break;
//                    }
//                }
//
//                return true;
//            }
//        }



        int pItr = 0;
        int sItr = 0;
        boolean isValid = false;
        boolean containsWildcard = false;

        while (pItr != p.length() && sItr != s.length()) {
            if (p.charAt(pItr) == s.charAt(sItr)) {
                isValid = true;
                pItr++;
                sItr++;
                continue;
            }

            if (p.charAt(pItr) == '?') {
                pItr++;
                containsWildcard = true;
                continue;
            }

            if (p.charAt(pItr) == '*') {
                while(pItr < p.length() && p.charAt(pItr) == '*') {
                    pItr++;
                    containsWildcard = true;
                }

                // Ending '*'
                if (pItr == p.length()) {
                    isValid = true;
                    continue;
                }

                while (s.charAt(sItr) != p.charAt(pItr)) {
                    sItr++;
                    if (sItr >= s.length()) {
                        // Ending '*'
                        if (pItr == p.length()) {
                            isValid = true;
                            break;
                        }
                        System.out.println("reached exit condition");
                        return false;
                    }
                }
            }

            if (p.charAt(pItr) != s.charAt(sItr)) {
                isValid = false;
                pItr = 0;
                sItr++;
                continue;
            }

        }


        HashSet<Integer> test = new HashSet<Integer>();
        int i = 0;
        List<Integer> asdf = test.stream().filter(x -> x != i).collect(Collectors.toList());

        if (!containsWildcard && p.length() != s.length()) {
            isValid = false;
        }

        if (s.length() == 0 && p.length() > 0) {
            HashSet<Character> chars = new HashSet<>();
            boolean containsNonWildcardChar = false;
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) != '*') {
                    containsNonWildcardChar = true;
                }
                chars.add(p.charAt(j));
            }

            if (containsNonWildcardChar) {
                return false;
            }

            return true;
        }

        return isValid;
    }
}