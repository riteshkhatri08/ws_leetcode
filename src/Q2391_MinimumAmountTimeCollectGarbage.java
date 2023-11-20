public class Q2391_MinimumAmountTimeCollectGarbage {
    public static void main(String[] args) {
        String[] garbage = new String[] {};
        int[] travel = new int[] {};
        var result = new Q2391_MinimumAmountTimeCollectGarbage().new Solution().garbageCollection(garbage, travel);
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        public int garbageCollection(String[] garbage, int[] travel) {
            // Farthest each truck has to travel
            int maxG = -1, maxP = -1, maxM = -1;

            // total time collecting garbage
            int collectionTime = garbage[0].length();
            int cumulativeTravelTime = 0;
            int i = 0;
            for (; i < travel.length;) {
                cumulativeTravelTime += travel[i];
                travel[i] = cumulativeTravelTime;

                i++;

                collectionTime += garbage[i].length();
                if (garbage[i].contains("G")) {
                    maxG = i;
                }
                if (garbage[i].contains("M")) {
                    maxM = i;

                }
                if (garbage[i].contains("P")) {
                    maxP = i;
                }
            }
            if (maxG > 0) {
                collectionTime += travel[maxG - 1];
            }
            if (maxM > 0) {
                collectionTime += travel[maxM - 1];
            }
            if (maxP > 0) {
                collectionTime += travel[maxP - 1];
            }

            return collectionTime;
        }
    }
}
