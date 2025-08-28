package slidingwindow;

public class MinimumSizeSubarraySum {
  public static void main(String[] args) {
    int target = 7;
    int[] nums = {2,3,1,2,4,3};
    System.out.println(minSubArrayLen(target, nums));
  }

  static int minSubArrayLen(int target, int[] nums) {

    int minLenWindow = Integer.MAX_VALUE;
    int currentSum = 0;

    // Start 2 pointers sliding window
    int low = 0;
    int high = 0;
    while(high < nums.length) {

      // Find the current sum and increase window size
      currentSum += nums[high];
      high++;

      // Try to reduce the window size
      while (currentSum >= target) {

        int currentWindowSize = high - low;

        // Update minimum length of window
        minLenWindow = Math.min(minLenWindow, currentWindowSize);

        currentSum -= nums[low];
        low++;
      }
    }

    return minLenWindow == Integer.MAX_VALUE ? 0 : minLenWindow;
  }

}