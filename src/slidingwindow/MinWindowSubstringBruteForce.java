package slidingwindow;

public class MinWindowSubstringBruteForce {
    public static String minWindow(String s, String t) {
        int m = s.length();
        String result = "";
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j <= m; j++) {
                String sub = s.substring(i, j);
                if (containsAll(sub, t)) {
                    if (sub.length() < minLen) {
                        minLen = sub.length();
                        result = sub;
                    }
                }
            }
        }
        return result;
    }

    private static boolean containsAll(String sub, String t) {
        int[] freq = new int[128];
        for (char c : sub.toCharArray()) {
            freq[c]++;
        }
        for (char c : t.toCharArray()) {
            freq[c]--;
            if (freq[c] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // BANC
    }
}
