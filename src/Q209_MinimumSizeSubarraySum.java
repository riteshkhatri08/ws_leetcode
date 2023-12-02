public class Q209_MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = new int[] { 2, 3, 1, 2, 4, 3 };

        var result = new Q209_MinimumSizeSubarraySum().new Solution().minSubArrayLen(target, nums);
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int minsize = Integer.MAX_VALUE;

            int left = 0;
            int right = 0, size = 0;
            int cursum = nums[left];
            while (left < nums.length) {
                if (cursum >= target) {
                    size = right - left + 1;
                    if (size < minsize) {
                        minsize = size;
                    }
                    cursum -= nums[left];
                    left++;
                } else {
                    right++;
                    if (right < nums.length)
                        cursum += nums[right];
                    else
                        break;
                }
            }
            return minsize == Integer.MAX_VALUE ? 0 : minsize;
        }
    }
}
