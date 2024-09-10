import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double wmax = sc.nextDouble();

        Pair[] a = new Pair[n];
        for (int i = 0; i < n; i++) {
            double w = sc.nextDouble();
            double v = sc.nextDouble();
            double value_per_weight = w / v;

            a[i] = new Pair(value_per_weight, w);
        }

        Arrays.sort(a, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Double.compare(p1.first, p2.first);
            }
        });

        double ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            ans += Math.min(wmax, a[i].second) * a[i].first;
            wmax -= Math.min(wmax, a[i].second);
        }

        System.out.printf("%.16f\n", ans);
    }

    static class Pair {
        double first;
        double second;

        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }
    }
}




// actually code is wrong instead of v/w they taken w/v. i hava reported