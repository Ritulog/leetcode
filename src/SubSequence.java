public class SubSequence {
    public static void main(String[] args) {
        String str = "abc";
        int idx = 0;
        String newString = "";
        subSequences(str, idx,newString);
    }

    private static void subSequences(String str, int idx, String newString) {
        if(idx == str.length()){
            System.out.println(newString);
            return;
        }
        char ch = str.charAt(idx);
        subSequences(str,idx+1,newString+ch);
        subSequences(str, idx+1, newString);
    }
}
