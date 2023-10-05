import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q229_MajorityElement2 {

    public static void main(String[] args) {
        Q229_MajorityElement2 obj = new Q229_MajorityElement2();

        int[] nums = { 3, 3, 3, 12, 12, 12, 2, 2, 2, 1, 3 };
        System.out.println(obj.new Solution().majorityElement(nums));
    }

    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            int freq = (nums.length / 3) + 1;

            List<Integer> result = new ArrayList<Integer>();
            HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
            for (int a : nums) {

                countMap.put(a, countMap.getOrDefault(a, 0) + 1);
                if (countMap.get(a) == freq) {
                    result.add(a);
                    if (result.size() == 2) {
                        return result;
                    }
                }

            }
            return result;
        }
    }
}
