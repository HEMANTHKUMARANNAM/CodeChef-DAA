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
		    long n = sc.nextLong();
		    
		    long ans =0;
		    
		    for(long j =0 ; j< n ; j++ )
		    {
		        ans = Math.max( ans , sc.nextLong() );
		    }
		    
		    System.out.println( n- ans );
		    
		    
		}
	

	}
	
	

}
