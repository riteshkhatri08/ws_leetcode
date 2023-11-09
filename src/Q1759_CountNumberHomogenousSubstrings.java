public class Q1759_CountNumberHomogenousSubstrings {

    public static void main(String[] args) {
        var result = new Q1759_CountNumberHomogenousSubstrings().new Solution().countHomogenous("abbcccaa");
        System.out.println("\n\n\n RESULT " + result);
    }

    class Solution {

        public int countHomogenous(String s) {
            // 1) Breka string into substrings of same characters
            // 2) if a substring has length n add n(n+1)/2 to total count
            // char[] chars = s.toCharArray();

            double totalSoFar = 0;
            {
                char[] chars = s.toCharArray();
                s = null;
                int cur = 1, prev = 0, diff = 0;

                for (; cur < chars.length; cur++) {

                    if (chars[prev] != chars[cur]) {
                        diff = cur - prev;
                        totalSoFar += (Math.pow(diff, 2) + diff) / 2;
                        prev = cur;
                    }

                }

                diff = cur - prev;

                totalSoFar += (Math.pow(diff, 2) + diff) / 2;

                if (totalSoFar >= 1000000007) {
                    totalSoFar = totalSoFar % 1000000007;
                }

            }
            return (int) totalSoFar;
        }
    }
}
