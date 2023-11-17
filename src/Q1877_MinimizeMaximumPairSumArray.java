import java.util.Arrays;

public class Q1877_MinimizeMaximumPairSumArray {
    public static void main(String[] args) {
        var result = new Q1877_MinimizeMaximumPairSumArray().new Solution().minPairSum(new int[] { 3, 5, 4, 2, 4, 6 });
        System.out.println("ANSWER " + result);
    }

    class Solution {
        public int minPairSum(int[] nums) {
            Arrays.sort(nums);

            int left = 0, right = nums.length - 1, maxSum = 0, cursum;

            while (right > left) {
                cursum = nums[left++] + nums[right--];
                if (cursum > maxSum) {
                    maxSum = cursum;
                }
            }
            return maxSum;
        }
    }
}
