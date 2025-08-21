package twopointers;

public class IsPalindrome {
    public static void main(String[] args) {
     String s = "121";
     String s1 = "reviver";
     String s2 = "A man, a plan, a canal: Panama";
     System.out.println(isPalindrome1(s1));
     System.out.println(isPalindrome(s2));
    }


    static boolean isPalindrome1(String s) {
        //Get the left and right pointer
        int left = 0;
        int right = s.length() - 1;

        //start a loop and compare charcater
        while(left < right){
            // if same, move both pointers
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }
            // If not, simply return false
            else{
                return false;
            }
        }
        // If we came out of the loop, then all
        //character have matched return false
        return true;
    }



   // for alphamuric and space comma
    static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // skip non-alphanumeric from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // skip non-alphanumeric from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // compare after converting to lowercase
            char l = Character.toLowerCase(s.charAt(left));
            char r = Character.toLowerCase(s.charAt(right));

            if (l != r) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

}
