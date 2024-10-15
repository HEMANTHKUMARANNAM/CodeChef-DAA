import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        
        final int INF = Integer.MAX_VALUE;
        
        int[][] dist = new int[N][N];
    
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                
                    dist[i][j] = INF;
           
            }
        }
        

        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt() - 1; 
            int v = scanner.nextInt() - 1; 
            int w = scanner.nextInt();
            dist[u][v] = Math.min(dist[u][v], w);
            dist[v][u] = Math.min(dist[v][u], w);
        }
        
        // Apply Floyd-Warshall algorithm
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        
        // Output the result
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i == j)
                {
                    int m = INF;
                    for(int meow =0 ; meow < N ; meow++)
                    {
                        m = Math.min(m,dist[i][meow]);
                    }
                    if(m == INF)
                    {
                        System.out.println("-1 ");
                    }
                    else
                    {
                        System.out.print(m*2 + " ");
                    }
                    
                }
                else if (dist[i][j] == INF) {
                    System.out.print("-1 ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
        
        scanner.close();
    }
}
