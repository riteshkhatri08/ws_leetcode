import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q498_DiagonalTraverse {

    public static void main(String[] args) {
        var result = new Q498_DiagonalTraverse().new Solution().findDiagonalOrder(null);
    }

    class Solution {
        public int[] findDiagonalOrder(int[][] mat) {

            int maxColumn = 0;
            HashMap<Integer, List<Integer>> diagonals = new HashMap<Integer, List<Integer>>();
            int sum = 0;
            for (int i = 0; i < mat.length; i++) {

                for (int j = 0; j < mat[i].length; j++) {
                    sum = i + j;
                    List<Integer> temp = diagonals.get(sum);
                    if (temp == null) {
                        temp = new ArrayList<Integer>();
                        diagonals.put(sum, temp);
                    }
                    temp.add(mat[i][j]);
                }
            }
            // System.out.println(diagonals);
            int answer[] = new int[mat.length * mat[0].length];
            int count = 0;
            // true for left to right
            boolean flag = true;
            for (List<Integer> list : diagonals.values()) {
                if (flag) {

                    for (int i = list.size() - 1; i > -1; i--) {
                        answer[count++] = list.get(i);
                    }
                    flag = false;
                } else {

                    for (int i : list) {
                        answer[count++] = i;
                    }

                    flag = true;
                }
            }
            return answer;
        }
    }

}
