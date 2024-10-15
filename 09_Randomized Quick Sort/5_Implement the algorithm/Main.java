
// try in python showing time limit exceeded


import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void main(String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++)
        {
            int n = sc.nextInt();
            
            ArrayList<Integer> list = new ArrayList<>();
            
            for(int j =0 ; j< n ; j++)
            {
                list.add(sc.nextInt());
            }
            
            ArrayList<Integer> sorted = quicksort(list);
            
            for(int j =0 ; j< n ; j++)
            {
                System.out.print(sorted.get(j) + " ");
            }
            
            System.out.println("");
            

        }


    }


    public static ArrayList<Integer> quicksort( ArrayList<Integer> list )
    {
        
        if( list.size() <=1 )
        {
            return list;
        }
        
        Random random = new Random();
        
        int rand_num = random.nextInt( list.size() );
        
        int pivot = list.get( rand_num );
        
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        
        
        for(int i =0 ; i< list.size() ; i++ )
        {
            if( i == rand_num )
            {
                continue;
            }
            if( list.get(i) < pivot )
            {
                left.add( list.get(i) );
            }
            else
            {
                right.add( list.get(i) );
            }
        }
        
        
        
        ArrayList<Integer> sorted = new ArrayList<>();
        
        
        sorted.addAll( quicksort(left) );
        sorted.add(pivot);
        
        sorted.addAll( quicksort(right) );
        
        return sorted;
        
        
        

    }
}