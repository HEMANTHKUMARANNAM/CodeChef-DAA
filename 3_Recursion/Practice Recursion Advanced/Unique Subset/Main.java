import java.util.*;

public class Main {
    public static void backtrack(int[] multiset, int start, List<Integer> path, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(path));
        for (int i = start; i < multiset.length; ++i) {
            if (i > start && multiset[i] == multiset[i - 1]) {
                continue;
            }
            path.add(multiset[i]);
            backtrack(multiset, i + 1, path, subsets);
            path.remove(path.size() - 1);
        }
    }

    public static List<List<Integer>> uniqueSubsets(int[] multiset) {
        Arrays.sort(multiset);
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(multiset, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    public static void printSubsets(List<List<Integer>> subsets) {
        for (List<Integer> subset : subsets) {
            System.out.print("[");
            for (int i = 0; i < subset.size(); ++i) {
                System.out.print(subset.get(i));
                if (i < subset.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] multiset = new int[n];
        for (int i = 0; i < n; ++i) {
            multiset[i] = scanner.nextInt();
        }
        List<List<Integer>> result = uniqueSubsets(multiset);
        printSubsets(result);
    }
}