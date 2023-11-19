import java.util.Arrays;

public class Q1887_ReductionOperationsMakeArrayElementsEqual {
    public static void main(String[] args) {

        int[] nums = new int[] { 1, 2, 2, 4, 2, 9, 3, 3, 2, 1, 5 };
        var result = new Q1887_ReductionOperationsMakeArrayElementsEqual().new Solution().reductionOperations(nums);
        System.out.println("ANSWER = " + result);

    }

    class Solution {

        public int reductionOperations(int[] nums) {
            Arrays.sort(nums);
            int operations = 0;
            {
                int left = nums.length - 1;
                int right = left;
                while (left > -1) {
                    // System.out.println("WINDOW SIZE = " + (nums.length - left));
                    if (nums[left] != nums[right]) {
                        operations += nums.length - left - 1;
                        right = left;
                    }
                    left--;
                }
            }
            return operations;
        }
    }
}
