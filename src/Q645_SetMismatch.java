public class Q645_SetMismatch {
    public static void main(String[] args) {
        int[] nums = new int[] { 2, 2, 3 };
        var answer = new Q645_SetMismatch().new Solution().findErrorNums(nums);
        System.out.println("ANSWER = " + answer[0] + " " + answer[1]);
    }

    class Solution {
        public int[] findErrorNums(int[] nums) {
            int[] ans = new int[2];
            {
                int nums2[] = new int[nums.length + 1];
                for (int i : nums) {
                    nums2[i]++;
                }
                nums = null;
                for (int i = 1; i < nums2.length; i++) {
                    if (nums2[i] == 0) {
                        ans[1] = i;
                        continue;
                    } else if (nums2[i] == 2) {
                        ans[0] = i;
                        continue;
                    }
                }
                nums2 = null;
            }
            System.gc();
            return ans;
        }
    }

}
