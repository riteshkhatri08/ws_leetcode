public class Q2938_SeparateBlackandWhiteBalls {
    public static void main(String[] args) {
        var result = new Q2938_SeparateBlackandWhiteBalls().new Solution().minimumSteps("10110101101");
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        public long minimumSteps(String s) {

            long swaps = 0L;
            {

                char[] charray = s.toCharArray();
                // Track right most zero
                int zeroIndex = charray.length - 1;
                // Track left most one
                int oneIndex = 0;

                while (true) {

                    // Find Left Most 1
                    while (oneIndex < charray.length && charray[oneIndex] != '1') {
                        oneIndex++;
                    }

                    // Find right Most zero
                    while (zeroIndex >= 0 && charray[zeroIndex] != '0') {
                        zeroIndex--;
                    }
                    System.out.println("zero=" + zeroIndex + ", one=" + oneIndex);
                    // SWAP'EM if a 0 is present on right of 1
                    if (zeroIndex > oneIndex) {
                        swaps = swaps + (zeroIndex - oneIndex);
                        zeroIndex--;
                        oneIndex++;
                    } else {
                        break;
                    }

                }

            }
            return swaps;
        }
    }

    // 10110101101
    // 10110101011 -1
    // 10110100111 -2
    // 10110001111 -4
    // 10100011111 -7
    // 10000111111 -10
    // 01000111111 -10
    // 00001111111 -14 11 - 7 = 4
    // 00001111111

    // index of black 1 count -1
    // no white = n- 1 count

    // for (int i = 0 ; i < indexes.length ; i++){
    // System.out.print(charray[indexes[i]]+" ");
    // }
    // 1 0 1 1 0 1 0 1 1 0 1
    // 1 4 6 9 10 8 7 5 3 2 0
    // zero max index = 3
    // 1 4 6 9
    // 10 8 7 5 3 2 0
    // 9-0 = 9
    // 6-2 = 4
    // 4-3 = 1
    // ones = 11-(zeroes) = 7
}
