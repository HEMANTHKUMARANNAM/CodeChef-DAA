import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int ans[] = new int[t];
        for (int i = 0; i < t; i++) {

            int r = sc.nextInt();
            int c = sc.nextInt();

            int a[][] = new int[r][c];

            for (int k = 0; k < r; k++) {
                String l = sc.next();
                String[] v = l.split("");
                for (int j = 0; j < v.length; j++) {
                    a[k][j] = Integer.parseInt(v[j]);
                }
            }

            ans[i] = combination(a);

        }

        for (int i = 0; i < t; i++) {
            System.out.println(ans[i]);
        }

    }

    public static int combination(int[][] a) {

        int ans = 0;

        for (int j = 0; j < a[0].length; j++) {
            int n = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i][j] == 1) {
                    n++;
                }
            }

            if (n >= 2) {
                ans += n * (n - 1) / 2; // nc2
            }

        }

        return ans;

    }

}
