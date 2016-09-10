import java.io.*;
import java.util.*;

public class Solution 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        long val;
        
        ArrayList<query> order = new ArrayList<query>();
        
        int type;
        String s = "";
        long x;
        query obj;
        
        for(int i = 0; i<m; i++)
        {
            type = sc.nextInt();
            
            if(type == 1)
            {
                x = sc.nextLong();
                s = sc.next();
                
                order.add(new query(1, x ,s));
            }    
            else if(type == 2)
            {
                x = sc.nextLong();
                s = sc.next();
               
                order.add(new query(2, x ,s));
                
            }
            else if(type == 3)
            {
               s = sc.next();
                
               val = 0;
               for(int j = order.size()-1; j>=0; j--)
               {    
                   obj = order.get(j);
                   if(obj.type == 1) 
                   {
                       if(check(obj.m, s))
                       {
                           val = val^obj.x;
                           break;
                       }
                   }    
                   else if(obj.type == 2)
                   {
                       if(check(obj.m, s))
                            val = val^obj.x;  
                   }    
               }
               System.out.println(val); 
            }    
        }    
    }
    
    static boolean check(String ori, String s)
    {
        int orig = Integer.parseInt(ori, 2);
        int ne = Integer.parseInt(s, 2);
        
        int not = ~orig;
        int and = not & ne;
        if(and != 0)
            return false;
        return true;
    }    
}

class query
{
    long x;
    String m;
    int type;
    
    public query( int type, long x, String m)
    {
    	this.x = x;
    	this.m = m;
    	this.type = type;
    }    
}    
