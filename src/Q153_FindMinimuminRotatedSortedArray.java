public class Q153_FindMinimuminRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[] { 11, 15, 17, 18, 2, 4, 5, 6, 7, 8, 10 };
        var result = new Q153_FindMinimuminRotatedSortedArray().new Solution().findMin(nums);
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        public int findMin(int[] nums) {
            int mid = 0, right = nums.length - 1, left = 0;
            if (nums[left] <= nums[right]) {
                return nums[0];
            }

            while (right >= left) {
                mid = left + (right - left) / 2;
                System.out.println("LEFT=" + left + ", RIGHT=" + right + ", MID=" + mid);
                if (nums[mid] >= nums[0]) {
                    System.out.println(nums[mid] + " >= " + nums[0]);
                    // MOVE RIGHT
                    left = mid + 1;

                } else if (nums[mid] < nums[0]) {
                    // Check if element to immediate left i > or less than
                    System.out.println(nums[mid] + " < " + nums[0]);
                    if (nums[mid - 1] > nums[mid]) {
                        System.out.println(nums[mid - 1] + " > " + nums[mid]);
                        return nums[mid];
                    } else {
                        // MOVE LEFT
                        right = mid - 1;
                    }
                }
            }
            return nums[mid];
        }
    }
}
