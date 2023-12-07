public class Q55_JumpGame {

    public static void main(String[] args) {
        int nums[] = new int[] { 2, 5, 0, 0 };
        var result = new Q55_JumpGame().new Solution().canJump(nums);
        System.out.println("RESULT = " + result);

    }

    class Solution {
        int[] mem;

        public boolean canJump(int[] nums) {
            // no of Choices = nums[i]
            // nums[i] == 0 return false
            // i == nums.length return true
            // mem = new int [nums.length];

            return jumpKar(0, nums);
        }

        public boolean jumpKar(int index, int[] nums) {
            // if (mem[index] != 0){
            // return mem[index] == -1 ? false : true;
            // }
            if (index == nums.length - 1) {
                return true;
            }

            if (nums[index] == 0) {
                return false;
            }

            if (nums[index] + index >= nums.length) {
                return true;
            }

            // current index + 1
            int nextPowerfulIndex = index + 1;
            for (int i = 2; i <= nums[index]; i++) {
                // System.out.println("npi=" + nextPowerfulIndex + " "+ nums[nextPowerfulIndex]
                // + ", i=" + (index+i) + " " + nums[index+i] );
                if (index + i < nums.length) {
                    // check the power at next LZ
                    if (nums[index + i] > nums[nextPowerfulIndex]) {
                        nextPowerfulIndex = index + i;
                        System.out.println("npi=" + nextPowerfulIndex + " " + nums[nextPowerfulIndex] + ", i="
                                + (index + i) + " " + nums[index + i]);
                    }
                }
            }
            // jump to most powerful index
            boolean result = jumpKar(nextPowerfulIndex, nums);

            return result;
        }

    }
}
