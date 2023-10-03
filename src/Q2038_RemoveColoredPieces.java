public class Q2038_RemoveColoredPieces {

    public static void main(String[] args) {
        Q2038_RemoveColoredPieces obj = new Q2038_RemoveColoredPieces();
        // "ABBBBBBBAAA"
        // "AAABABBBABBBAAA"
        String colors = "AAABABBBABBBAA";
        System.out.println(obj.new Solution().winnerOfGame(colors));
    }

    class Solution {
        public boolean winnerOfGame(String cs) {

            char[] colors = cs.toCharArray(); // working with char[] is faster than using String.charAt()
            int amoves = 0;
            int bmoves = 0;
            int left = 0;
            int cur = 1;

            for (; cur < colors.length; cur++) {

                if (colors[cur - 1] != colors[cur]) {

                    if (cur - left > 2) {
                        if (colors[left] == 'A') {
                            amoves = amoves + cur - left - 2;

                        } else {
                            bmoves = bmoves + cur - left - 2;
                        }
                    }
                    left = cur;

                }
            }
            // To clear unused memory
            System.gc();

            if (colors[cur - 1] == colors[left] && (cur - 1 - left) >= 2) {
                if (colors[left] == 'A') {
                    amoves = amoves + cur - left - 2;
                } else {
                    bmoves = bmoves + cur - left - 2;
                }
            }

            return amoves > bmoves ? true : false;
        }
    }

}
