
public class Q443_StringCompression {

    public static void main(String[] args) {
        char[] input = new char[] { 'a', 'a', 'b', 'b', 'c' };
        var result = new Q443_StringCompression().new Solution().compress(input);

    }

    class Solution {
        public int compress(char[] chars) {
            int newlength = 0;
            int left = 0;
            int right = 0;
            char[] diff = null;
            int placer = -1;
            for (; right < chars.length; right++) {
                if (chars[left] != chars[right]) {

                }
            }
            return newlength;
        }
    }
}