import java.util.HashMap;

public class Q1160_WordsThatCanBeFormedCharacters {
    public static void main(String[] args) {
        String[] words = new String[] { "cat", "bt", "hat", "tree" };
        String chars = "atach";

        var result = new Q1160_WordsThatCanBeFormedCharacters().new Solution().countCharacters(words, chars);
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        public int countCharacters(String[] words, String chars) {
            HashMap<Character, Integer> curcount;
            HashMap<Character, Integer> charcount = new HashMap<Character, Integer>();
            for (char c : chars.toCharArray()) {
                charcount.put(c, charcount.getOrDefault(c, 0) + 1);
            }
            chars = null;
            char[] curword;
            boolean flag;
            int result = 0;
            for (String word : words) {

                curcount = new HashMap<Character, Integer>();
                curword = word.toCharArray();
                flag = true;
                for (char c : curword) {
                    if (charcount.containsKey(c)) {
                        curcount.put(c, curcount.getOrDefault(c, 0) + 1);
                        if ((curcount.get(c) > charcount.get(c))) {
                            flag = false;
                            break;
                        }
                    } else {
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
