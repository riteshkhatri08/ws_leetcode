public class Q1464_MaximumProductOfTwoElementsInArray {

    public static void main(String[] args) {
        int[] nums = new int[] { 10, 11, 23, 1, 5, 6, 788, 212, 2144, 65 };
        var result = new Q1464_MaximumProductOfTwoElementsInArray().new Solution().maxProduct(nums);
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        public int maxProduct(int[] nums) {
            if (nums.length == 2) {
                return (nums[0] - 1) * (nums[1] - 1);
            }
            int larger, smaller;
            if (nums[0] > nums[1]) {
                larger = nums[0];
                smaller = nums[1];
            } else {
                larger = nums[1];
                smaller = nums[0];
            }
            for (int i = 2; i < nums.length; i++) {
                if (nums[i] > larger) {
                    smaller = larger;
                    larger = nums[i];
                } else if (nums[i] > smaller) {
                    smaller = nums[i];
                }
            }

            return (smaller - 1) * (larger - 1);
        }
    }
}
