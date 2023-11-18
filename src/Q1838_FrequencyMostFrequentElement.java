import java.util.Arrays;

public class Q1838_FrequencyMostFrequentElement {
    public static void main(String[] args) {

        int[] arr = new int[] { 1, 4, 8, 13 };
        var result = new Q1838_FrequencyMostFrequentElement().new Solution().maxFrequency(arr, 5);
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        public int maxFrequency(int[] nums, int k) {

            Arrays.sort(nums);
            int left = 0, right = 0, maxWindowSize = 1, curWindowSize;
            long windowSum = nums[left];

            while (true) {

                System.out.println("left=" + left + ", right=" + right + ", windowSum=" +
                        windowSum + ", maxWindowSize=" + maxWindowSize);
                curWindowSize = right - left + 1;
                if ((nums[right] * (curWindowSize)) <= (k + windowSum)) {
                    if (curWindowSize > maxWindowSize) {
                        maxWindowSize = curWindowSize;
                    }
                    right++;
                    if (right < nums.length) {
                        windowSum = windowSum + nums[right];
                    } else {
                        break;
                    }
                } else {
                    windowSum = windowSum - nums[left];
                    left++;
                }
            }

            return maxWindowSize;
        }
    }
}
