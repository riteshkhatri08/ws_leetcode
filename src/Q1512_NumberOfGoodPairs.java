import java.util.HashMap;

public class Q1512_NumberOfGoodPairs {

    public static void main(String[] args) {
        Q1512_NumberOfGoodPairs obj = new Q1512_NumberOfGoodPairs();
        int[] nums = new int[] { 1, 2, 3, 1, 1, 3 };
        System.out.println(obj.new Solution().numIdenticalPairs(nums));
    }

    class Solution {
        public int numIdenticalPairs(int[] nums) {
            int totalCount = 0;
            HashMap<Integer, Pair> numCount = new HashMap<Integer, Pair>();
            Pair current;
            for (int i = 0; i < nums.length; i++) {
                current = numCount.getOrDefault(nums[i], new Pair());
                current.count++;
                if (current.count == 1) {
                    numCount.put(nums[i], current);
                    continue;
                }
                if (current.count == 2) {
                    current.gp = 1;
                } else {
                    current.gp = current.gp + current.count - 1;
                }

            }

            for (Pair p : numCount.values()) {
                totalCount += p.gp;
            }

            return totalCount;

        }

    }

    class Pair {
        int gp;
        int count;

        public Pair() {
            this.gp = 0;
            this.count = 0;
        }

        public String toString() {
            return "[ gp=" + this.gp + ", count=" + this.count + "]";
        }
    }
}
