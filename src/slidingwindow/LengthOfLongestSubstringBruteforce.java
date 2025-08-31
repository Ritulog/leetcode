package slidingwindow;

class LengthOfLongestSubstringBruteforce {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;

        // check all substrings
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (allUnique(s, i, j)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    // helper to check if substring s[i..j] has all unique chars
    private boolean allUnique(String s, int start, int end) {
        boolean[] seen = new boolean[128]; // ASCII size
        for (int k = start; k <= end; k++) {
            char c = s.charAt(k);
            if (seen[c]) return false; // already present
            seen[c] = true;
        }
        return true;
    }
}
