public class Q1422_MaximumScoreAfterSplittingString {
    public static void main(String[] args) {
        String s = "10000000";
        var res = new Q1422_MaximumScoreAfterSplittingString().new Solution().maxScore(s);
        System.out.println("ANSWER = " + res);

    }

    class Solution {
        public int maxScore(String s) {
            char[] charray = s.toCharArray();
            int left = charray[0] == '0' ? 1 : 0;
            int right = charray[charray.length - 1] == '1' ? 1 : 0;

            for (int i = charray.length - 2; i > 0; i--) {
                if (charray[i] == '1') {
                    right++;
                }
            }
            int sum = left + right;
            int temp = left + right;

            for (int i = 1; i < charray.length - 1; i++) {
                if (charray[i] == '0') {
                    temp++;
                } else {
                    temp--;
                }
                if (temp > sum) {
                    sum = temp;
                }
            }
            return sum;
        }
    }
}
