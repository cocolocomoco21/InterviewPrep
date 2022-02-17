package com.cocolocomoco;



public class SolutionII {
    public static void main(String[] args) {
        String input = "1-2+4*5 + 6";
        SolutionII solution = new SolutionII();
        int result = solution.calculate(input);

        System.out.println(result);
    }


    public int calculate(String s) {
        int lastAdditionSum = 0;
        int lastNumber = 0;
        char lastOperator = '+';
        int startNumberIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (this.isOperator(currentChar) || i == s.length() - 1) {
                // This .substring call could be improved but it's easiest and readable for the sake of the problem
                int currentNumber = Integer.parseInt(s.substring(startNumberIndex, i == s.length() - 1 ? i + 1 : i).trim());

                if (this.isAdditionOrSubtraction(lastOperator)) {
                    // Add previous to rolling addition sum
                    lastAdditionSum += lastNumber;
                    lastNumber = lastOperator == '+' ? currentNumber : -currentNumber;
                    lastOperator = currentChar;
                } else if (this.isMultiplicationOrDivision(lastOperator)) {
                    if (lastOperator == '*') {
                        lastNumber *= currentNumber;
                    } else {
                        lastNumber /= currentNumber;
                    }
                    lastOperator = currentChar;
                } else {
                    throw new IllegalArgumentException("invalid operator");
                }

                startNumberIndex = i+1;
            }

        }

        return lastAdditionSum + lastNumber;
    }

    private boolean isOperator(char c) {
        return isAdditionOrSubtraction(c) || isMultiplicationOrDivision(c);
    }

    private boolean isAdditionOrSubtraction(char c) {
        return c == '+' || c == '-';
    }

    private boolean isMultiplicationOrDivision(char c) {
        return c == '*' || c == '/';
    }
}
