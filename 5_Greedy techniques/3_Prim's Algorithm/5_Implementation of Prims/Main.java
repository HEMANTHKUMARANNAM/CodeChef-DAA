import java.util.*;

class main {

    static final int N = 10;
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
        // Stores weight, newly added vertex and parent vertex
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.add(new int[]{0, source}); // push the starting vertex to the pq

        while (!pq.isEmpty()) {
            int[] node = pq.poll();

            int v = node[1];

            // If vertex is already processed, continue
            if (vis.get(v)) {
                continue;
            }

            vis.set(v, true); // Mark vertex as processed

            System.out.println("Adding vertex " + v + " to the MST");

            if (node.length == 3) {
                MST.add(new Pair(node[2], v)); // Push the edge into the MST;
            }

            for (Pair edge : adj.get(v)) {
                pq.add(new int[]{edge.second, edge.first, v});
            }
        }

        System.out.println("\nEdgelist of MST is:");

        for (Pair edge : MST) {
            System.out.println(edge.first + " " + edge.second);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            vis.add(false);
            adj.add(new ArrayList<>());
        }

        // Adjacency list
        adj.get(1).add(new Pair(2, 4));
        adj.get(2).add(new Pair(1, 4));

        adj.get(1).add(new Pair(3, 4));
        adj.get(3).add(new Pair(1, 4));

        adj.get(2).add(new Pair(3, 2));
        adj.get(3).add(new Pair(2, 2));

        adj.get(3).add(new Pair(4, 3));
        adj.get(4).add(new Pair(3, 3));

        adj.get(3).add(new Pair(5, 2));
        adj.get(5).add(new Pair(3, 2));

        adj.get(3).add(new Pair(6, 4));
        adj.get(6).add(new Pair(3, 4));

        adj.get(4).add(new Pair(6, 3));
        adj.get(6).add(new Pair(4, 3));

        adj.get(5).add(new Pair(6, 3));
        adj.get(6).add(new Pair(5, 3));

        prims(1, 6);
    }
}
