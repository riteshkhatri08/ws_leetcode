import java.util.HashSet;

public class Q1930_UniqueLength3PalindromicSubsequences {
    public static void main(String[] args) {
        var result = new Q1930_UniqueLength3PalindromicSubsequences().new Solution()
                .countPalindromicSubsequence("tlpjzdmtwderpkpmgoyrcxttiheassztncqvnfjeyxxp");
        System.out.println("ANSWER  " + result);
    }

    class Solution {
        HashSet<String> hashSet = new HashSet<String>();

        public int countPalindromicSubsequence(String s) {
            char[] charray = s.toCharArray();
            helper(0, 1, 2, charray);
            return hashSet.size();
        }

        private void helper(int left, int middle, int right, char[] charray) {
            // Base condition
            // if (right == charray.length) {
            // return;
            // }
            if (charray[left] == charray[right]) {
                System.out.println("" + charray[left] + charray[middle] + charray[right]);
                hashSet.add("" + charray[left] + charray[middle] + charray[right]);
                return;
            }

            if (left < middle - 1) {
                helper(left + 1, middle, right, charray);
            }

            if (middle < right - 1) {
                helper(left, middle + 1, right, charray);
            }

            if (right < charray.length - 1) {
                helper(left, middle, right + 1, charray);

            }

        }
    }
}
