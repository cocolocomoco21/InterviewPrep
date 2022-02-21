### Problem
Given a string representing a math equation, evaluate the expression. Valid chars are all digits 0-9, `+`, `-`, `(`,`)`,
and ` `. Unary operation only exists for negative, i.e. `-4` or `-(3+2)` is valid, but the same is not for `+`.


https://leetcode.com/problems/basic-calculator/

### Approach

The parenthesis naturally follow a stack pattern, where your "current" work/sum is put off for later, until you've
evaluated the parenthetical expression. I iterated over all elements once and used two stacks: numStack and signStack.

Sum all numbers until you reach an open parenthesis. Add that "currentSum" to the stack and begin evaluating the sum
in the parentheses. Once you reach a closed parenthesis, add the new currentSum to the top item in the numStack.

Use signStack to know which addition/subtraction operation you should do. When you encounter a sign, add it to signStack.
If your next number is before a parenthesis, add to currentSum using the last sign added to signStack. If a negative 
sign is added immediately before a parenthesis, check and multiply by -1 when pulling that number of signStack.


Algorithm:
```
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
```