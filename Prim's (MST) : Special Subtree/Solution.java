import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a, b, w, start;
        ArrayList<Integer> visited;
        
        Node[] graph = new Node[n];
        for(int i = 0; i<n; i++)
            graph[i] = new Node(i+1, new HashMap<Integer, Integer>());
            
        for(int i = 0; i<m; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            w = sc.nextInt();
            
            graph[a-1].conn.put(b, w);
            graph[b-1].conn.put(a, w);
        }
        start = sc.nextInt();
        visited = new ArrayList<Integer>();
        visited.add(start);
        System.out.println(prims(graph, start, visited, n));
        
    }
    
    //recursively run prims algorithm
    public static int prims(Node[] graph, int start, ArrayList<Integer> visited, int n){
        if(visited.size() == n)
            return 0;
        
        Map<Integer, Integer> current;
        int min_cost_node, min_cost = Integer.MAX_VALUE, from = -1, to = -1, tmp;
        
        for(int i = 0; i<visited.size(); i++){
            current = graph[visited.get(i)-1].conn;
            tmp = getMinCostNode(current, visited);
            
            if(tmp == -1)
                continue;
            if(current.get(tmp) < min_cost){
                min_cost = current.get(tmp);
                from = visited.get(i);
                to = tmp;
            }
        }
        
        if(from == -1)
            return 0;        
        visited.add(to);
        update(graph, to);
        return min_cost + prims(graph, to, visited, n);
    }
    
    //find next min cost neighbour of visited nodes
    public static int getMinCostNode(Map<Integer, Integer> current, ArrayList<Integer> visited){
        
        Iterator it = current.entrySet().iterator();
        int min = Integer.MAX_VALUE;
        int index = -1;
        
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(visited.contains((int)pair.getKey()))
                continue;
            if(min > (int)pair.getValue()){
                min = (int)pair.getValue();
                index = (int)pair.getKey();
            }
        }
        return index;
    }
    
    //remove all unnecessary edges to save time
    public static void update(Node[] graph, int to){
        for(int i = 0; i<graph.length; i++){
            graph[i].conn.remove(to);
        }
    }
}

class Node{
    int pos;
    Map<Integer, Integer> conn;
    
    public Node(int pos, Map<Integer, Integer> conn){
        this.pos = pos;
        this.conn = conn;
    }
}
