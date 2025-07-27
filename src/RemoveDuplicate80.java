public class RemoveDuplicate80 {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 2, 2, 3, 3, 4, 4, 4};
        System.out.println(removeDuplicate2(nums1));
    }

    static int removeDuplicate2(int[] nums){
        int i = 0;
        for(int n:nums){
            if(i<2 || n!=nums[i-2]){
                nums[i++] = n;

            }
        }
        return  i;
    }
}
