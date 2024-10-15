import java.util.*;

class Codechef {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 
        
        while (T-- > 0) {
            int N = sc.nextInt(); 
            int[] weights = new int[N];
            int[] positions = new int[N];
            int[] jumps = new int[N];
            
        
            for (int i = 0; i < N; i++) {
                weights[i] = sc.nextInt();
            }
      
            for (int i = 0; i < N; i++) {
                jumps[i] = sc.nextInt();
            }
            
    
            for (int i = 0; i < N; i++) {
                positions[i] = i; 
            }
            
            Frog[] frogs = new Frog[N];
            
            for (int i = 0; i < N; i++) {
                frogs[i] = new Frog(weights[i], positions[i], jumps[i]);
            }
            
            Arrays.sort(frogs, Comparator.comparingInt(f -> f.weight));
            
            int totalHits = 0;
            
            for (int i = 1; i < N; i++) {
                while (frogs[i].position <= frogs[i - 1].position) {
                    frogs[i].position += frogs[i].jump; 
                    totalHits++; 
                }
            }
            
            System.out.println(totalHits);
        }
        
        sc.close();
    }
    
    static class Frog {
        int weight;
        int position;
        int jump;
        
        Frog(int weight, int position, int jump) {
            this.weight = weight;
            this.position = position;
            this.jump = jump;
        }
    }
}
