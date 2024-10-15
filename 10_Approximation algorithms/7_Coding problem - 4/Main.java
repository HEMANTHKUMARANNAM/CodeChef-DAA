import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Codechef {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int W = scanner.nextInt();
            int Wr = scanner.nextInt();
            long totalWeight = Wr;
            Map<Integer, Integer> weightMap = new HashMap<>();
            
            for (int i = 0; i < N; i++) {
                int w = scanner.nextInt();
                weightMap.put(w, weightMap.getOrDefault(w, 0) + 1);
            }
            
            for (Map.Entry<Integer, Integer> entry : weightMap.entrySet()) {
                int weight = entry.getKey();
                int count = entry.getValue();
                int pairs = count / 2;
                totalWeight += pairs * 2L * weight;
            }
            
            if (totalWeight >= W) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        scanner.close();
    }
}
