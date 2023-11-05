public class Q1535_FindTheWinnerOfArrayGame {

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 2, 1 };
        int k = 5;
        var result = new Q1535_FindTheWinnerOfArrayGame().new Solution().getWinner(arr, k);
        System.out.println("\n\n RESULT = " + result);
    }

    class Solution {
        public int getWinner(int[] arr, int k) {
            int champ = 0;
            int challenger = 1;
            int currentWins = 0;

            while (currentWins < k) {

                if (challenger >= arr.length) {
                    challenger = 0;
                }
                if (challenger == champ) {
                    break;
                }
                if (arr[champ] > arr[challenger]) {
                    currentWins++;
                } else {
                    champ = challenger;
                    currentWins = 1;
                }
                challenger++;
            }
            return arr[champ];
        }
    }
}
