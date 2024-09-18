import java.util.*;

class main {

    // Number of vertices and adjacency matrix
    static ArrayList<ArrayList<Integer>> hamiltonianCircuit(int n, boolean[][] mat) {
        ArrayList<Integer> circuit = new ArrayList<>(); // Initially empty circuit
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); // To store all the circuits

        // Write your code here

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Adjacency matrix
        boolean[][] mat = new boolean[n + 1][n + 1];
        while (m-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            mat[a][b] = true;
            mat[b][a] = true;
        }
        ArrayList<ArrayList<Integer>> cycles = hamiltonianCircuit(n, mat);
        cycles.sort((x, y) -> {
            return x.toString().compareTo(y.toString());
        });

        for (ArrayList<Integer> x : cycles) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}