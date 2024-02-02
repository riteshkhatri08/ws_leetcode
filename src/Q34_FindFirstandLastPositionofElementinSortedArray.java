public class Q34_FindFirstandLastPositionofElementinSortedArray {

    public static void main(String[] args) {
        int arr[] = new int[] { 5, 7, 7, 8, 8, 10 };
        int target = 10;
        var result = new Q34_FindFirstandLastPositionofElementinSortedArray().new Solution().searchRange(arr, target);
        System.out.println("ANSWER = " + result[0] + " " + result[1]);
    }

    class Solution {
        public int[] searchRange(int[] nums, int target) {

            return new int[] { findFirstOccurence(nums, target), findLastOccurence(nums, target) };
        }

        private static int findFirstOccurence(int[] arr, int target) {
            int result = -1, left = 0, right = arr.length - 1, mid = 0;

            while (right >= left) {
                mid = left + (right - left) / 2;
                // System.out.println("left="+left+", right="+right+", mid="+mid +",
                // result="+result);
                if (arr[mid] == target) {
                    // record current occurence index and search for more occurences in lefr subarr
                    result = mid;
                    right = mid - 1;
                } else if (arr[mid] > target) {
                    // search in left subarr bc cur element is greater than target
                    right = mid - 1;
                } else {
                    // search in right subarr
                    left = mid + 1;
                }
            }
            // System.out.println("RETURNING left="+left+", right="+right+", mid="+mid +",
            // result="+result);
            return result;
        }

        private static int findLastOccurence(int[] arr, int target) {
            int result = -1, left = 0, right = arr.length - 1, mid = 0;

            while (right >= left) {
                mid = left + (right - left) / 2;
                // System.out.println("left="+left+", right="+right+", mid="+mid +",
                // result="+result);

                if (arr[mid] == target) {
                    result = mid;
                    left = mid + 1;
                } else if (arr[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return result;
        }
    }
}
