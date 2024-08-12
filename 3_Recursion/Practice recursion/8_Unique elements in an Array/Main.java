import java.util.*;

class CodeChef {
    // Update your code below this line
    static List<Integer> findUniqueRecursive(List<Integer> arr, int index, Set<Integer> uniqueSet) {
        
        if(index == arr.size() )
        {
            return new ArrayList<>(uniqueSet);
        }
        
        uniqueSet.add(arr.get(index));
        
        
        
        return findUniqueRecursive(arr,index+1,uniqueSet);


    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            List<Integer> arr = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                arr.add(scanner.nextInt());
            }
            
            List<Integer> uniqueElements = findUniqueRecursive(arr, 0, new HashSet<>());
            
            for (int num : uniqueElements) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}