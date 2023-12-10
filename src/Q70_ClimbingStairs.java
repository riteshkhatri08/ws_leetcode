public class Q70_ClimbingStairs {

    public static void main(String[] args) {
        var result = new Q70_ClimbingStairs().new Solution().climbStairs(10);
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        int[] dp;

        public int climbStairs(int n) {

            // dp = new int[n + 1];
            // dp[0] = 1;
            // dp[1] = 1;
            int a = 1;
            int b =1;
            int c = 1;
            // Instead of recursive approach we can use iteration here
            for (int i = 2; i <= n; i++) {
                // Since we are using only previous 2 values of i we dont need to store all
                // values of i in dp
                // this will consume o(1) instead of O(n) memory
                // dp[i] = dp[i - 1] + dp[i - 2];
                c = a+b;
                a=b;
                b=c;
            }
            // return climbDown(n);
            // return dp[n];
            return c;
        }

        // public int climbDown(int n){

        // if (dp[n] != 0){
        // return dp[n];
        // }
        // dp[n-1] = climbDown(n-1);
        // dp[n-2] = climbDown(n-2);
        // return dp[n-2] + dp[n-1];
        // }
    }
}
