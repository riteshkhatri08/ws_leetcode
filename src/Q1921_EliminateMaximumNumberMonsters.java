import java.util.Arrays;

public class Q1921_EliminateMaximumNumberMonsters {

    public static void main(String[] args) {

        int[] dist = new int[] { 3, 2, 4 };
        int[] speed = new int[] { 5, 3, 2 };

        var result = new Q1921_EliminateMaximumNumberMonsters().new Solution().eliminateMaximum(dist, speed);
        System.out.println(result);
    }

    class Solution {
        public int eliminateMaximum(int[] dist, int[] speed) {
            double[] time = new double[dist.length];
            for (int i = 0; i < dist.length; i++) {
                // Calculate time for each monster to reach in same
                // array to reduce space complexity
                // System.out.println(dist[i] + " / " + speed[i] + " = " + ( (double)dist[i] /
                // (double)speed[i]) );
                time[i] = (double) dist[i] / (double) speed[i];
            }

            // Sort them
            Arrays.sort(time);

            // Print array
            // for (double a : time){
            // System.out.print(a +" ");
            // }

            // Start counting
            int totalTime = 0;
            int counter = 1;

            while (counter < dist.length && (time[counter] - totalTime) > 1) {
                totalTime++;
                counter++;
            }

            return counter;
        }
    }
}
