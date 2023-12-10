public class Q70_ClimbingStairs {

    public static void main(String[] args) {
        var result = new Q70_ClimbingStairs().new Solution().climbStairs(10);
        System.out.println("ANSWER = " + result);
    }
    class Solution {
        int [] dp;
        public int climbStairs(int n) {
            dp =  new int [n+1];
            dp[0] = 1;
            dp[1] = 1;
          return  climbDown(n);
        }
    
    
        public int climbDown(int n){
    
            if (dp[n] != 0){
                return dp[n];
            }
            dp[n-1] = climbDown(n-1);
            dp[n-2] = climbDown(n-2);
            return  dp[n-2] + dp[n-1];
        }
    }
}
