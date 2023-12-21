public class Q2706_BuyTwoChocolates {
    public static void main(String[] args) {
        int points[] = new int[10];
        var result = new Q2706_BuyTwoChocolates().new Solution().buyChoco(points, 10);

        System.out.println("ANSWER  = " + result);
    }

    class Solution {
        public int buyChoco(int[] prices, int money) {

            {
                int i;
                if (prices[0] > prices[1]) {
                    i = prices[0];
                    prices[0] = prices[1];
                    prices[1] = i;
                }
                for (i = 2; i < prices.length; i++) {
                    if (prices[i] < prices[0]) {
                        prices[1] = prices[0];
                        prices[0] = prices[i];

                    } else if (prices[i] < prices[1]) {
                        prices[1] = prices[i];
                    }
                }
                prices[1] = prices[0] + prices[1];
                prices[0] = money - prices[1];
            }
            return prices[0] < 0 ? money : prices[0];
        }
    }
}
