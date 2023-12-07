public class Q1903_LargestOddNumberString {
    public static void main(String[] args) {
        var result = new Q1903_LargestOddNumberString().new Solution().largestOddNumber("342076");
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        public String largestOddNumber(String num) {
            int i = num.length() - 1;
            while (i > -1 && ((num.charAt(i) % 2) != 1))
                i--;

            return num.substring(0, i + 1);
        }
    }
}
