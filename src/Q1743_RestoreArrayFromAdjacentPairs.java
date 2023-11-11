import java.util.HashMap;
import java.util.HashSet;

public class Q1743_RestoreArrayFromAdjacentPairs {
    public static void main(String[] args) {

        int[][] adjacentPairs = new int[][] { { 2, 4 }, { 3, 9 }, { 3, 2 } };

        var result = new Q1743_RestoreArrayFromAdjacentPairs().new Solution().restoreArray(adjacentPairs);

        System.out.print("\nRESULT = ");
        for (int a : result) {
            System.out.print(a + " ");
        }

    }

    class Pair {

        int p1 = Integer.MIN_VALUE;
        int p2 = Integer.MIN_VALUE;

        public Pair(int p1, int p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        public Pair(int p1) {
            this.p1 = p1;
        }

        public void addp2(int p2) {
            this.p2 = p2;
        }

        public String toString() {
            if (p2 == Integer.MIN_VALUE)
                return "{" + p1 + "}";
            return "{" + p1 + ", " + p2 + "}";
        }
    }

    class Solution {
        HashMap<Integer, Pair> map = new HashMap<Integer, Pair>();
        // There will be two pairs where they will have only one partner i.e for start
        // and end
        // There remaning there will be n-2 pairs with 2 partners
        // pick any pair and start building left or right ..
        // OR pick start/end pair and start contructing one way

        // Restore array

        public int[] restoreArray(int[][] adjacentPairs) {
            int[] result = new int[adjacentPairs.length + 1];
            for (int[] pair : adjacentPairs) {
                if (map.containsKey(pair[0])) {
                    map.get(pair[0]).addp2(pair[1]);
                } else {
                    map.put(pair[0], new Pair(pair[1]));
                }

                if (map.containsKey(pair[1])) {
                    map.get(pair[1]).addp2(pair[0]);
                } else {
                    map.put(pair[1], new Pair(pair[0]));
                }
                // System.out.println(map);
            }
            // start with first key
            // Find the element which has only one starting pair
            int curkey = map.keySet().stream().filter(k -> map.get(k).p2 == Integer.MIN_VALUE).findFirst().get();
            HashSet<Integer> visited = new HashSet<Integer>();

            result[0] = curkey;
            visited.add(curkey);
            Pair currentPair = map.get(curkey);
            int curPosition = 1;

            do {
                if (visited.contains(currentPair.p1)) {
                    result[curPosition] = currentPair.p2;
                    visited.add(currentPair.p2);
                    currentPair = map.get(currentPair.p2);
                } else {
                    result[curPosition] = currentPair.p1;
                    visited.add(currentPair.p1);
                    currentPair = map.get(currentPair.p1);
                }
                curPosition++;
            } while (currentPair.p2 != Integer.MIN_VALUE);

            return result;
        }

    }

}
