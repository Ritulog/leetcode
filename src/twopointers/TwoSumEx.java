package twopointers;

class TwoSumEx {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] index = twoSum(numbers, target);
        for( int idx : index){
            System.out.println(idx);
        }
    }
    static int[] twoSum(int[] numbers, int target) {
        int left = 0; 
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            
            if (sum == target) {
                // Return 1-based indices
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        // This will never be reached because problem guarantees one solution
        return new int[]{-1, -1};
    }
}
