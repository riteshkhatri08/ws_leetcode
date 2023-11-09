public class Q55_JumpGame {

    public static void main(String[] args) {
        int nums[] = new int[] { 3, 2, 1, 1, 4 };
        var result = new Q55_JumpGame().new Solution().canJump(nums);
        System.out.println("RESULT = " + result);

    }

    class Solution {
        int[] mem;

        public boolean canJump(int[] nums) {
            // no of Choices = nums[i]
            // nums[i] == 0 return false
            // i == nums.length return true
            mem = new int[nums.length];
            return jumpKar(0, nums);
        }

        public boolean jumpKar(int index, int[] nums) {
            if (mem[index] != 0) {
                return mem[index] == -1 ? false : true;
            }
            if (index == nums.length - 1) {
                return true;
            }

            if (nums[index] == 0) {
                return false;
            }

            // make sure new index < nums.length();
            boolean result = false;

            for (int i = nums[index]; i > 0; i--) {
                if (index + i < nums.length) {
                    // System.out.println("BEFORE index=" + index +", new="+(index+i));
                    result = jumpKar(index + i, nums);
                    mem[index + i] = result == false ? -1 : 1;
                    // System.out.println("AFTER index=" + index +", new="+(index+i)+",
                    // res="+result);

                    if (result == true) {
                        break;
                    }
                }
            }

            return result;
        }

    }
}
