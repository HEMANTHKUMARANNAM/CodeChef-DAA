import java.util.*;

class main {

    // Check if 'next' vertex can be added after vertex 'v'
    static boolean check(int v, int next, ArrayList<Integer> circuit, boolean[][] mat) {
        // Check if 'next' vertex is adjacent to 'v'
        if (!mat[v][next]) {
            return false; // Not adjacent, so not a valid move
        }
        
        // Check if 'next' vertex has already been visited (except if it's the starting vertex at the end)
        if (circuit.contains(next)) {
            return false; // Already visited, so not a valid move
        }

        return true;
    }

    // Backtracking function to find Hamiltonian circuits
    static void backtrack(int v, int n, ArrayList<Integer> circuit, ArrayList<ArrayList<Integer>> ans, boolean[][] mat) {
        if (circuit.size() == n) { // Circuit is completed
            if (mat[circuit.get(0)][v]) { // Check if cycle is completed, i.e., first and last are adjacent
                circuit.add(circuit.get(0)); // Complete the cycle
                ans.add(new ArrayList<>(circuit)); // Store the valid Hamiltonian cycle
                circuit.remove(circuit.size() - 1); // Backtrack: remove the last added vertex (start vertex)
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            // Check if we can add vertex 'i' after 'v'
            if (!check(v, i, circuit, mat)) {
                continue;
            }

            // If valid, add the next vertex to the current circuit and continue exploring
            circuit.add(i);
            backtrack(i, n, circuit, ans, mat);
            circuit.remove(circuit.size() - 1); // Backtrack: remove the vertex added in this step
        }
    }

    // Function to find all Hamiltonian Circuits
    static ArrayList<ArrayList<Integer>> hamiltonianCircuit(int n, boolean[][] mat) {
        ArrayList<Integer> circuit = new ArrayList<>(); // Initially empty circuit
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); // To store all the circuits

        for (int i = 1; i <= n; i++) { // Fix the starting vertex
            circuit.add(i); // Add i to circuit
            backtrack(i, n, circuit, ans, mat);
            circuit.remove(circuit.size() - 1); // Remove i from circuit
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Number of vertices
        int m = scanner.nextInt(); // Number of edges

        // Adjacency matrix
        boolean[][] mat = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            mat[a][b] = true;
            mat[b][a] = true; // Undirected graph
        }

        // Find all Hamiltonian Circuits
        ArrayList<ArrayList<Integer>> cycles = hamiltonianCircuit(n, mat);

        // Sort the Hamiltonian circuits lexicographically
        cycles.sort((x, y) -> x.toString().compareTo(y.toString()));

        // Output each circuit
        for (ArrayList<Integer> x : cycles) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
