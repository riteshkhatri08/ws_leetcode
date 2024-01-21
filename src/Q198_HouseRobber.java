public class Q198_HouseRobber {

    public static void main(String[] args) {
        int houses[] = new int[] { 2, 7, 9, 3, };

        var result = new Q198_HouseRobber().new Solution().rob(houses);
        System.out.println("ANSWER  =" + result);
    }

    class Solution {
        public int rob(int[] nums) {
            int dp[] = new int[nums.length];

            // BASE CASES
            if (nums.length > 1) {
                dp[0] = nums[0];
                dp[1] = nums[1];
            } else {
                return nums[0];
            }
            if (nums.length > 2) {
                dp[2] = nums[0] + nums[2];
            }

            for (int i = 3; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
            }
            // if (dp[nums.length-1] > dp[nums.length-2]){
            // System.out.println("RETURNING - " + (nums.length-1));
            // }else{
            // System.out.println("RETURNING - " + (nums.length-2));
            // }
            return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
        }

        /*
         * INDUCTION FUNCTION
         * Max(n+2 , n+3)
         * 
         * int [] dp = new int [nums.length+1];
         * f(n) = Max(f(n-2) ,f(n(n-3)));
         * f(n-1) = Max(f(n-3,(n-4)));
         * 
         * f(1) = nums[1];
         * f(0) = nums[0];
         * f(2) = nums[0] + nums[2];
         * 
         */
    }

}