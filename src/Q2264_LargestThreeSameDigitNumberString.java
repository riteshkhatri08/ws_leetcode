public class Q2264_LargestThreeSameDigitNumberString {

    public static void main(String[] args) {
        String num = "6777133339";
        var res = new Q2264_LargestThreeSameDigitNumberString().new Solution().largestGoodInteger(num);
        System.out.println("Answer = " + res);
    }

    class Solution {
        public String largestGoodInteger(String num) {
            char res = '/';
            {
                char[] charray = num.toCharArray();
                num = null;
                int k = charray.length - 1, j = k - 1, i = k - 2;

                while (k > 1) {
                    if (charray[k] == charray[j] && charray[j] == charray[i] && charray[i] > res) {
                        res = charray[i];
                        if (res == '9') {
                            break;
                        }
                    }
                    i--;
                    j--;
                    k--;
                }

            }
            if (res == '/') {
                return "";
            } else {
                return "" + res + res + res;
            }
        }
    }
}
