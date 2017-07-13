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
        int a, b;
        int sum = 0;
        int k = 0;
        
        Node[] nodes = new Node[n];
        for(int i = 0; i<n; i++){
            nodes[i] = new Node(i+1, new ArrayList<Integer>() );
        }
        
        for(int i = 0; i<m; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            
            nodes[a-1].children.add(b);
            nodes[b-1].children.add(a);
        }
        
        for(int i = 0; i<n; i++){
            k = nodes[i].countChildren(nodes);
            if(k%2 == 0 && k != 0){
                if(nodes[i].disconnect(nodes))
                    sum++;
            }
        }
        System.out.println(sum);
    }
    
}

class Node{
    int pos;
    ArrayList<Integer> children;
    
    public Node(int pos, ArrayList<Integer> children){
        this.pos = pos;
        this.children = children;
    }
    
    public int countChildren(Node[] list){
        int sum = 1;
        ArrayList<Integer> direct = this.children;

        for(int i = 0; i<direct.size(); i++){
            if(direct.get(i) > this.pos){
                sum+=list[direct.get(i)-1].countChildren(list);
            }
        }        
        return sum;
    }
    
    public boolean disconnect(Node[] list){
        ArrayList<Integer> direct = this.children;
        int other ;
        
        for(int i = 0; i<direct.size(); i++){
            other = direct.get(i);
            if(other < this.pos){
                direct.remove(i);
                list[other-1].children.removeAll(Arrays.asList(i+1));
                return true;
            }
        }
        
        return false;
    }
}
