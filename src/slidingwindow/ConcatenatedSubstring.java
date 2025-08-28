package slidingwindow;

import java.util.*;

public class ConcatenatedSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen) return result;

        // Build frequency map of words
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // Try every possible offset within wordLen
        for (int i = 0; i < wordLen; i++) {
            int left = i, count = 0;
            Map<String, Integer> windowMap = new HashMap<>();

            for (int right = i; right + wordLen <= s.length(); right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (wordMap.containsKey(word)) {
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    count++;

                    // If a word occurs too many times, shrink from left
                    while (windowMap.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // Found a valid window
                    if (count == wordCount) {
                        result.add(left);
                        // Move left forward
                        String leftWord = s.substring(left, left + wordLen);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                } else {
                    // Reset window
                    windowMap.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return result;
    }

    // Example usage
    public static void main(String[] args) {
        ConcatenatedSubstring solver = new ConcatenatedSubstring();
        System.out.println(solver.findSubstring("barfoothefoobarman", new String[]{"foo","bar"})); // [0,9]
        System.out.println(solver.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"})); // []
        System.out.println(solver.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"})); // [6,9,12]
    }
}
