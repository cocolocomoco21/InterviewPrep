###Problem
CTCI 8.1: A child is running up a staircase with n steps and can hop either 1, 2, or 3 steps at a time. 
Implement a method to count how many possible ways the child can run up the stairs.

###Approach
Dynamic programming, similar to CoinChange problem (in other directory). Have map of number of possible combinations for a given
step. For a given step, exhaust all possible combinations of steps, using the map when a step already exists in it.
When all possibilities are found, add together and insert into map for the current step. Do this recursively backwards
to get all possible step combinations for a given n.
