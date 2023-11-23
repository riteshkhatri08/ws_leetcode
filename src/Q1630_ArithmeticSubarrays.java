import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1630_ArithmeticSubarrays {
    public static void main(String[] args) {
        var result = new Q1630_ArithmeticSubarrays().new Solution().checkArithmeticSubarrays(null, null, null);
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
            int left = 0;
            int right = 0;
            int subarr[];
            List<Boolean> answers = new ArrayList<Boolean>();
            for (int i = 0; i < l.length; i++) {
                left = l[i];
                right = r[i];
                // ArrayList<Integer> sublist = new ArrayList<Integer>();
                subarr = new int[right - left + 1];
                int index = 0;
                for (int j = left; j <= right; j++) {
                    subarr[index++] = nums[j];
                }
                Arrays.sort(subarr);
                int diff = subarr[1] - subarr[0];
                boolean result = true;
                for (int j = 2; j < subarr.length; j++) {
                    if ((subarr[j] - subarr[j - 1]) != diff) {
                        result = false;
                        break;
                    }
                }
                answers.add(result);
            }
            return answers;
        }
    }

}
