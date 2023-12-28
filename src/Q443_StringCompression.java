
public class Q443_StringCompression {

    public static void main(String[] args) {
        char[] input = new char[] { 'd', 'a', 'a', 'b', 'b', 'c', 'c' };
        var result = new Q443_StringCompression().new Solution().compress(input);
        for (int i = 0; i < result; i++) {
            System.out.print(input[i] + " O");
        }

    }

    class Solution {
        public int compress(char[] chars) {
            // int newlength = 0;
            int left = 0;
            int right = 0;
            int placer = 0;
            for (; right < chars.length; right++) {
                if (chars[left] != chars[right]) {

                    // Place character first
                    chars[placer++] = chars[left];

                    placer = compressHelper(right - left, placer, chars);

                    left = right;
                }

            }
            // Once more after exiting loop
            // Place character first
            chars[placer++] = chars[left];

            placer = compressHelper(right - left, placer, chars);

            // return newlength;
            return placer;
        }

        private int compressHelper(int diff, int placer, char[] chars) {
            if (diff > 999) {
                // CHOUBAL DIGITS
                chars[placer++] = (char) ((diff / 1000) + 48);
                diff %= 1000;

                chars[placer++] = (char) ((diff / 100) + 48);
                diff %= 100;

                // GET 10's digit
                chars[placer++] = (char) ((diff / 10) + 48);

                // GET 1's DIGIT
                chars[placer++] = (char) ((diff % 10) + 48);

            } else if (diff > 99) {
                // TRIPLE DIGIT
                // GET 100's digit
                chars[placer++] = (char) ((diff / 100) + 48);
                diff %= 100;

                // GET 10's digit
                chars[placer++] = (char) ((diff / 10) + 48);

                // GET 1's DIGIT
                chars[placer++] = (char) ((diff % 10) + 48);

            } else if (diff > 9) {
                // DOUBLE DIGIT

                // GET 10's digit
                chars[placer++] = (char) ((diff / 10) + 48);

                // GET 1's DIGIT
                chars[placer++] = (char) ((diff % 10) + 48);

            } else if (diff > 1) {
                // SINGLE DIGIT
                chars[placer++] = (char) (diff + 48);

            }
            return placer;
        }

    }
}
