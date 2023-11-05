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

            while (currentWins < k && challenger < arr.length) {

                if (arr[champ] < arr[challenger]) {
                    champ = challenger;
                    currentWins = 0;
                }
                currentWins++;
                challenger++;

            }
            return arr[champ];
        }
    }
}
