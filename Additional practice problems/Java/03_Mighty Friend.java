import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for(int j =0 ; j< t ; j++)
		{
		    int n = sc.nextInt();
		    
		    int k = sc.nextInt();
		    
		    int[] a = new int[n];
		    
		    for(int i =0 ; i< n ; i++ )
		    {
		        a[i] = sc.nextInt();
		    }
		    
		    maxfun(a , k);
		    
		    
		}
	

	}
	
	
	public static void maxfun(int[] a , int k)
	{
	    
	    PriorityQueue<Integer> m = new PriorityQueue<>(Collections.reverseOrder());
	    
	    PriorityQueue<Integer> t = new PriorityQueue<>();
	    
	    for(int i =0 ; i< a.length ; i++)
	    {
	        if(i%2==0)
	        {
	            m.add(a[i]);
	        }
	        else
	        {
	            t.add(a[i]);
	        }
	    }
	    
	    
	    
	    for(int i =0 ; i< k ; i++)
	    {
	        
	        int t1 = m.poll();
	        int t2 = t.poll();
	        
	        m.add(t2);
	        t.add(t1);
	        
	    }
	    
	    int motu =0;
	    
	    int tomu =0;
	    
	    while( m.size() !=0 )
	    {
	        motu += m.poll();
	    }
	    
	    while( t.size() !=0 )
	    {
	        tomu += t.poll();
	    }
	    
	    if( motu >= tomu )
	    {
	        System.out.println("NO");
	    }
	    else
	    {
	        System.out.println("YES");
	    }
	    
	    
	    
	    
	    
	    

	}
}
