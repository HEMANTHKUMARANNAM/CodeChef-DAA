import java.util.*;

class Main {
    static void backtrack(int idx, int[] a, int x, List<Integer> subset, List<List<Integer>> ans) {
        if (idx == a.length) { // No more integers to consider
            // Write your code here
            
            int s =0;
            
            for(int i =0 ; i< subset.size() ; i++)
            {
                s += subset.get(i);
            }
            
            
            if( s==x )
            {
                ans.add(  new ArrayList<>(subset)  );
            }
            
            
            
            
            return;
        }
        backtrack(idx + 1, a, x, subset, ans); // Don't take the i-th integer

        subset.add(a[idx]);
        backtrack(idx + 1, a, x, subset, ans); // Take the i-th integer
        subset.remove(subset.size() - 1);
    }

    static List<List<Integer>> subsetSum(int[] a, int x) {
        List<Integer> subset = new ArrayList<>(); // Creating an empty subset
        List<List<Integer>> ans = new ArrayList<>(); // To store all the subsets

        backtrack(0, a, x, subset, ans);

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        List<List<Integer>> subsets = subsetSum(a, x);
        for (List<Integer> subset : subsets) {
            Collections.sort(subset);
        }
        subsets.sort(Comparator.comparing(Object::toString));

        for (List<Integer> subset : subsets) {
            for (int val : subset) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
