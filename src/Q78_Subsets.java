import java.util.ArrayList;
import java.util.List;

public class Q78_Subsets {

    public static void main(String[] args) {
        int nums[] = new int[] { 1, 2, 3 };

        System.out.println(new Q78_Subsets().new Solution().subsets(nums));

    }

    class Solution {

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> resultSet = new ArrayList<>();

            //! ArrayList to arraylist conversion are faster.. this is and optimizations
            setMaker(nums, 0, resultSet, new ArrayList<>());

            return resultSet;
        }

        public void setMaker(int[] nums, int current, List<List<Integer>> resultSet, ArrayList<Integer> list) {
            // System.out.println("List so far "+ set);
            // Take snapshot if reached end of choices
            if (current == nums.length) {
                // System.out.println("Adding " + set);
                resultSet.add(new ArrayList<>(list));
                // stack.push(nums[current]);
                // resultSet.add(new ArrayList<>(stack));
                // stack.pop();
                return;
            }

            // Not include current element in list so far
            setMaker(nums, current + 1, resultSet, list);

            // Include current element in list so far
            list.add(nums[current]);
            setMaker(nums, current + 1, resultSet, list);
            list.remove(list.size() - 1);

        }
    }
}