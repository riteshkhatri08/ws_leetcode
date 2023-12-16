public class Q1582_SpecialPositionsInBinaryMatrix {
    public static void main(String[] args) {
        int[][] mat = new int[][] { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
        var result = new Q1582_SpecialPositionsInBinaryMatrix().new Solution().numSpecial(mat);
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        public int numSpecial(int[][] mat) {
            int count = 0;
            {
                int[] rc = new int[mat.length];
                int[] cc = new int[mat[0].length];
                for (int i = 0; i < mat.length; i++) {
                    for (int j = 0; j < mat[0].length; j++) {
                        if (mat[i][j] == 1) {
                            rc[i]++;
                            cc[j]++;
                        }
                    }
                }

                for (int i = 0; i < mat.length; i++) {
                    for (int j = 0; j < mat[0].length; j++) {
                        if (mat[i][j] == 1 && rc[i] == 1 && cc[j] == 1) {
                            count++;
                        }
                    }
                }
            }
            return count;
        }
    }
}
