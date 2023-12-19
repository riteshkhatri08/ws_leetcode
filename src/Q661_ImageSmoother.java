public class Q661_ImageSmoother {

    public static void main(String[] args) {
        int[][] img = new int[][] { { 01, 02, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 } };
        var result = new Q661_ImageSmoother().new Solution().imageSmoother(img);
        System.out.println("ANSWER = \n");

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(" " + result[i][j]);
            }
            System.out.println("");
        }
    }

    class Solution {
        public int[][] imageSmoother(int[][] img) {

            int m = img.length - 1;
            int n = img[0].length - 1;
            int[][] res = new int[img.length][img[0].length];
            int cursum = 0;

            // FOR SINGLE CELL
            if (m == n && m == 0) {
                return img;
            }

            // // FOR VERTICAL MATRIX
            if (n == 0) {
                // GET CORNERS FIRST
                res[0][0] = (int) ((img[0][0] + img[1][0]) / 2);
                res[m][0] = (int) ((img[m][0] + img[m - 1][0]) / 2);
                int upper = 0, i = 1, lower = 2;
                cursum = img[upper][0] + img[i][0];
                while (i < m) {
                    cursum = cursum + img[lower][0];
                    res[i][0] = (int) cursum / 3;
                    cursum = cursum - img[upper][0];
                    upper = i++;
                    lower = i + 1;
                }
                return res;
            }

            // FOR HORIZONTAL MATRIX
            if (m == 0) {
                // GET CORNERS FIRST
                res[0][0] = Math.floorDiv(img[0][0] + img[0][1], 2);
                res[0][n] = Math.floorDiv(img[0][n] + img[0][n - 1], 2);
                int left = 0, i = 1, right = 2;
                cursum = img[0][left] + img[0][i];
                while (i < n) {
                    cursum = cursum + img[0][right];
                    res[0][i] = (int) cursum / 3;
                    cursum = cursum - img[0][left];
                    left = i++;
                    right = i + 1;
                }
                return res;
            }

            // EDGE CASES END HERE, SO CURRENT MATRIX is 2x2 or higher

            // Calculate 4 Corners
            res[0][0] = Math.floorDiv(img[0][0] + img[0][1] + img[1][0] + img[1][1], 4);
            res[0][n] = Math.floorDiv(img[0][n] + img[0][n - 1] + img[1][n - 1] + img[1][n], 4);
            res[m][0] = Math.floorDiv(img[m][0] + img[m - 1][0] + img[m - 1][1] + img[m][1], 4);
            res[m][n] = Math.floorDiv(img[m][n] + img[m][n - 1] + img[m - 1][n - 1] + img[m - 1][n], 4);

            int c1, c2, c3; //
            int c4, c5, c6; // FIRST ROW
            int c7, c8, c9; // SECOND ROW
            int c10, c11, c12; // SECOND LAST ROW
            int c13, c14, c15; // LAST ROW

            // System.out.println( img[0][0] + " "+img[0][1] + " "+ img[1][0] + "
            // "+img[1][1]);
            // Calculate TOP and BOTTOM EDGE
            c4 = img[0][0];
            c5 = img[0][1];
            c7 = img[1][0];
            c8 = img[1][1];
            c10 = img[m - 1][0];
            c11 = img[m - 1][1];
            c13 = img[m][0];
            c14 = img[m][1];
            int cursum2 = c10 + c11 + c13 + c14;
            cursum = c4 + c5 + c7 + c8;
            for (int i = 1; i < n; i++) {
                c6 = img[0][i + 1]; // r1 c3
                c9 = img[1][i + 1]; // r2 c3
                c12 = img[m - 1][i + 1]; // r(n-2) c3
                c15 = img[m][i + 1]; // r(n) c3
                cursum += c6 + c9;
                cursum2 += c12 + c15;
                // System.out.println("ADDING TR - " + c4 + " + " + + c5 + " + " + + c6 + " + "
                // + + c7 + " + " + + c8 + " + " + + c9 );
                // System.out.println("ADDING BR - " + c10 + " + " + + c11 + " + " + + c12 + " +
                // " + + c13 + " + " + + c14 + " + " + + c15 );
                res[0][i] = (int) (cursum / 6);
                res[m][i] = (int) (cursum2 / 6);
                cursum = cursum - c4 - c7;
                cursum2 = cursum2 - c10 - c13;
                c4 = c5;
                c5 = c6;
                c7 = c8;
                c8 = c9;
                c10 = c11;
                c11 = c12;
                c13 = c14;
                c14 = c15;
            }

            // Calculate LEFT and RIGHT EDGE

            c4 = img[0][0];
            c5 = img[1][0];
            c7 = img[0][1];
            c8 = img[1][1];
            c10 = img[0][n - 1];
            c11 = img[1][n - 1];
            c13 = img[0][n];
            c14 = img[1][n];
            cursum2 = c10 + c11 + c13 + c14;
            cursum = c4 + c5 + c7 + c8;
            for (int i = 1; i < m; i++) {
                c6 = img[i + 1][0];
                c9 = img[i + 1][1];
                c12 = img[i + 1][n - 1];
                c15 = img[i + 1][n];
                cursum += c6 + c9;
                cursum2 += c12 + c15;
                // System.out.println("ADDING LC - " + c4 + " + " + +c5 + " + " + +c6 + " + "
                // + +c7 + " + " + +c8 + " + " + +c9);
                // System.out.println("ADDING RC - " + c10 + " + " + +c11 + " + " + +c12 + " + "
                // + +c13 + " + " + +c14
                // + " + " + +c15);
                res[i][0] = (int) (cursum / 6);
                res[i][n] = (int) (cursum2 / 6);
                cursum = cursum - c4 - c7;
                cursum2 = cursum2 - c10 - c13;
                c4 = c5;
                c5 = c6;
                c7 = c8;
                c8 = c9;
                c10 = c11;
                c11 = c12;
                c13 = c14;
                c14 = c15;
            }

            // ITERATE AND CALCULATE CENTER MATRIX
            int left = 0, j = 1, right = 2, upper = 0, i = 1, lower = 2;
            // System.out.println("n = " + n);

            for (; i < m; i++) {
                j = 1;
                lower = i + 1;
                c1 = img[upper][left];
                c2 = img[upper][j];
                c4 = img[i][left];
                c5 = img[i][j];
                c7 = img[lower][left];
                c8 = img[lower][j];
                cursum = c1 + c2 + c4 + c5 + c7 + c8;
                for (; j < n;) {
                    // RIGHT COLUMN OF FILTER
                    right = 1 + j;
                    // System.out.println("right = " + right);
                    c3 = img[upper][right];
                    c6 = img[i][right];
                    c9 = img[lower][right];
                    cursum = cursum + c3 + c9 + c6;
                    res[i][j] = (int) cursum / 9;
                    // System.out.println("ADDING - " + c1 + "+" + c2 + "+" + c3 + "+" + c4 + "+" +
                    // c5 + "+" + c6 + "+"
                    // + c7 + "+" + c8 + "+" + c9);
                    // subtract left column as filter is moving right
                    cursum = cursum - c1 - c4 - c7;

                    c1 = c2;
                    c2 = c3;
                    c4 = c5;
                    c5 = c6;
                    c7 = c8;
                    c8 = c9;
                    j++;

                }
                // System.out.println("ROW ENDED");
                upper = i;
            }

            return res;
        }
    }
}
