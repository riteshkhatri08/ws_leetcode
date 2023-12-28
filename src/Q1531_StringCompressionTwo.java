public class Q1531_StringCompressionTwo {

    public static void main(String[] args) {
        var result = new Q1531_StringCompressionTwo().new Solution()
                .getLengthOfOptimalCompression("aaabssbbssbscbccbsaeeirurq", 1);
    }

    class Solution {
        public int getLengthOfOptimalCompression(String s, int k) {
            if (k == 0) {
                return s.length();
            }

            return k;
        }
    }
}
