import java.util.Arrays;

public class Q1913_MaximumProductDifferenceBetweenTwoPairs {

    public static void main(String[] args) {
        int[] nums = new int[] { 5, 6, 2, 7, 4 };
        var result = new Q1913_MaximumProductDifferenceBetweenTwoPairs().new Solution().maxProductDifference(nums);
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        public int maxProductDifference(int[] nums) {
            Arrays.sort(nums);
            return (nums[nums.length - 2] * nums[nums.length - 1]) - (nums[0] * nums[1]);
        }
    }
}
