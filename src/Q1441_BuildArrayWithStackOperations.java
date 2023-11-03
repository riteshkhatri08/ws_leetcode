import java.util.ArrayList;
import java.util.List;

public class Q1441_BuildArrayWithStackOperations {

    public static void main(String[] args) {
        var obj = new Q1441_BuildArrayWithStackOperations();
        var result = obj.new Solution().buildArray(new int[] { 2, 3, 4, 6, 7, 9, 10, 12, 17, 19, 20, 21, 23, 25, 30 },
                30);
        System.out.println(result);

    }

    class Solution {
        public static final String PUSH = "Push";
        public static final String POP = "Pop";

        public List<String> buildArray(int[] target, int n) {

            ArrayList<String> operations = new ArrayList<String>();

            int prev = 0, diff = 0, i = 0, cur, x;

            for (i = 0; i < target.length; i++) {
                cur = target[i];
                diff = cur - prev - 1;

                for (x = 0; x < diff; x++) {
                    operations.add(PUSH);
                }
                for (x = 0; x < diff; x++) {
                    operations.add(POP);
                }

                operations.add(PUSH);
                prev = cur;
            }

            return operations;

        }
    }
}

// ps 1
// ps 2
// ps 3
// po 3
// po 2
// ps 4
// ps 5
// ps 6
// po 6
// po 5
// ps 7

// ["Push","Pop","Push","Push","Push","Push","Pop","Push","Push","Push","Pop","Push","Push","Push","Pop","Push","Push","Pop","Push","Pop","Push","Pop","Push","Pop","Push","Push","Pop","Push","Push","Push","Push","Pop","Push","Push","Pop","Push","Push","Pop","Push","Pop","Push","Pop","Push","Pop","Push"]