package com.cocolocomoco;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = 0;

        result = solution.calculate("3+(1-(4+(5+2))-3)+(6+8)");     // 4
        System.out.println(result);

        result = solution.calculate("(0-2)-(4+8)+(5-1)");           // -10
        System.out.println(result);

        result = solution.calculate(" 2-1 + 2 ");                   // 3
        System.out.println(result);

        result = solution.calculate("-2+ 1");                       // -1
        System.out.println(result);

        result = solution.calculate("- (3 + (4 + 5))");             // -12
        System.out.println(result);

        result = solution.calculate("1-1");                        // 0
        System.out.println(result);


    }
}

    /*
    EXAMPLE

    3+(1-(4+(5+2))-3)+(6+8)

    numStack:
    signStack:
    currentSum: 4

    ---
    ALGORITHM
    Stack numStack
    Stack signStack
    int currentSum
    int currentNumber

    for each char currChar in s
        if currChar == sign
            signStack.push(currChar)
            currentNumber = 0
        if currChar == '('
            numStack.push(currentSum)
            currentSum = 0  // OR make equal to next number
            currentNumber = 0
        if currChar == ')'
            enclosingSign = signStack.pop
            if enclosingSign == '-'
                currentSum = currentSum * -1
            currentSum += numStack.pop
            currentNumber = 0
        if currChar == number
            currNumber = currNumber *10 + currChar
            if nextChar != number
                if last operand == + or -
                    sign = signStack.pop
                    currentSum = currentSum (sign aka + or -) currentNumber
                else
                    currSum = currNumber

    return currentSum;
    */


class Solution {
    public int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> signStack = new Stack<>();
        int currentSum = 0;
        int currentNumber = 0;
        char lastValidOperand = '~';

        for (int i= 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            switch (currChar) {
                case ' ':
                    break;
                case '+':
                case '-':
                    lastValidOperand = currChar;
                    signStack.push(currChar);
                    currentNumber = 0;
                    break;
                case '(':
                    lastValidOperand = currChar;
                    numStack.push(currentSum);
                    currentSum = 0;
                    currentNumber = 0;
                    break;
                case ')' :
                    lastValidOperand = currChar;

                    if (!signStack.isEmpty()) {
                        char enclosingSign = signStack.pop();
                        if (enclosingSign == '-') {
                            currentSum = currentSum * -1;
                        }
                        currentSum += numStack.pop();
                    }
                    break;
                default:
                    // Update currentNumber
                    currentNumber = currentNumber * 10 + Character.digit(currChar, 10);

                    // If this is the end of currentNumber
                    if (i == s.length() - 1 || !Character.isDigit(s.charAt(i + 1))) {

                        // This is addition/subtraction without a parenthesis - just pop sign off stack
                        if ((lastValidOperand == '+' || lastValidOperand == '-')) {
                            char sign = signStack.pop();
                            if (sign == '+') {
                                currentSum += currentNumber;
                            } else {
                                currentSum -= currentNumber;
                            }
                        } else {
                            // This is a number immediately following a parenthesis - don't pop off stack, just set currentSum
                            currentSum = currentNumber;
                        }
                    }

                    break;
            }
        }

        return currentSum;
    }
}