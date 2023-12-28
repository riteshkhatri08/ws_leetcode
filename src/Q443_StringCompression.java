
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
            int newlength = 0;
            int left = 0;
            int right = 0;
            char[] diff = null;
            int placer = 0;
            int d = 0;
            for (; right < chars.length; right++) {
                if (chars[left] != chars[right]) {
                    d = right - left;

                    // print(chars);
                    // Place character first
                    chars[placer++] = chars[left];
                    // Increment length
                    newlength++;
                    if (d > 1) {
                        diff = String.valueOf(d).toCharArray();
                        // print(diff);
                        for (int i = 0; i < diff.length; i++) {
                            chars[placer++] = diff[i];
                            newlength++;
                        }
                    }
                    left = right;
                }

            }
            // Once more after exiting loop
            d = right - left;

            // Place character first
            chars[placer++] = chars[left];

            // Increment length
            newlength++;
            // print(diff);
            // print(chars);
            if (d > 1) {
                diff = String.valueOf(d).toCharArray();
                // System.out.println("STRING VALUE OF " + String.valueOf(d));
                // print(diff);
                for (int i = 0; i < diff.length; i++) {
                    chars[placer++] = diff[i];
                    newlength++;
                }
            }

            return newlength;
        }

        private void print(char[] diff) {
            System.out.println("DIFF");
            for (char c : diff) {
                System.out.print(c + " , ");
            }
        }
    }
}
