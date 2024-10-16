import java.util.*;
import java.lang.*;
import java.io.*;



class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++)
        {
            int boxes = sc.nextInt();
            int cc = sc.nextInt();
            
            int[] colors = new int[cc];
            
            for(int j = 0; j < cc; j++ )
            {
                colors[j] = sc.nextInt();
            }
            
            myfun(boxes, colors);
        }
    }
    
    public static void myfun(int n, int[] colors)
    {
        int t =0;
        int sum =0;
        
        for(int i =0 ; i< colors.length ; i++ )
        {
            if( colors[i] == n )
            {
                t++;
            }
            else
            {
                sum += colors[i];
            }
        }
        
        int kumar = colors.length-t;
        
        float meow = (float)sum/n;
        
        if( meow >= kumar-1   )
        {
            System.out.println( sum - (kumar-1)*n   );
        }
        else
        {
            System.out.println(0);
        }
        
        

        
        
    }
}
