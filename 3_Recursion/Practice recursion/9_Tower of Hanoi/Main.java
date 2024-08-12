import java.util.Scanner;

class Main {
    // Update your code below this line
    public static void towerOfHanoi(int n, int source, int destination, int auxiliary) 
    {
        if( n==0 )
        {
            return;
        }
        
        towerOfHanoi(n - 1, source, auxiliary, destination);
        System.out.println("Move disk " + n + " from rod "
                           + source + " to rod "
                           + destination);
        towerOfHanoi(n - 1, auxiliary, destination, source);

    }
    
    public static void solveTowerOfHanoi(int n) {
        System.out.printf("Tower of Hanoi solution for %d disks:%n", n);
        towerOfHanoi(n, 1, 3, 2);
        System.out.printf("Total number of moves: %d%n", (1 << n) - 1);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        solveTowerOfHanoi(n);
        scanner.close();
    }
}