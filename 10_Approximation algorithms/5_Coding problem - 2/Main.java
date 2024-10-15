import java.util.*;

class Codechef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        List<Long> results = new ArrayList<>();
        
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            long H = sc.nextLong();
            
            long[] A = new long[N];
            long[] B = new long[M];
            
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextLong();
            }
            
            for (int i = 0; i < M; i++) {
                B[i] = sc.nextLong();
            }
            
            Arrays.sort(A);
            Arrays.sort(B);
            
            long maxEnergy = 0;
            int minNM = Math.min(N, M);
            
            for (int j = 0; j < minNM; j++) {
                maxEnergy += Math.min(A[N - 1 - j], B[M - 1 - j] * H);
            }
            
            results.add(maxEnergy);
        }
        
        for (long res : results) {
            System.out.println(res);
        }
        
        sc.close();
    }
}
