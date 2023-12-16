public class Q242_ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "naamarg";
        var result = new Q242_ValidAnagram().new Solution().isAnagram(s, t);
        System.out.println("Answer = " + result);
    }

    class Solution {
        public boolean isAnagram(String s, String t) {

            if (t.length() != s.length())
                return false;

            int[] chars = new int[57];

            for (int a = s.length() - 1; a >= 0; a--) {
                chars[s.charAt(a) - 'a']++;
            }

            for (int a = t.length() - 1; a >= 0; a--) {
                if ((--chars[t.charAt(a) - 'a']) < 0)
                    return false;
            }

            return true;

        }
    }
}
