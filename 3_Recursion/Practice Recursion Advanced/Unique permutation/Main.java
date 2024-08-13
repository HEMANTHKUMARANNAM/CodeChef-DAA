import java.util.*;

public class Main {
    public static void backtrack(List<Integer> multiset, boolean[] used, List<Integer> path, List<List<Integer>> permutations) {
        if (path.size() == multiset.size()) {
            permutations.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = 0; i < multiset.size(); ++i) {
            if (used[i] || (i > 0 && multiset.get(i).equals(multiset.get(i - 1)) && !used[i - 1])) {
                continue;
            }
            
            path.add(multiset.get(i));
            used[i] = true;
            backtrack(multiset, used, path, permutations);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static List<List<Integer>> uniquePermutations(List<Integer> multiset) {
        Collections.sort(multiset);
        List<List<Integer>> permutations = new ArrayList<>();
        boolean[] used = new boolean[multiset.size()];
        backtrack(multiset, used, new ArrayList<>(), permutations);
        return permutations;
    }

    public static void printPermutations(List<List<Integer>> permutations) {
        for (List<Integer> permutation : permutations) {
            System.out.print("[");
            for (int i = 0; i < permutation.size(); ++i) {
                System.out.print(permutation.get(i));
                if (i < permutation.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> multiset = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            multiset.add(scanner.nextInt());
        }
        List<List<Integer>> result = uniquePermutations(multiset);
        printPermutations(result);
    }
}