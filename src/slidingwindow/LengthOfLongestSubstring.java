package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;

class LengthOfLongestSubstring {
    public static void main(String[] args) {
       String  s = "abcabcbb";
       System.out.println(lengthOfLongestSubstring(s));
    }

    //using set
    static int lengthOfLongestSubstring(String s) {
        int windowStart = 0;
        int windowEnd = 0;
        int n = s.length();
        HashSet set = new HashSet<>();
        int maxLen = Integer.MIN_VALUE;
        while(windowEnd < n){
            char ch = s.charAt(windowEnd);
            if(set.contains(ch)){
                //shrinking
                while(windowStart < windowEnd && set.contains(ch)){
                    set.remove(s.charAt(windowStart));
                    windowStart++;
                }
            }
            set.add(ch);
            maxLen = Math.max(maxLen, windowEnd - windowStart+1);
            windowEnd++;
        }
        return (maxLen == Integer.MIN_VALUE) ? 0 : maxLen;
    }

    //using map
    static int lengthOfLongestSubstring1(String s) {
        int windowStart = 0;
        int windowEnd = 0;
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        while(windowEnd < n){
            char ch = s.charAt(windowEnd);
            if(map.containsKey(ch) && map.get(ch)>= windowStart){
                //shrinking
               windowStart = map.get(ch)+1;
            }
            map.put(ch,windowEnd);
            maxLen = Math.max(maxLen, windowEnd - windowStart+1);
            windowEnd++;
        }
        return (maxLen == Integer.MIN_VALUE) ? 0 : maxLen;
    }
}