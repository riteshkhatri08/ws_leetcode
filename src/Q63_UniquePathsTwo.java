public class Q63_UniquePathsTwo {

    public static void main(String[] args) {
        var result = new Q63_UniquePathsTwo().new Solution()
                .uniquePathsWithObstacles(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } });
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        public int uniquePathsWithObstacles(int[][] ob) {
            int m = ob.length;
            int n = ob[0].length;

            int[][] dp = new int[ob.length][ob[0].length];
            dp[0][0] = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (ob[i][j] == 1) {
                        dp[i][j] = 0;
                    } else if (i > 0 && j > 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    } else if (i > 0 && j == 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (i == 0 && j > 0) {
                        dp[i][j] = dp[i][j - 1];
                    }

                }
            }
            return dp[m - 1][n - 1];
        }
    }
}
