
## Problem<br>
You are given a tree (a simple connected graph with no cycles). The tree has 
**```N```** nodes numbered from **```1```** to **```N```** and is rooted at node **```1```**.
Find the maximum number of edges you can remove from the tree to get a 
forest such that each connected component of the forest contains an even number of nodes.<br>

## Input Format<br>
The first line of input contains two integers **```N```** and **```M```**. **```N```** is the number of nodes, and **```M```** is the number of
edges. 
The next **```M```** lines contain two integers **```u```** and **```v```** which specifies an edge of the tree.

## Constraints<br>
**```2 ≤ N ≤ 100```**<br>
*Note*:
 The tree in the input will be such that it can always be decomposed into components containing an even number of nodes.
 
## Output Format<br>
Print the number of removed edges.

