public class Q2264_LargestThreeSameDigitNumberString {

    public static void main(String[] args) {
        String num = "333333777";
        var res = new Q2264_LargestThreeSameDigitNumberString().new Solution().largestGoodInteger(num);
        System.out.println("Answer = " + res);
    }

    class Solution {
        public String largestGoodInteger(String num) {
            char res = '/';
            {
                char[] charray = num.toCharArray();
                num = null;
                for (int i = 0; i < charray.length - 2; i++) {
                    if (charray[i] == charray[i + 1] && charray[i] == charray[i + 2] && charray[i] > res) {
                        res = charray[i];
                    }
                }
                charray = null;
            }
            if (res == '/') {
                return "";
            } else {
                return "" + res + res + res;
            }
        }
    }
}
