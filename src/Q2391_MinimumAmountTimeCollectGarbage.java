public class Q2391_MinimumAmountTimeCollectGarbage {
    public static void main(String[] args) {
        String[] garbage = new String[] { "G", "P", "GP", "GG" };
        int[] travel = new int[] { 2, 4, 3 };
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
                for (char c : garbage[i].toCharArray()) {
                    switch (c) {
                        case 'G': {
                            maxG = i;
                            break;
                        }
                        case 'M': {
                            maxM = i;
                            break;
                        }
                        case 'P': {
                            maxP = i;
                            break;
                        }
                    }
                }
                // if (garbage[i].contains("G")) {
                // maxG = i;
                // }
                // if (garbage[i].contains("M")) {
                // maxM = i;
                // }
                // if (garbage[i].contains("P")) {
                // maxP = i;
                // }
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
