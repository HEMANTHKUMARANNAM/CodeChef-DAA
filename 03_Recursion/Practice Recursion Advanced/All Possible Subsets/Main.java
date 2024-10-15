import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void allPossibleSubsets(List<Integer> arr, int curIndex, List<Integer> curSubset, List<List<Integer>> allSubsets) {
        if (curIndex == arr.size()) {
            List<Integer> newSet = new ArrayList<>(curSubset);
            allSubsets.add(newSet);
            return;
        }
        curSubset.add(arr.get(curIndex));
        allPossibleSubsets(arr, curIndex + 1, curSubset, allSubsets);
        curSubset.remove(curSubset.size() - 1);
        allPossibleSubsets(arr, curIndex + 1, curSubset, allSubsets);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            arr.add(scanner.nextInt());
        }
        List<Integer> curSubset = new ArrayList<>();
        List<List<Integer>> allSubsets = new ArrayList<>();
        allPossibleSubsets(arr, 0, curSubset, allSubsets);
        Collections.sort(allSubsets, (a, b) -> {
            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                int cmp = Integer.compare(a.get(i), b.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return Integer.compare(a.size(), b.size());
        });
        for (List<Integer> subset : allSubsets) {
            for (int num : subset) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
