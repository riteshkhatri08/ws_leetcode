public class Q1887_ReductionOperationsMakeArrayElementsEqual {
    public static void main(String[] args) {

        // [7,9,10,8,6,4,1,5,2,3]
        int[] nums = new int[] { 1, 2, 2, 4, 2, 9, 3, 3, 2, 1, 5 };
        var result = new Q1887_ReductionOperationsMakeArrayElementsEqual().new Solution().reductionOperations(nums);
        System.out.println("ANSWER = " + result);

    }

    class Solution {

        public int reductionOperations(int[] nums) {

            int maxElement = 0;
            // int minElementWithCount = Integer.MAX_VALUE;

            // for (int a : nums) {
            // maxElement = maxElement < a ? a : maxElement;
            // minElementWithCount = a < minElementWithCount ? a : minElementWithCount;
            // }

            int[] bucket = new int[100001];
            for (int a : nums) {
                if (a > maxElement) {
                    maxElement = a;
                }
                bucket[a]++;
            }

            int prev = 0;
            int ops = 0;
            for (int i = maxElement; i > 0; i--) {
                if (bucket[i] > 0) {

                    prev = prev + bucket[i];
                    ops = ops + prev;

                }
            }
            ops = ops - prev;
            return ops;
        }
    }
}
