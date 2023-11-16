import java.util.HashSet;

public class Q1980_FindUniqueBinaryString {

    public static void main(String[] args) {
        var result = new Q1980_FindUniqueBinaryString().new Solution()
                .findDifferentBinaryString(new String[] { "111", "011", "001" });
        System.out.println("ANSWER " + result);
    }

    class Solution {
        HashSet<String> set = new HashSet<String>();
        int n;
        String answer = "";

        public String findDifferentBinaryString(String[] nums) {

            for (String s : nums)
                set.add(s);

            n = nums.length;
            nums = null;

            helper("");
            return answer;
        }

        private boolean helper(String binaryString) {
            if (binaryString.length() == n) {
                if (!set.contains(binaryString)) {
                    answer = binaryString;
                    return true;
                }
                return false;
            }

            if (helper(binaryString + "0") == false) {
                return helper(binaryString + "1");
            } else {
                return true;
            }

        }
    }

}
