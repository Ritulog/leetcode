public class RemoveElement {
    public static void main(String[] args) {
      int[] nums = {2,3,3,2,2};
      int val = 3;
      System.out.println(removeElement1(nums,val));
    }

    static int removeElement(int[] nums, int val){
        int count=0;
        for(int i=0; i< nums.length; i++){
            if(nums[i] !=val){
                nums[count]=nums[i];
                count++;
            }
        }
      return count;
    }

    static int removeElement1(int[] nums, int val) {
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=val){
                nums[i++]=nums[j];
            }
        }
        return i;
    }
}
