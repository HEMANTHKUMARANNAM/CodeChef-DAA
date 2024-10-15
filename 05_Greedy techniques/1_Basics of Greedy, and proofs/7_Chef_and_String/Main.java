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
		    String s = sc.next();
		    
		    System.out.println(maxfun(s));
		    
		    
		}
		


	}
	
	
	public static int maxfun(String s)
	{
	    
	    int n = s.length();
	    
	    int count =0;
	    
	    for(int i =0 ; i< n-1 ; i++)
	    {
	        char curr = s.charAt(i);
	        char next = s.charAt(i+1);
	        if( (curr == 'x' && next == 'y') || (curr == 'y' && next == 'x')  )
	        {
	            count++;
	            i++;
	        }
	        
	        
	    }
	    
	    return count;
	    

	}
	
}
