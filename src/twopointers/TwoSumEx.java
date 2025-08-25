package twopointers;

class TwoSumEx {
    public int[] twoSum(int[] numbers, int target) {
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
