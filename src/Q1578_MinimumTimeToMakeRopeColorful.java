public class Q1578_MinimumTimeToMakeRopeColorful {

    public static void main(String[] args) {
        String colors = "abbbabaaabbbbbbb";
        int[] neededTime = new int[] { 13, 18, 38, 34, 20, 36, 38, 5, 24, 9, 35, 34, 25, 48, 35, 9, 18, 40, 48, 12, 22,
                18, 6, 7, 32, 12, 4, 39, 28, 28, 19, 21, 9, 20, 23, 40, 11, 13, 7, 1, 3, 40, 32, 14, 8, 46, 35, 45, 12,
                21, 49, 4, 48, 40, 34, 29, 7, 49, 43, 16, 38, 15, 47, 44, 19, 18, 29, 49, 18, 2, 38, 9, 40, 1, 45, 6, 8,
                26, 15, 30, 14, 23, 48, 27, 22, 41, 20, 6, 27, 25, 24, 25, 27, 41, 50, 27, 6, 12, 19, 19 };
        var result = new Q1578_MinimumTimeToMakeRopeColorful().new Solution().minCost(colors, neededTime);
        System.out.println("ANSWER = " + result);

    }

    class Solution {
        int mintime = Integer.MAX_VALUE;

        public int minCost(String colors, int[] neededTime) {
            if (colors.length() == 1) {
                return 0;
            }
            char ballons[] = colors.toCharArray();
            if (colors.length() == 2) {
                if (ballons[0] == ballons[1]) {
                    return Math.min(neededTime[0], neededTime[1]);
                } else {
                    return 0;
                }
            }

            helper(0, 1, 0, ballons, neededTime);

            return mintime;
        }

        public void helper(int left, int right, int timetaken, char[] ballons, int[] neededTime) {

            if (right == ballons.length) {
                // reached end of string
                if (timetaken < mintime) {
                    mintime = timetaken;
                }
                return;
            }

            if (ballons[left] == ballons[right]) {
                // REMOVE LEFT
                if (neededTime[left] < neededTime[right]) {
                    helper(right, right + 1, timetaken + neededTime[left], ballons, neededTime);
                } else {
                    // REMOVE RIGHT
                    helper(left, right + 1, timetaken + neededTime[right], ballons, neededTime);
                }
            } else {
                helper(right, right + 1, timetaken, ballons, neededTime);
            }

        }
    }

    // check two at time
    // either remove first or second
    // at time to remove in time taken so far
    // proceed with removed array
    // when reached end of array compare time taken so far with other

    // time taken to sort 3 ballons
    // time taken to sort 3 ballons is time taken to sort

    // a a a b c
    // 0 1
    // check two at time
    // either remove first or second
    // at time to remove in time taken so far
    // proceed with removed array
    // when reached end of array compare time taken so far with other

}
