public class Q1160_WordsThatCanBeFormedCharacters {
    public static void main(String[] args) {
        String[] words = new String[] { "cat", "bt", "hat", "tree" };
        String chars = "atach";

        var result = new Q1160_WordsThatCanBeFormedCharacters().new Solution().countCharacters(words, chars);
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        public int countCharacters(String[] words, String chars) {
            int[] curcount;
            int[] charcount = new int[26];
            for (char c : chars.toCharArray()) {
                charcount[((int) c) - 97]++;
            }
            chars = null;
            char[] curword;
            boolean flag;
            int result = 0;
            int index = 0;
            for (String word : words) {

                curcount = new int[26];
                curword = word.toCharArray();
                flag = true;

                for (char c : curword) {
                    index = ((int) c) - 97;
                    curcount[index]++;
                    if (charcount[index] < curcount[index]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    result += curword.length;
                } else {
                    flag = true;
                }
            }
            return result;
        }
    }
}
