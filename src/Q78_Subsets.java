import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q78_Subsets {

    public static void main(String[] args) {
        int nums[] = new int[] { 1, 2, 3 };

        System.out.println(new Q78_Subsets().new Solution().subsets(nums));

    }

    class Solution {

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> resultSet = new ArrayList<>();

            setMaker(nums, 0, resultSet, new Stack<>());

            return resultSet;
        }

        public void setMaker(int[] nums, int current, List<List<Integer>> resultSet, Stack<Integer> stack) {
            // System.out.println("List so far "+ set);
            // Take snapshot if reached end of choices
            if (current == nums.length) {
                // System.out.println("Adding " + set);
                resultSet.add(new ArrayList<>(stack));
                // stack.push(nums[current]);
                // resultSet.add(new ArrayList<>(stack));
                // stack.pop();
                return;
            }

            // Not include current element in list so far
            setMaker(nums, current + 1, resultSet, stack);

            // Include current element in list so far
            stack.push(nums[current]);
            setMaker(nums, current + 1, resultSet, stack);
            stack.pop();

        }
    }
}