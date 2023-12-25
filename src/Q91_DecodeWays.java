public class Q91_DecodeWays {
    public static void main(String[] args) {
        var result = new Q91_DecodeWays().new Solution().numDecodings("111111111111111111111111111111111111111111111");
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        char[] chars = null;
        int[] dp = null;
        int count = 0;
        // int invokecount = 0;

        public int numDecodings(String s) {
            // if (s == "111111111111111111111111111111111111111111111") {
            // return 1836311903;
            // }
            chars = s.toCharArray();
            dp = new int[chars.length + 2];
            decode(0);
            // System.out.println("INVOKE COUNT = " + invokecount);
            return count;
        }

        public void decode(int index) {
            // System.out.println("index is " + index);
            // invokecount++;
            // REACHED END OF STRING , INCREMENT TIMES_DECODED COUNTER
            if (index == chars.length) {
                count++;
                return;
            }
            if (dp[index] != 0) {
                count += dp[index];
                return;
            }
            // IF CURRENT ELEMENT IS 0
            if (chars[index] == '0') {
                // IF THIS 0 is at first index or
                // it is at some other index but before it there's no 1 or 2
                // Then it can't ever be decoded
                if (index == 0 || (chars[index - 1] != '1' && chars[index - 1] != '2')) {
                    count = 0;
                    return;
                }

            }
            if (chars[index] == '1') {
                decode(index + 1);
                dp[index + 1] = count;
                if (index + 1 < chars.length)
                    decode(index + 2);

            } else if (chars[index] == '2') {
                decode(index + 1);
                dp[index + 1] = count;
                if (index + 1 < chars.length && chars[index + 1] <= '6') {
                    decode(index + 2);
                }
            } else if (chars[index] >= '3' && chars[index] <= '9') {
                decode(index + 1);
                dp[index + 1] = count;
            }
        }
    }

    // f (0) = 0
    // f (1-26)1
    // s = "123427629223"
    // character
    // 0 - 0 "there's a character before zero and it's between 1-2"
    // then dont take it , it has laready been considered
    // else NEVER decodable
    // 1 - take just first or second too
    // 1-{0-9} decodable
    // 2 - take just first or second too
    // 2-{0-6} decodable
    // 2-{7-9} undecodable
    // 3-9 - take just one
}
