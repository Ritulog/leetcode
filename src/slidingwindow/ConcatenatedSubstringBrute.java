package slidingwindow;

import java.util.*;

class ConcatenatedSubstringBrute {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int substringLen = wordLen * wordCount;

        if (s.length() < substringLen) return result;

        // Build frequency map of words
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String w : words) {
            wordFreq.put(w, wordFreq.getOrDefault(w, 0) + 1);
        }

        // Check every possible substring of length substringLen
        for (int i = 0; i <= s.length() - substringLen; i++) {
            String sub = s.substring(i, i + substringLen);

            // Split into words of length wordLen
            Map<String, Integer> seen = new HashMap<>();
            for (int j = 0; j < sub.length(); j += wordLen) {
                String w = sub.substring(j, j + wordLen);
                seen.put(w, seen.getOrDefault(w, 0) + 1);
            }

            // Compare maps
            if (seen.equals(wordFreq)) {
                result.add(i);
            }
        }

        return result;
    }
}
