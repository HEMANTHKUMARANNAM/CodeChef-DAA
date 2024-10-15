import java.util.*;

class main {

    static final int N = 200010;
    static ArrayList<Boolean> vis = new ArrayList<>(N);
    static ArrayList<ArrayList<Pair>> adj = new ArrayList<>(N);

    static ArrayList<Pair> MST = new ArrayList<>(); // Stores the edge list of the Minimum Spanning Tree

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static void prims(int source, int n) { // Source is the starting vertex
        long ans = 0;
        // Write your solution here
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> Integer.compare(a[0],b[0]) );
        
        pq.add( new int[]{0,source} );
        
 
        
        while( pq.size() != 0 )
        {
            
            int[] node = pq.poll();
            
            int v = node[1];
            
            if( vis.get(v) )
            {
                continue;
            }
            
            vis.set(v, true);
            
            if(node.length ==3)
            {
                ans = ans + node[0];
            }
            
            for(Pair edge : adj.get(v) )
            {
                pq.add(new int[] { edge.second, edge.first , v  }  );
            }
            
            
            
        }
        
        
        
        


        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < N; i++) {
            vis.add(false);
            adj.add(new ArrayList<>());
        }

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for (int i = 0; i <= n; i++) {
            adj.set(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int w = scanner.nextInt();
            adj.get(x).add(new Pair(y, w));
            adj.get(y).add(new Pair(x, w));
        }

        prims(1, n);
    }
}
