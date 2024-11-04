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

		for(int k =0 ; k< t ; k++)
		{
		    int n = sc.nextInt();
		    
		    Integer[] a = new Integer[n];
		    
		    Integer[] v = new Integer[n];
		    
		    for(int i =0 ; i< n ; i++)
		    {
		        a[i] = sc.nextInt();
		    }
		    
		    for(int i =0 ; i< n ; i++ )
		    {
		        v[i] = sc.nextInt();
		    }
		    
		    maxfun( a ,  v);
		    
		    
		    
		}
	

	}
	
	
	public static void maxfun(Integer[] a , Integer[] v)
	{
	    
	    PriorityQueue<Integer> arr = new PriorityQueue<>();
	    
	    arr.addAll( Arrays.asList(a) );
	    
	    PriorityQueue<Integer> vac = new PriorityQueue<>();
	    
	    vac.addAll( Arrays.asList(v) );
	    
	    int count = 0;
	    
	    int max =0;
	    
	    while( arr.size() !=0 && vac.size() !=0 )
	    {
	        if( vac.peek() > arr.peek() )
	        {
	            arr.poll();
	            count++;
	            
	            max = Math.max(count , max);
	        }
	        else if( vac.peek() < arr.peek() )
	        {
	            vac.poll();
	            count--;
	        }
	        else
	        {
	            arr.poll();
	            vac.poll();
	        }
	        
	        
	    }
	    
	    
	    System.out.println(max);
	    

	}
	
	
	
}
