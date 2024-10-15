import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long ans[] = new long[t];
        for (int i = 0; i < t; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();

            ans[i] = minfun(a, b);

        }

        for (int i = 0; i < t; i++) {
            System.out.println(ans[i]);
        }

    }

    public static long minfun(long a, long b) {
        long x = gcd(a, b);
        return lcm(a, x) - gcd(b, x);
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);

    }

    public static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

}
