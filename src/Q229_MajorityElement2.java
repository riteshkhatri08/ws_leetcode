import java.util.ArrayList;
import java.util.List;

public class Q229_MajorityElement2 {

    public static void main(String[] args) {
        Q229_MajorityElement2 obj = new Q229_MajorityElement2();

        int[] nums = { 3, 3, 3, 12, 12, 12, 2, 2, 2, 1, 3 };
        System.out.println(obj.new Solution().majorityElement(nums));
    }

    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            List<Integer> majorityElements = new ArrayList<Integer>();

            // first iteration
            int counter = 1;
            int currentCandidate = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == currentCandidate) {
                    counter++;
                } else {
                    counter--;
                    if (counter == 0) {
                        System.out.println("RESET COUNTER  - "  + nums[i]);
                        // Reset counter to 1
                        counter = 1;
                        // Change candidate
                        currentCandidate = nums[i];
                    }
                }
            }
            System.out.println(currentCandidate);
            return null;
        }
    }
}
