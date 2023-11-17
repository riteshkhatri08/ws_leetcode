import java.util.Arrays;

public class Q1877_MinimizeMaximumPairSumArray {
    public static void main(String[] args) {
        var result = new Q1877_MinimizeMaximumPairSumArray().new Solution().minPairSum(new int[] { 3, 5, 4, 2, 4, 6 });
        System.out.println("ANSWER " + result);
    }

    class Solution {
        public int minPairSum(int[] nums) {
           
           int maxNum = 0;
           for (int a: nums)
            maxNum = a < maxNum? maxNum : a;
    
            byte [] counts =  new byte [maxNum+1];
    
            // count appearance of each num
            for (int a : nums)
                counts[a] ++;
    
            int maxPairSum = 0;
            int left = 0;
            int right = maxNum;
            while (counts[++left] == 0)  { }
    
            while(left<=right){
                maxPairSum = Math.max(maxPairSum,left+right);
                if (counts[left] == counts[right]){
                    while (counts[++left] == 0)  { }
                    while (counts[--right] == 0)  { }
                } else if (counts[left] < counts[right]) {
                    counts[right] -= counts[left];
                    while (counts[++left] == 0)  { }
                } else {
                    counts[left] -= counts[right];
                    while (counts[--right] == 0)  { }
                }
            }
            return maxPairSum;
        }
    }
}
