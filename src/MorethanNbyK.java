import java.util.HashMap;
import java.util.Map;

public class MorethanNbyK {
    public static void morethanNbyK(int[] arr, int k)
    {
        int n = arr.length;
        int x = n / k;

        // HashMap initialization
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            freq.put(arr[i],
                     freq.getOrDefault(arr[i], 0) + 1);
        }

        // Traversing the map
        for (Map.Entry<Integer, Integer> entry :
             freq.entrySet()) {

            // Checking if value of a key-value pair
            // is greater than x (where x=n/k)
            if (entry.getValue() > x) {

                // Print the key of whose value is greater
                // than x
                System.out.println(entry.getKey());
            }
        }
    }

    public static void main(String[] args)
    {
        int[] arr = { 3, 4, 2, 2, 1, 2, 3, 3 };
        int k = 4;
        morethanNbyK(arr, k);
    }
}