import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
      int[]  nums = {1,2,3,4};
      int [] ans = productExceptSelf(nums);
     for(int n : ans){
         System.out.println(n);
     }
    }

    static int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        Arrays.fill(output, 1);
        for(int i=0; i< nums.length; i++){
            for(int j=0; j< nums.length; j++){
                if(i != j){
                    output[i] *= nums[j];
                }
            }
        }
        return output;
    }
}
