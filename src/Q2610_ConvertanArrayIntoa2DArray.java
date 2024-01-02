import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q2610_ConvertanArrayIntoa2DArray {

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4, 5, 3, 21, 2, 3, 4, 1, 12, 3, 11, 2, 3, 4 };

        var result = new Q2610_ConvertanArrayIntoa2DArray().new Solution().findMatrix(nums);
        System.out.println(result);
    }

    class Solution {
        public List<List<Integer>> findMatrix(int[] nums) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            List<HashSet<Integer>> setList = new ArrayList<HashSet<Integer>>();
            boolean flag = true;
            for (int a : nums) {
                flag = true;
                System.out.println("set" + setList);
                System.out.println("res" + result);
                System.out.println("NUM = " + a);
                for (int i = 0; i < setList.size(); i++) {
                    if (!setList.get(i).contains(a)) {
                        setList.get(i).add(a);
                        result.get(i).add(a);
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    HashSet<Integer> set = new HashSet<Integer>();
                    set.add(a);
                    setList.add(set);
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(a);
                    result.add(list);

                }
            }

            return result;
        }
    }

}
