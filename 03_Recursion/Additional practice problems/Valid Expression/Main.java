import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int operator = sc.nextInt();
            int value = sc.nextInt();
            expression(operator, value);
        }

    }

    public static void expression(long opp, long val) {

        if (val > opp + 1 || val < -opp + 1) {
            System.out.println("-1");
            return;
        }

        if (val > 1) {
            String ans = "";

            long mul = val - 1;

            for (long i = 0; i < opp - mul; i++) {
                ans += "*";
            }

            for (long i = 0; i < mul; i++) {
                ans += "+";
            }

            System.out.println(ans);
            return;
        }

        if (val == 0) {
            String ans = "";
            for (long i = 0; i < opp - 1; i++) {
                ans = ans + "*";
            }
            System.out.println(ans + "-");
            return;
        }

        if (val == 1) {
            String ans = "";
            for (long i = 0; i < opp; i++) {
                ans += "*";
            }
            System.out.println(ans);
            return;
        }

        if (val <= -1) {
            String ans = "";

            long mul = -val + 1;

            for (long i = 0; i < mul; i++) {
                ans += "-";
            }

            for (long i = 0; i < opp - mul; i++) {
                ans += "*";
            }

            System.out.println(ans);
            return;

        }

    }

}
