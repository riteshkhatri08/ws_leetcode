public class Q38_CountAndSay {
    public static void main(String[] args) {
        var result = new Q38_CountAndSay().new Solution().countAndSay(5);
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        public String countAndSay(int n) {
            return helper("1", n);
        }

        public String helper(String num, int count) {
            // System.out.println("num =" + num + " count=" + count);
            if (count <= 1) {
                return num;
            }
            char[] charray = num.toCharArray();
            int prev = 0, i = 1;
            String s = "";
            for (i = 1; i < charray.length; i++) {
                if (charray[prev] != charray[i]) {
                    // System.out.println("s =" + s);
                    s = s + (i - prev) + charray[prev];
                    prev = i;
                }
            }

            s = s + (i - prev) + charray[prev];

            return helper(s, count - 1);
        }
    }

}
