public class Q33_SearchinRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[] { 11, 15, 17, 18, 2, 4, 5, 6, 7, 8, 10 };
        int target = 8;
        var result = new Q33_SearchinRotatedSortedArray().new Solution().search(nums, target);
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        public int search(int[] nums, int target) {
            if (nums.length == 1) {
                if (nums[0] == target) {
                    return 0;
                } else {
                    return -1;
                }
            }
            int pivotIndex = findPivot(nums);
            // System.out.println("pivotIndex = " + pivotIndex);

            if (target <= nums[nums.length - 1]) {
                // seacrh between left and pivot
                return binarySearch(pivotIndex, nums.length - 1, nums, target);
            } else {
                // search betweem pivot+1 and right
                return binarySearch(0, pivotIndex - 1, nums, target);
            }

        }

        public int findPivot(int[] nums) {
            int mid = 0, left = 0, right = nums.length - 1;
            if (nums[left] <= nums[right]) {
                return 0;
            }
            while (right >= left) {
                mid = left + (right - left) / 2;
                // System.out.println("LEFT="+left+", RIGHT="+right+", MID="+mid);
                if (nums[mid] >= nums[0]) {
                    left = mid + 1;
                } else {
                    if (nums[mid] < nums[mid - 1]) {
                        return mid;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return mid;
        }

        public int binarySearch(int left, int right, int[] nums, int target) {
            int mid = -1;
            // System.out.println("SEARCH BETWEEN "+left+" and "+right);
            while (right >= left) {
                mid = left + (right - left) / 2;
                // System.out.println("LEFT="+left+", RIGHT="+right+", MID="+mid);
                if (nums[mid] == target) {
                    break;
                } else if (nums[mid] > target) {
                    // search left
                    right = mid - 1;
                } else {
                    // search right
                    left = mid + 1;
                }
            }
            if (mid > -1 && nums[mid] != target) {
                return -1;
            }
            return mid;
        }
    }
}
