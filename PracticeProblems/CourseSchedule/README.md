# Course Schedule
## LC 207
https://leetcode.com/problems/course-schedule/

## Problem
There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses - 1`. You are given an array `prerequisites` where `prerequisites[i] = [ai, bi]` indicates that you must take course `bi` first if you want to take course `ai`.

For example, the pair `[0, 1]`, indicates that to take course `0` you have to first take course `1`.
Return true if you can finish all courses. Otherwise, return false.

## Example
Example 1:

```
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
```

Example 2:

```
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
```

## Approach
Topological sort. This is a sort that traverses the graph like BFS and removes edges as you visit neighbors.

We can tell from the question that this is a graph problem. Further, we see dependencies, which suggest this is a directed graph. To see if we can finish all courses, we will need to traverse the entire graph to determine if all nodes (courses) are visitable.

Graph traversal is not difficult without dependencies (e.g. simple BFS), but we must heed that some nodes are not "visitable" until all prereqs have been meet. Enter: topological sort.

As said above, topological sort will sort the nodes based on their "visitability" - the nodes with no dependencies will be visited first, and their neighbors will be checked (like BFS). What checking a neighbor means is that we remove the linkage from the neighbor (dependency) TO the node (prereq). If there are no remaining dependencies (i.e. all arrows/edges coming into the node are removed), we add that neighbor to the queue to be "explored" (i.e. have it's neighbors and dependencies addressed). Additionally, when a node is taken off the queue and is "visited", we add it to the queue that represents the actual topological sort.

When we add the item to the sorted queue, we check the size. If it is equal to `numCourses`, we can return true. Otherwise return a comparison between the queue size and `numCourses` at the end.

Lastly, we keep track of which nodes have no incoming edges and add those to the queue before starting the BFS. This can be done in many ways, I chose preloading a set and removing them as they're seen, then copying that over.

**Psuedocode**:
```
boolean canFinish(int numCourses, int[][] prerequisites) {
    if (prerequisites.length == 0)
        return true;

    sortedClassQueue = new queue
    processClassQueue = new queue
    mapCourseNumberToNode = new HashMap

    // Make map and set relationships
    for (i = 0 -> prerequisites.length)
        int[] currentEdges = prerequisites[i]
        int prerequisiteCourseNumber = currentEdges[1]
        int dependentCourseNumber = currentEdges[0]

        // Get nodes from map
        Node prerequisiteCourseNode = mapCourseNumberToNode.getOrMake(prerequisiteCourseNumber)
        Node dependentCourseNode = mapCourseNumberToNode.getOrMake(dependentCourseNumber)

        // Set relationship
        prerequisiteCourseNode.outgoingNodes.add(dependentCourseNumber)
        dependentCourseNode.incomingNodes.add(prerequisiteCourseNumber)
    

    // Load the nodes with no incoming edges in. These are all able to be started at
    // TODO find nodesWithNoIncomingEdges - not shown here
    proessClassQueue.enqueue(nodesWithNoIncomingEdges)

    // Run traversal using BFS + topological sort
    while (!processClassQueue.isEmpty())
        Node currentNode = processClassQueue.dequeue()
        sortedClassQueue.enqueue(currentNode);
        if (sortedClassQueue.size() == numCourses)
            return true

        for (Integer neighborCourseNumber : currentNode.outgoingNodes)
            neighbor = mapCourseNumberToNode.get(neighborCourseNumber)
            neighbor.incomingNodes.remove(currentNode.courseNumber);

            if (neighbor.incomingNodes.size() == 0)
                processClassQueue.enqueue(neighbor)

    return sortedClassQueue.size() == numCourses;
}

```
**NOTE**: this psuedocode and implementation can be improved/changed. Leaving roughly as-is from when I completed problem. Some folks use arrays and simply track the incomingEdge count for each node (corresponding to a count value at the corresponding index in an array). I chose to implement a complex Node class for clean code. For example:

```
public boolean canFinish(int numCourses, int[][] prerequisites){
    int[] incomingEdges = new int[numCourses];
    List<Integer>[] goCourses = new List[numCourses];
    for(int i=0;i<goCourses.length;i++){
        goCourses[i] = new LinkedList<Integer>();
    }
    for(int[] pair: prerequisites){
        incomingEdges[pair[0]]++;
        goCourses[pair[1]].add(pair[0]);
    }
    Queue<Integer> queue = new LinkedList<Integer>();
    for(int i=0;i<incomingEdges.length;i++){
        if(incomingEdges[i]==0){
            queue.add(i);
        }
    }
    int edgeCnt = prerequisites.length;
    while(!queue.isEmpty()){
        int cur = queue.poll();
        for(int goCrs: goCourses[cur]){
             edgeCnt--;
             if(--incomingEdges[goCrs]==0)
                queue.add(goCrs);
        }
    }
    return edgeCnt==0;
}
```
Leaving this here for reference when I use this as a refresher, compliments of LC.

## Search Terms
lc-blind75, lc-topologicalsort, lc-graph, lc-graphtraversal, lc-bfs, lc-medium, lc-207