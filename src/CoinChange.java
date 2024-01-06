public class CoinChange {
    public static void main(String[] args) {
        var obj = new CoinChange();
        int n = 10;
        int[] coins = new int[] { 1, 2, 5, 10 };

        var resu = obj.changeNonUniqueWays(n, coins);
        System.out.println("changeNonUniqueWays  of " + n + " = " + resu);

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
