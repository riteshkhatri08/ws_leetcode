public class Q1662_CheckIfTwoStringArraysEquivalent {
    public static void main(String[] args) {
        String[] word1 = new String[] { "ab", "c" }, word2 = new String[] { "a", "bc" };
        var result = new Q1662_CheckIfTwoStringArraysEquivalent().new Solution().arrayStringsAreEqual(word1, word2);
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

            boolean result = false;
            {
                StringBuilder b1 = new StringBuilder();
                StringBuilder b2 = new StringBuilder();
                int i = 0;
                for (; i < word1.length && i < word2.length; i++) {
                    {
                        b1.append(word1[i]);
                        b2.append(word2[i]);
                    }
                }

                for (; i < word1.length; i++) {
                    b1.append(word1[i]);
                }

                for (; i < word2.length; i++) {
                    b2.append(word2[i]);
                }

                if (b1.toString().equals(b2.toString())) {
                    return true;
                }
                b1 = null;
                b2 = null;
                word1 = null;
                word2 = null;
                // System.gc();
            }
            return result;
        }

    }
}
