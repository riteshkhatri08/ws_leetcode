public class Q1503_LastMomentBeforeAllAntsFallOutofPlank {

    public static void main(String[] args) {
        int[] left, right;
        left = new int[] { 4, 3 };
        right = new int[] { 0, 1 };
        var obj = new Q1503_LastMomentBeforeAllAntsFallOutofPlank().new Solution().getLastMoment(4, left, right);
        System.out.println(obj);
    }

    class Solution {
        public int getLastMoment(int n, int[] left, int[] right) {
            int max = 0;
            int i;
            for (i = 0; i < left.length; i++) {
                if (left[i] > max) {
                    max = left[i];
                }
            }
            int min = n;
            for (i = 0; i < right.length; i++) {
                if (right[i] < min) {
                    min = right[i];
                }
            }

            return (n - min > max) ? n - min : max;
        }
    }
}
