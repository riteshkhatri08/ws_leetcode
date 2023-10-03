public class Q557_ReverseWordsinaString3 {

    public static void main(String[] args) {
        Q557_ReverseWordsinaString3 obj = new Q557_ReverseWordsinaString3();
        String s = "Let's take LeetCode contest";
        System.out.println(obj.new Solution().reverseWords(s));
    }

    class Solution {
        public String reverseWords(String s) {

            char[] output = new char[s.length()];
            {
                // Keep below variables in inner curly brace to end their scope once done
                char[] input = s.toCharArray();
                s = null;
                int left = 0;
                int right = 0;
                int temp;
                for (; right < input.length; right++) {
                    if (input[right] == ' ') {

                        temp = right - 1;
                        output[right] = ' ';
                        while (left < right) {

                            output[left++] = input[temp--];

                        }
                        left = right + 1;

                    }
                }
                temp = right - 1;
                while (left < right) {

                    output[left++] = input[temp--];

                }

                // For better memory
                System.gc();
            }
            // return sentence.toString();
            return new String(output);
        }
    }

}
