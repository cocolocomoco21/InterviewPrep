### Problem
Is a robot contained in a circle, given moveset "turn left", "turn right", "move forward"

https://leetcode.com/problems/robot-bounded-in-circle/

### Approach
We know that all rectangles (including squares) or line segments can be bounded by a circle. Because each turn is 90 degrees
(i.e. left or right), we know that if the robot makes a rectangle, it cannot occur in _more_ than 4 turns. Therefore,
if we let the robot repeat four cycles of it's movement and it returns to the origin, we know that it makes a rectangle,
and therefore a circle exists such that it encompasses the rectangle, and therefore the robot's path.

Algorithm: simply let the robot move up to four turns. At each turn, check if the current point is the origin. If so,
we know the robot completes a rectangle. Check each time because the robot can rotate more than 90 degrees (e.g. 180)
and complete a connected path _earlier_ than four loops, and early exiting saves unneeded processing.

The implementation I did here has a lot of custom classes built and is a good example of showing organized code structure.