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
            int l = sc.nextInt();
            int d = sc.nextInt();

            Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

            for (int k = 0; k < l; k++) {
                int key = sc.nextInt();
                int v = sc.nextInt();
                mp.put(key, Math.max(mp.getOrDefault(key, 0), v));
            }

            ans[i] = maxtaste(mp);

        }

        for (int i = 0; i < t; i++) {
            System.out.println(ans[i]);
        }

    }

    public static int maxtaste(Map<Integer, Integer> mp) {

        Collection<Integer> c = mp.values();

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());

        pq.addAll(c);

        return pq.poll() + pq.poll();

    }

}
