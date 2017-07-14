### Problem 
Given a graph which consists of several edges connecting the **```N```** nodes in it. It is required to find a subgraph of the given graph with the following properties: 

    * The subgraph contains all the nodes present in the original graph.
    * The subgraph is of minimum overall weight (sum of all edges) among all such subgraphs.
    * It is also required that there is exactly one, exclusive path between any two nodes of the subgraph.

One specific node **```S```** is fixed as the starting point of finding the subgraph.
Find the total weight of such a subgraph (sum of all edges in the subgraph)  

### Input Format
First line has two integers **```N```**, denoting the number of nodes in the graph and **```M```**, denoting the number of edges in the graph.

The next **```M```** lines each consist of three space separated integers **```x, y and r```**, where **```x```** and **```y```** denote the two nodes between which the undirected edge exists, **```r```** denotes the length of edge between the corresponding nodes.

The last line has an integer **```S```**, denoting the starting node. 
    
### Constraints
```2 ≤ N ≤ 3000```<br>
```1 ≤ M ≤ (N * (N-1))/2```<br>
```1 ≤ x, y, S ≤ N```<br>
```0 ≤ r ≤ 10^5```<br>
If there are edges between the same pair of nodes with different weights, they are to be considered as is, like multiple edges.

### Output Format
Print a single integer denoting the total weight of tree so obtained (sum of weight of edges). 
