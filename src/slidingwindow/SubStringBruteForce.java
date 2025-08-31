package slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class SubStringBruteForce {
    public static void main(String[] args) {
        String s = "abc";
        List<String> res = findSubStrings(s);
        for(String i:res){
            System.out.println(i+" ");
        }
    }

    private static List<String> findSubStrings(String s) {
        List<String> res = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                // subString function takes starting index and ending index as index+1 as parameter
                res.add(s.substring(i, j+1));
            }
        }
        return res;
    }
}
