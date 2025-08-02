public class ProductExceptSelf238 {
    public static void main(String[] args) {
      int[]  nums = {2,8,9,6};
        int [] ans = productExceptSelf(nums);
        for(int n : ans){
            System.out.println(n);
        }
    }

    static int[] productExceptSelf(int[] nums) {
        int[] left = new int [nums.length];
        int[] right = new int [nums.length];

        left[0] =1;
        for(int i=1; i<nums.length; i++){
            System.out.println("cccc "+left[i-1] +"  "+nums[i-1]);
            left[i] = left[i-1] * nums[i-1];
        }

        right[nums.length -1] = 1;
        for(int i=nums.length-2; i> -1; i--){
            right[i] = right[i+1] * nums[i+1];
        }

        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}
