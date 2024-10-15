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
		    
		    Integer[] nums = new Integer[n];
		    
		    
		    for(int j =0 ; j< n ; j++)
		    {
		        nums[j] = sc.nextInt();
		    }
		    
	
		
		    Map<Integer,Integer> mp = new HashMap<Integer,Integer>();
		    
		    for(int j =0 ; j< n ; j++)
		    {
		        mp.put( nums[j] , mp.getOrDefault( nums[j] , 0 ) +1  );
		    }
		    
		    
		    int max =0;
		    
		    for( Map.Entry<Integer,Integer> entry : mp.entrySet() )
		    {
		        max = Math.max( max , entry.getValue() );
		    }
		    
		    
		    if(max == 1&& n >1)
		    {
		        System.out.println(n-2);
		        continue;
		    }
		    
		    
		    System.out.println( n -max );
		    
		    
		    
		    
		}
	

	}
	
	
	
}
