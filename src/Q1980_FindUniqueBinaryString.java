public class Q1980_FindUniqueBinaryString {

    public static void main(String[] args) {
        var result = new Q1980_FindUniqueBinaryString().new Solution()
                .findDifferentBinaryString(new String[] { "111", "011", "001" });
        System.out.println("ANSWER " + result);
    }

    class Solution {
        public String findDifferentBinaryString(String[] nums) {
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < nums.length; i++)
                result.append(nums[i].charAt(i) == '0' ? '1' : '0');

            return new String(result);
        }
    }

}
