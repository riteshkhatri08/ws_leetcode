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

            int totalSoFar = 1;
            {
                char[] chars = s.toCharArray();
                s = null;

                for (int cur = 1, countSoFar = 1; cur < chars.length; cur++) {

                    if (chars[cur - 1] == chars[cur]) {
                        countSoFar++;
                        // System.out.println(countSoFar + " " + " " + totalSoFar + " " + chars[cur]);

                    } else {
                        countSoFar = 1;
                        // System.out.println(countSoFar + " " + " " + totalSoFar + " " + chars[cur]);
                    }

                    totalSoFar = totalSoFar + countSoFar;
                    if (totalSoFar >= 1000000007) {
                        totalSoFar = totalSoFar % 1000000007;
                    }
                }
                // System.gc();
            }
            return totalSoFar;
        }
    }
}
