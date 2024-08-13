/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static List<Integer> convertToArrayList( int a [] ){
        
        List<Integer> ans = new ArrayList<>();
        
        for( int e : a ){
            ans.add( e );
        }
        
        return ans;
    }
    
    static void swap( int [] a , int l , int r ){
        
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
        
    }
    
    static void permute( int l , int n , int [] a , HashSet<List<Integer>> ans ){
        
        if( l >= n ){
            List<Integer> p = convertToArrayList(a);
            ans.add( new ArrayList(p) );
            return;
        }
        
        for( int i = l ; i < n ; i++ ){
            
            if( a[i] != a[l] ){
                
                swap( a , l , i);
		            
                permute( l + 1 , n , a , ans );
    		            
                swap( a , l , i);
            }
            else{
                permute( l + 1 , n , a , ans );
            }
            
		            
        }
        
        
        
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		PrintWriter out = new PrintWriter(System.out);
		
// 		int t = sc.nextInt();
	    int t = Integer.valueOf( br.readLine() );
		
		while( t--  > 0 ){
		    int n = Integer.valueOf( br.readLine() );
		    
		    int [] a = new int[n];
		    
		    String s = br.readLine();
		    
		    String str [] = s.split( " " );
		    
		    for (int i = 0 ; i < n ; i++ ) a[i] = Integer.valueOf( str[i] );
		    
		    Arrays.sort( a );
		    
		    HashSet<List<Integer>> ans = new HashSet<>();
		    
		  //  System.out.println( Arrays.toString( a ) );
		  
		    List<Integer> temp = convertToArrayList( a );
		    
		    boolean flag = false;
		    
		    for( int e : temp ){
		        if( Collections.frequency( temp , e ) == n ){
		            flag = true;
		            break;
		        }
		    }
		    
		    if( flag ){
		        
		        out.println( 1 );
		        
		        out.println( temp.toString().replace(",","").replace("[","").replace("]","") );
		        
		    }
		    else{
		        
		        permute( 0 , n , a , ans );
		    
    		    out.println( ans.size() );
    		    
    		    List<List<Integer>> ians = new ArrayList<>(ans);
    		    
    		    Collections.sort( ians , new Comparator<List<Integer>>(){
                    public int compare(List<Integer> list1, List<Integer> list2){
                        int result = 0;
                        for (int i = 0; i <= list1.size() - 1 && result == 0; i++) 
                        {
                            result = list1.get(i).compareTo(list2.get(i));
                        }
                        return result;
                    }
                });
        
                
    		    
    		    for( List<Integer> b : ians ){
    		        
    		        out.println( b.toString().replace(",","").replace("[","").replace("]","") );
    		        
    		    }
		        
		    }
		    
		  
		      //System.out.println( ans.toString() );
		    
		}
		
		out.close();
	}
}
