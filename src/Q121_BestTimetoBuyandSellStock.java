public class Q121_BestTimetoBuyandSellStock {

    public static void main(String[] args) {
        int prices[] = new int[] { 7, 1, 5, 3, 6, 4 };
        var result = new Q121_BestTimetoBuyandSellStock().new Solution().maxProfit(prices);
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        int maxProfit = 0;
        int prices[] = null;

        public int maxProfit(int[] prices) {
            int maxProfit = 0, left = 0, right = 0;
            while (right < prices.length) {
                if (prices[right] > prices[left]) {
                    if (prices[right] - prices[left] > maxProfit) {
                        maxProfit = prices[right] - prices[left];
                    }
                } else {
                    left = right;
                }
                right++;
            }
            return maxProfit;
        }
    }

}
