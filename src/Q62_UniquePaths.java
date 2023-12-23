public class Q62_UniquePaths {

    public static void main(String[] args) {
        var result = new Q62_UniquePaths().new Solution().uniquePaths(7, 3);
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] answers = new int[m][n];
            answers[0][0] = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i > 0 && j > 0)
                        answers[i][j] = answers[i - 1][j] + answers[i][j - 1];
                    else if (i > 0 && j == 0)
                        answers[i][j] = answers[i - 1][j];
                    else if (i == 0 && j > 0)
                        answers[i][j] = answers[i][j - 1];

                }
            }

            return answers[m - 1][n - 1];
        }
    }
}
