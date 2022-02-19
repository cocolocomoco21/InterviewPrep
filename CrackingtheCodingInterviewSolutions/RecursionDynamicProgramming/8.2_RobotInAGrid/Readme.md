###Problem
CTCI 8.2: robot is in the top left corner of a grid with r rows and c columns. The robot can only move down or right and
wants to get to the bottom left corner. There are certain cells that are restricted. Design an algorithm to find a path
for the robot

###Approach
Dynamic programming. At a given cell, find all potential moves, meaning the right and/or downward cell, where the cell 
is not restricted or beyond a border. In DFS manner, if the current potentialMove does not have a viable path (no
potential moves returned a viable path due to a restricted cell or a border or both), try the next one. If that 
potentialMove doesn't have a path, "return false" by setting the current cell to be restricted, since we know that it
does not have a viable move forward. 

While this iterating is happening, keep a stack of the current path. When a cell is deemed inviable, remove it from the
stack. When a potentialMove is being explored, add it (and any further explored children/potentialMoves) to the stack.
If a path is found, return true and the current state of the stack represents the path. This stack can be returned to
represent the path, or we can form it into a list, etc.