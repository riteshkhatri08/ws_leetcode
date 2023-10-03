public class Q557_ReverseWordsinaString3 {

    public static void main(String[] args) {
        Q557_ReverseWordsinaString3 obj = new Q557_ReverseWordsinaString3();
        String s = "Let's take LeetCode contest";
        System.out.println(obj.new Solution().reverseWords(s));
    }

    class Solution {
        public String reverseWords(String s) {

            String sentence = "";
            String currentWord = "";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    sentence = sentence + currentWord + " ";
                    currentWord = "";
                } else {
                    currentWord = s.charAt(i) + currentWord;
                }
            }
            sentence = sentence + currentWord;
            return sentence;
        }
    }

}
