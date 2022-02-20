### Problem

Given a grid (2D char array) of land ('1') or water ('0'), find how many islands there are. An island is a land that is
connected horizontally or vertically to other land.

https://leetcode.com/problems/number-of-islands/

### Approach
Iterate over all cells. If water or visited, skip. If land, increment count and do DFS search to find all connected land cells.
Mark visisted as 'v', but could also just set them to water.

Basically:
```
main:
for all rows
    for all cols
        if (currChar == land)
            numIslands++
            visitIsland(currChar)

visitIsland:
if above is not OOB and is unvisitedLand
    mark visisted
    visitIsland(above)
if below is not OOB and is unvisitedLand
    mark visisted
    visitIsland(below)   
if left is not OOB and is unvisitedLand
    mark visisted
    visitIsland(left)   
if right is not OOB and is unvisitedLand
    mark visisted
    visitIsland(right)
            
```