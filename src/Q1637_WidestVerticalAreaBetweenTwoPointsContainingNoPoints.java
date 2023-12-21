import java.util.Arrays;

public class Q1637_WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public static void main(String[] args) {
        int points[][] = new int[10][2];
        var result = new Q1637_WidestVerticalAreaBetweenTwoPointsContainingNoPoints().new Solution()
                .maxWidthOfVerticalArea(points);

        System.out.println("ANSWER  = " + result);
    }

    class Solution {
        public int maxWidthOfVerticalArea(int[][] points) {
            int[] arr = new int[points.length];
            for (int i = 0; i < points.length; i++) {
                arr[i] = points[i][0];
            }

            Arrays.sort(arr);
            int diff = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] - arr[i - 1] > diff) {
                    diff = arr[i] - arr[i - 1];
                }
            }

            return diff;
        }
    }

}
