public class RemoveDuplicate26 {
    public static void main(String[] args) {
        int[] nums2={1,1,2};
        System.out.println(removeD(nums2));
    }
    static int removeD(int[] nums){
        int count =0;
        for(int i=0; i< nums.length; i++){
            if(i< nums.length-1 &&  nums[i] == nums[i+1]){
                continue;
            }
            else{
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}
