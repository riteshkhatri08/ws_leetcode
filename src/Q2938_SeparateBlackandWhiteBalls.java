public class Q2938_SeparateBlackandWhiteBalls {
    public static void main(String[] args) {

    }

    class Solution {
        public long minimumSteps(String s) {

            long swaps = 0L;
            {
                // Store indices from of charray which have 0 on left and others on right;
                // middle border will have -1;
                char[] charray = s.toCharArray();
                int[] indexes = new int[charray.length];
                int zeroIndex = 0, oneIndex = indexes.length - 1, zeroCount;

                for (int i = 0; i < charray.length; i++) {
                    if (charray[i] == '1') {
                        indexes[oneIndex--] = i;
                    } else {
                        indexes[zeroIndex++] = i;
                    }
                }

                zeroCount = zeroIndex;
                zeroIndex--;
                oneIndex = indexes.length - 1;
                // Now zeroIndex+1 is no of zeroes
                // and indexes[zeroIndex] points to largest index in charray which has a zero
                // and indexes[ondeIndex] points to largest index in charray which has a 1

                // Swap the zeroes that are present on right side with ones that are present on
                // left side
                while (zeroIndex >= 0 && indexes[zeroIndex] >= zeroCount) {
                    swaps = swaps + (indexes[zeroIndex--] - indexes[oneIndex--]);
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
