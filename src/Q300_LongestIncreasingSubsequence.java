public class Q300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] n = new int[] { 0,1,0,3,2,3 };
        var result = new Q300_LongestIncreasingSubsequence().new Solution().lengthOfLIS(n);
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        int max = 1;
        int[] nums = null;

        public int lengthOfLIS(int[] ns) {
            nums = ns;
            int last = 0;
            int len = 1;
            for (int i = 0; i < ns.length; i++) {
                System.out.println("STARTING for " + i);
                System.out.print(ns[i] + " ");
                last = ns[i];
                len = 1;
                for (int j = i + 1; j < ns.length; j++) {
                    if (ns[j] > last) {
                        last = ns[j];
                        len++;
                        System.out.print(ns[j] + " ");
                    }
                }
                if (len > max) {
                    max = len;
                }
                System.out.println("");
            }
            return max;
        }

        // public void helper(int prev, int cur, int len) {
        // if (cur == nums.length) {
        // System.out.println("REACHED EOA");
        // if (len > max) {
        // max = len;
        // }
        // return;
        // }
        // System.out.println(nums[prev] + " " + nums[cur] + " " + len);

        // if (nums[cur] > nums[prev]) {
        // helper(cur, cur + 1, len + 1);
        // helper(prev, cur + 1, len);

        // } else {
        // helper(prev, cur + 1, len);
        // }

        // }
    }
}
