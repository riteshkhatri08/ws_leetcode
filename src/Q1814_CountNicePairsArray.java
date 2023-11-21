import java.util.HashMap;
import java.util.HashSet;

public class Q1814_CountNicePairsArray {
    public static void main(String[] args) {
        int[] nums = new int[] { 13, 10, 35, 24, 76, 13 };
        var result = new Q1814_CountNicePairsArray().new Solution().countNicePairs(nums);
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        HashMap<Integer, Integer> reverses = new HashMap<Integer, Integer>();

        public int countNicePairs(int[] nums) {

            int irev = 0;
            int jrev = 0;
            String temp = "";
            String temprev = "";
            long count = 0;
            HashSet<String> countmap = new HashSet<String>();

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {

                    temp = nums[i] + "_" + nums[j];
                    if (countmap.contains(temp)) {
                        count++;
                        continue;
                    }

                    irev = rev(nums[i]);
                    jrev = rev(nums[j]);
                    temprev = irev + "_" + jrev;
                    if (countmap.contains(temprev)) {
                        count++;
                        continue;
                    }

                    if ((nums[i] + jrev) == (nums[j] + irev)) {
                        count++;
                        countmap.add(temp);
                        countmap.add(temprev);
                    }
                }
            }
            return (int) (count % 1000000007L);
        }

        public int rev(int num) {
            if (reverses.containsKey(num)) {
                return reverses.get(num);
            }
            int temp = num;
            int numrev = 0;

            while (num > 0) {
                numrev = (numrev * 10) + num % 10;
                num = num / 10;
            }
            reverses.put(temp, numrev);
            reverses.put(numrev, temp);
            // System.out.println("rev(" +temp+") = " + numrev);
            return numrev;
        }
    }
}
