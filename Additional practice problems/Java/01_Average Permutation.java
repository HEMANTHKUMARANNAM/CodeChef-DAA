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
		    
		    permutation(n);
		    
		}

	}
	
	
	public static void  permutation(int n)
	{
	    
	    if(n==3)
	    {
	        System.out.println("1 2 3");
	        return;
	    }
	    
	    System.out.print(n + " " + (n-2) + " ");
	    
	    for(int i =1 ; i<=n-4 ; i++ )
	    {
	        System.out.print(i + " ");
	    }
	    
	    
	    System.out.println( (n-3) + " " + (n-1) );
	    
	    
	    

	}
	
	
}
