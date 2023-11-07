import java.util.Arrays;

public class Q1921_EliminateMaximumNumberMonsters {

    public static void main(String[] args) {

        int[] dist = new int[] {3,2,4};
        int[] speed = new int[] {5,3,2};

        var result = new Q1921_EliminateMaximumNumberMonsters().new Solution();
        System.out.println(result);
    }

    class Solution {
        public int eliminateMaximum(int[] dist, int[] speed) {

            for (int i = 0; i < dist.length; i++) {
                double time = dist[i] / speed[i];
                // System.out.println("time = " + time + " comp =" + (((int) time) + 0.5));
                dist[i] = (time > ((int) time) + 0.5 )? (((int) time) + 1 ) : (int) time ;
                // dist[i] = (int) Math.ceil(time);
            }
            Arrays.sort(dist);
            // for (int a : dist) {
            //     System.out.print(a + " ");
            // }
            int totalTime = 0;
            int counter = 1;

            while (counter < dist.length && (dist[counter] - totalTime) > 1) {
                totalTime++;
                counter++;
            }

            return counter;
        }
    }
}
