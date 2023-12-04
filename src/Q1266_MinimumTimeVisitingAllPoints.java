public class Q1266_MinimumTimeVisitingAllPoints {
    public static void main(String[] args) {
        int[][] points = new int[][] { { 1, 1 }, { 3, 4 }, { -1, 0 } };
        var result = new Q1266_MinimumTimeVisitingAllPoints().new Solution().minTimeToVisitAllPoints(points);
        System.out.println("ANSWER = " + result);

    }

    class Solution {
        public int minTimeToVisitAllPoints(int[][] points) {
            int dist = 0;

            for (int i = 0, j = 1; j < points.length; i++, j++) {
                dist = dist + Math.max(Math.abs(points[i][0] - points[j][0]), Math.abs(points[i][1] - points[j][1]));
            }

            return dist;
        }
    }

}
