package slidingwindow;

public class MinimumWindowSubstringBruteForce {

    // Method to check if substring contains all characters of t
    static boolean containsAll(String sub, String t) {
        int[] freqSub = new int[128]; // ASCII frequency
        int[] freqT = new int[128];

        for (char c : sub.toCharArray()) freqSub[c]++;
        for (char c : t.toCharArray()) freqT[c]++;

        // Compare frequencies
        for (int i = 0; i < 128; i++) {
            if (freqSub[i] < freqT[i]) return false;
        }
        return true;
    }

    // Brute force solution
    static String minWindowBruteForce(String s, String t) {
        int m = s.length();
        String result = "";

        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                String sub = s.substring(i, j + 1);

                if (containsAll(sub, t)) {
                    if (result.equals("") || sub.length() < result.length()) {
                        result = sub;
                    }
                }
            }
        }
        return result;
    }

    // Main method to test
    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println("Input: s = " + s1 + ", t = " + t1);
        System.out.println("Output: " + minWindowBruteForce(s1, t1)); // Expected "BANC"

        String s2 = "a";
        String t2 = "a";
        System.out.println("\nInput: s = " + s2 + ", t = " + t2);
        System.out.println("Output: " + minWindowBruteForce(s2, t2)); // Expected "a"

        String s3 = "a";
        String t3 = "aa";
        System.out.println("\nInput: s = " + s3 + ", t = " + t3);
        System.out.println("Output: " + minWindowBruteForce(s3, t3)); // Expected ""
    }
}
