# Greedy Algorithms
## Overview

Greedy algorithms build up a solution by choosing the option that looks best at every step.

## Typical Use-Case

Finding a solution that is "good enough".

For example, travelling salesman problem with the greedy heuristic "at each step of the journey, visit the nearest unvisited city." This is not intended to find the _best_ solution, but it terminates in a reasonable numbe rof steps, and finding an optimal solution to this problem requiers an unreasonably high number of steps otherwise.

#
## Algorithm

Greedy algorithm is any algorithm that follows the problem-solving heuristic of making the locally optimal choice at each stage. In many problems, greedy solution is not optimal, but a greedy heuristic can yield locally optimal solutions that approximate globally optimal solutions in a reasonable amount of time.

## Ilustration

Example greedy algorithm and how the heuristic can overconstrain for finding the global solution:

![Example greedy algorithm](https://upload.wikimedia.org/wikipedia/commons/8/8c/Greedy-search-path-example.gif?20110418164758)

#
## Time Complexity
**Worst/best/average case**: Depends on algorithm

Greedy algorithm is a general algorithm and the space complexity depends on the actual algorithm extending this technique.

#
## Space Complexity
**Memory**: Depends on algorithm

Greedy algorithm is a general algorithm and the space complexity depends on the actual algorithm extending this technique.

#
## Distinguishing Features
- Not necessarily optimal, and is more of a "best effort attempt" that can often times approximate the optimal
- Heuristic based, so it can overconstrain itself from a global optimal/solution

#
## Strengths and Weaknesses

**Strengths**:
- Useful because they are easy to think up and apply
- Often give good approximations to the optimum
- IF it gives the optimal choice, often preferred because it's faster compared to other optimization methods like DP 

**Weaknesses**:
- Not always optimal, so need to be careful

#
## Example uses
- Cashier giving change, e.g. $0.67. Give biggest (quarter), then another, then a dime, then a nickel, then two pennies.
- Minimum spanning tree in a graph
- Network routing - route message to neighboring node which is "closest" to the destination
- Dijkstra's (and A*) are verifiably optimal greedy algorithms for graph search and shortest path finding

#
## Resources
- https://www.interviewcake.com/concept/java/greedy
- https://en.wikipedia.org/wiki/Greedy_algorithm

#