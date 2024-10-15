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

		for(int i =0 ; i< t ; i++)
		{
		    int n = sc.nextInt();
		    Integer[] g = new Integer[n];
		    Integer[] b = new Integer[n];
		    
		    for(int j =0 ; j< n ; j++ )
		    {
		        g[j] = sc.nextInt();
		    }
		    for(int j =0 ; j< n ; j++ )
		    {
		        b[j] = sc.nextInt();
		    }
		    
		    Arrays.sort(g);
		    Arrays.sort(b , Collections.reverseOrder() );
		    
		    int max = Integer.MIN_VALUE;
		    
		    for(int j =0 ; j < n ; j++)
		    {
		        int sum = g[j] + b[j];
		        if( max < sum )
		        {
		            max = sum;
		        }
		    }
		    
		    System.out.println(max);
		    
		    
		}
	

	}
	
	
}
