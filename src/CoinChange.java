public class CoinChange {
    public static void main(String[] args) {
        var obj = new CoinChange();
        int n = 7;
        int[] coins = new int[] { 1, 2, 3, 5 };
        int res = 0;
        int t = 3;

        res = obj.changeNonUniqueWays(n, coins);
        System.out.println("changeNonUniqueWays  of " + n + " = " + res);

        res = obj.changeNonUniqueWaysWithExactlyTCoins(n, coins, t);
        System.out.println("changeNonUniqueWaysWithExactlyTCoins  of " + n + " = " + res);

    }

    private int changeNonUniqueWaysWithExactlyTCoins(int n, int[] coins, int t) {
        int dp[][] = new int[n + 1][t + 1];
        dp[0][0] = 1;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= t; j++) {

                if (i > 0 && j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                for (int c : coins) {
                    if (c <= i)
                        dp[i][j] += dp[i - c][j - 1];
                }
            }
            System.out.println(i + " , " + dp[i][t]);
        }
        return dp[n][t];

    }

    public int changeNonUniqueWays(int amount, int[] coins) {
        int dp[] = new int[amount + 1];
        dp[0] = 1;

        for (int i = 1; i <= amount; i++)
            for (int c : coins)
                dp[i] = i >= c ? dp[i] + dp[i - c] : dp[i];
        return dp[amount];
    }
}
