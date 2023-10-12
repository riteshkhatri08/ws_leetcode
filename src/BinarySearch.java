public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch obj = new BinarySearch();

        int[] nums = new int[] { 0, 22, 43, 54, 66, 69, 72, 77, 79, 80, 83, 85, 87, 89, 98, 100, 102 };
        // int[] nums = new {00, 01, 02, 03, 04, 05, 06, 07, 08, 09, 10, 11, 12, 13, 14,
        // 015, 016
        // };
        // int n = 89;
        for (int n : nums) {
            int result = obj.new Solution().search(nums, n);
            System.out.println("result = " + result);

        }

    }

    class Solution {
        public int search(int[] nums, int target) {

            int left = 0, right = nums.length - 1, mid;

            while (left <= right) {
                // mid = ((right + left) % 2) == 0 ? ((right + left) / 2) + 1 : (right + left) /
                // 2;
                mid = left + ((right - left) / 2);
                // System.out.println("left=" + left + ", right=" + right + ", mid=" + mid + ",
                // " + nums[mid]);
                // if (nums[left] == target)
                //     return left;
                // if (nums[right] == target)
                //     return right;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }

}
