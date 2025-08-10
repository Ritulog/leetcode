import java.util.*;

public class CountElementsMoore {
    public static int countElementsMoore(int[] arr, int k) {
        int n = arr.length;
        if (k < 2) return 0; // No valid majority if k < 2

        // Phase 1: Find potential candidates
        Map<Integer, Integer> candidates = new HashMap<>();
        for (int num : arr) {
            if (candidates.containsKey(num)) {
                candidates.put(num, candidates.get(num) + 1);
            } else if (candidates.size() < k - 1) {
                candidates.put(num, 1);
            } else {
                // Decrement count of all candidates
                Iterator<Map.Entry<Integer, Integer>> it = candidates.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, Integer> entry = it.next();
                    candidates.put(entry.getKey(), entry.getValue() - 1);
                    if (candidates.get(entry.getKey()) == 0) {
                        it.remove();
                    }
                }
            }
        }

        // Phase 2: Validate candidates
        Map<Integer, Integer> actualCount = new HashMap<>();
        for (int num : arr) {
            if (candidates.containsKey(num)) {
                actualCount.put(num, actualCount.getOrDefault(num, 0) + 1);
            }
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : actualCount.entrySet()) {
            if (entry.getValue() > n / k) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 1, 2, 2, 1, 2, 3, 3};
        int k1 = 4;
        System.out.println(countElementsMoore(arr1, k1)); // Output: 2

        int[] arr2 = {2, 3, 3, 2};
        int k2 = 3;
        System.out.println(countElementsMoore(arr2, k2)); // Output: 2

        int[] arr3 = {1, 4, 7, 7};
        int k3 = 2;
        System.out.println(countElementsMoore(arr3, k3)); // Output: 0
    }
}
