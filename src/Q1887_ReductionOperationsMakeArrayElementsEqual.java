public class Q1887_ReductionOperationsMakeArrayElementsEqual {
    public static void main(String[] args) {

        // [7,9,10,8,6,4,1,5,2,3]
        int[] nums = new int[] { 1, 2, 2, 4, 2, 9, 3, 3, 2, 1, 5 };
        var result = new Q1887_ReductionOperationsMakeArrayElementsEqual().new Solution().reductionOperations(nums);
        System.out.println("ANSWER = " + result);

    }

    class Solution {

        public int reductionOperations(int[] nums) {

            int ops = 0;
            {
                int maxElement = 0;
                int[] bucket = new int[100001];
                for (int a : nums) {
                    if (a > maxElement) {
                        maxElement = a;
                    }
                    bucket[a]++;
                }
                nums = null;

                int prev = 0;
                while (maxElement > 0) {
                    if (bucket[maxElement] > 0) {
                        prev = prev + bucket[maxElement];
                        ops = ops + prev;
                    }
                    maxElement--;
                }
                ops = ops - prev;
                bucket = null;
            }
            // System.gc();
            return ops;
        }
    }
}
