import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        
        String a = sc.next();
        String b = sc.next();
        
        int m = a.length();
        int n = b.length();
        
        int [][] dp = new int[m+1][n+1];
        
        for(int i =0 ; i< m+1; i++ )
        {
            for(int j =0 ; j< n+1 ; j++ )
            {
                dp[i][j] = -1;
            }
        }
        
        System.out.println( LCS(a,b,m,n,dp) );

    }
    
    public static int LCS( String a , String b , int m , int n , int[][] dp )
    {
        
        
        
        if( m == 0 || n == 0 )
        {
            return 0;
        }
        
        
        if( dp[m][n] != -1 )
        {
            return dp[m][n];
        }
        
        if( a.charAt(m-1) == b.charAt(n-1) )
        {
            dp[m][n] = 1+ LCS(a,b,m-1,n-1,dp);
            return dp[m][n];
        }
        
        dp[m][n] = Math.max( LCS(a,b,m,n-1,dp) , LCS(a,b,m-1,n,dp)  );
        
        return dp[m][n];
        
    }
}