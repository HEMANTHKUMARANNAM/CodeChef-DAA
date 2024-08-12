import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String ans[] = new String[t];
        for (int i = 0; i < t; i++) {

            long app = sc.nextLong();
            long box = sc.nextLong();

            ans[i] = apples(app, box);
        }

        for (int i = 0; i < t; i++) {
            System.out.println(ans[i]);
        }

    }

    public static String apples(long app, long box) {
        if (box == 1) {
            return "NO";
        }

        if ((app / box) % box == 0) {
            return "NO";
        }

        return "YES";

    }
}
