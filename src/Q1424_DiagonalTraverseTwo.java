import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Q1424_DiagonalTraverseTwo {
    public static void main(String[] args) {
        var result = new Q1424_DiagonalTraverseTwo().new Solution().findDiagonalOrder(null);
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        public int[] findDiagonalOrder(List<List<Integer>> nums) {

            int maxColumn = 0;
            int count = 0;
            LinkedHashMap<Integer, List<Integer>> diagonals = new LinkedHashMap<Integer, List<Integer>>();
            int sum = 0;
            for (int i = 0; i < nums.size(); i++) {
                maxColumn = nums.get(i).size();
                count += maxColumn;
                for (int j = 0; j < maxColumn; j++) {
                    sum = i + j;
                    List<Integer> temp = diagonals.get(sum);
                    if (temp == null) {
                        temp = new ArrayList<Integer>();
                        diagonals.put(sum, temp);

                    }
                    temp.add(nums.get(i).get(j));
                }
            }
            // System.out.println(diagonals);
            int answer[] = new int[count];
            count = 0;
            for (List<Integer> list : diagonals.values()) {
                for (int i = list.size() - 1; i > -1; i--) {
                    answer[count++] = list.get(i);
                }
            }
            return answer;
        }
    }
}
