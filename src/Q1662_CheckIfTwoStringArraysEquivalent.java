public class Q1662_CheckIfTwoStringArraysEquivalent {
    public static void main(String[] args) {
        String[] word1 = new String[] { "ab", "c" }, word2 = new String[] { "a", "bc" };
        var result = new Q1662_CheckIfTwoStringArraysEquivalent().new Solution().arrayStringsAreEqual(word1, word2);
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            int p1 = 0;
            int p2 = 0;
            char[] w1, w2;
            int i = 0, j = 0;
            for (; i < word1.length && j < word2.length;) {

                w1 = word1[i].toCharArray();
                w2 = word2[j].toCharArray();

                while (p1 < w1.length && p2 < w2.length) {
                    // System.out.println("Comparing = " + w1[p1] + " =? " + w2[p2]);
                    if (w1[p1++] != w2[p2++]) {
                        return false;
                    }
                }

                if (p1 >= w1.length) {
                    p1 = 0;
                    i++;
                }

                if (p2 >= w2.length) {
                    p2 = 0;
                    j++;
                }
            }
            if (i >= word1.length && j >= word2.length) {
                return true;
            } else {
                return false;
            }

        }
    }
}
