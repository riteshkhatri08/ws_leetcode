public class Q661_ImageSmoother {

    public static void main(String[] args) {
        int[][] img = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        var result = new Q661_ImageSmoother().new Solution().imageSmoother(img);
        System.out.println("ANSWER = \n" + result);

        for (int i = 0; i < result.length; i++)
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(" " + result[i][j]);
            }
    }

    class Solution {
        public int[][] imageSmoother(int[][] img) {
            int[][] sol = new int[img.length][img[0].length];
            int[][] cells = new int[][] {
                    { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }
            };
            int x, y, curavg, div;
            for (int i = 0; i < img.length; i++) {
                for (int j = 0; j < img[0].length; j++) {
                    curavg = img[i][j];
                    div = 1;
                    for (int k = 0; k < cells.length; k++) {
                        x = cells[k][0] + i;
                        y = cells[k][1] + j;
                        if (x > -1 && x < img.length && y > -1 && y < img[0].length) {
                            curavg = curavg + img[x][y];
                            div++;
                        }
                    }

                    sol[i][j] = Math.floorDiv(curavg, div);
                    // System.out.println("i=" + i + ", j=" + j + " curavg = " + curavg + ", div = "
                    // + div + " , smoooth="
                    // + img[i][j]);
                }
            }

            return sol;
        }
    }
}
