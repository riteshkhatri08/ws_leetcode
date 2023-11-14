import java.util.HashSet;

public class Q1930_UniqueLength3PalindromicSubsequences {
    public static void main(String[] args) {
        var result = new Q1930_UniqueLength3PalindromicSubsequences().new Solution()
                .countPalindromicSubsequence("tlpjzdmtwderpkpmgoyrcxttiheassztncqvnfjeyxxp");
        System.out.println("ANSWER  " + result);
    }

    class Pair {
        int left, right = -1;

        public Pair(int left) {
            this.left = left;
        }

    }

    class Solution {

        public int countPalindromicSubsequence(String s) {

            int c;
            char[] charray = s.toCharArray();
            Pair[] charIndices = new Pair[26];
            // int [] unqiueCharCount = new int [charray.length];

            // int count = 0;
            for (int i = 0; i < charray.length; i++) {
                c = ((int) charray[i]) - 97;
                if (charIndices[c] == null) {
                    // count++;
                    charIndices[c] = new Pair(i);
                } else {
                    charIndices[c].right = i;
                }
                // unqiueCharCount[i] = count;
            }

            // Arrays.stream(charray).forEach(c -> System.out.print(c + ", "));
            // System.out.println("");

            // Arrays.stream(unqiueCharCount).forEach(cx -> System.out.print(cx + ", "));
            // Arrays.stream( charIndices).forEach(cx -> {if (cx!=null)
            // {System.out.print("["+cx.left + "-" +cx.right+ "], ");}});
            // System.out.println("");
            int result = 0;
            for (int i = 0; i < charIndices.length; i++) {
                if (charIndices[i] != null && charIndices[i].right > -1) {
                    HashSet<Character> uniques = new HashSet<Character>();
                    for (int j = charIndices[i].left + 1; j < charIndices[i].right; j++) {
                        uniques.add(charray[j]);
                    }
                    result += uniques.size();
                }
            }

            return result;
        }

    }
    // left se character ka first index , right se character ka first index
    // no of unqiue characters between index left and right
    // no of unqiue characters is no of palindromes
    // repeat for chracter at left + 1
}
