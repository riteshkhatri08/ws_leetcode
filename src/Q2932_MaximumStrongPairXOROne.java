public class Q2932_MaximumStrongPairXOROne {

    public static void main(String[] args) {
        var result = new Q2932_MaximumStrongPairXOROne().new Solution()
                .maximumStrongPairXor(new int[] { 5, 6, 25, 30 });
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        public int maximumStrongPairXor(int[] nums) {
            int maxxor = 0;
            int curxor;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    // is this a strong pair
                    if (Math.abs(nums[i] - nums[j]) <= Math.min(nums[i], nums[j])) {
                        // compare their xor with max xor
                        curxor = nums[i] ^ nums[j];
                        if (curxor > maxxor) {
                            maxxor = curxor;
                        }
                    }
                }
            }

            return maxxor;
        }
    }
}
