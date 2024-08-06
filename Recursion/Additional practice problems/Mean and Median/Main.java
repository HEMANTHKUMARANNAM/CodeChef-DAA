import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {

            int mean = sc.nextInt();
            int median = sc.nextInt();

            Numbers(mean, median);

        }

    }

    public static void Numbers(int mean, int median) {

        int b = median;

        int c = median;

        int a = 3 * mean - b - c;

        System.out.println(a + " " + b + " " + c);

    }

}
