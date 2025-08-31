package slidingwindow;

public class MinimumSizeSubarraySum {
  public static void main(String[] args) {
    int target = 7;
    int[] nums = {2,3,1,2,4,3};
    System.out.println(minSubArrayLen1(target, nums));
  }

  //brute force approach
  static int minSubArrayLen1(int target, int[] nums) {
    int n = nums.length;
    int minLen = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = i; j < n; j++) {
        sum += nums[j];
        if (sum >= target) {
          minLen = Math.min(minLen, j - i + 1);
          break; // no need to extend this subarray
        }
      }
    }

    return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
  }



// sliding window and two pointers
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