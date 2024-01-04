import java.util.HashMap;

public class Q2870_MinimumNoOfOPerationsToMakeAnArrayEmpty {
    public static void main(String[] args) {
        int arr[] = new int[] { 14, 12, 14, 14, 12, 14, 14, 12, 12, 12, 12, 14, 14, 12, 14, 14, 14, 12, 12 };
        var result = new Q2870_MinimumNoOfOPerationsToMakeAnArrayEmpty().new Solution().minOperations(arr);
        System.out.println("ANSWER " + result);
    }

    class Solution {

        public int minOperations(int[] nums) {
            int res = 0, mod23 = 0;
            HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();

            for (int a : nums) {
                count.put(a, count.getOrDefault(a, 0) + 1);
            }
            // System.out.println(count);
            for (int value : count.values()) {
                mod23 = value % 3;

                switch (mod23) {
                    case 0: {
                        res += (value / 3);
                        break;
                    }
                    case 2: {
                        res += ((value / 3) + 1);
                        break;
                    }
                    case 1: {

                        if (value == 4) {
                            res += 2;
                        } else if (value == 1) {
                            return -1;
                        } else {
                            res += ((value / 3) + 1);
                        }
                        break;
                    }
                }

            }

            return res;
        }
    }

}
