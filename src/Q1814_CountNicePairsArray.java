import java.util.HashMap;
import java.util.Map;

public class Q1814_CountNicePairsArray {
    public static void main(String[] args) {
        int[] nums = new int[] { 13, 10, 35, 24, 76, 13 };
        var result = new Q1814_CountNicePairsArray().new Solution().countNicePairs(nums);
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        public int countNicePairs(int[] nums) {

            long count = 0;
            int temp = 0;
            Map<Integer, Integer> numcount = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int diff = nums[i] - rev(nums[i]);
                // System.out.println(nums[i]);
                // count = count + numcount.getOrDefault(nums[i] ,0) ;
                temp = numcount.getOrDefault(diff, 0);
                count = (count + temp) % 1000000007;
                numcount.put(diff, temp + 1);
                // if (numcount.containsKey(diffs[i])){
            }

            // for (int c : numcount.values()){
            // count = count + ( c * (c-1) / 2 );
            // }
            return (int) (count % 1000000007);
        }

        public int rev(int num) {
            int numrev = 0;

            while (num > 0) {
                numrev = (numrev * 10) + (num % 10);
                num = num / 10;
            }

            return numrev;
        }
    }

    // i + rev(j) = j + rev(i)
    // i - rev(i) + j - rev(j) = 0
}
