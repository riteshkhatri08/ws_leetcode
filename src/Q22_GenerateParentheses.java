import java.util.ArrayList;
import java.util.List;

public class Q22_GenerateParentheses {

    public static void main(String[] args) {
        var obj = new Q22_GenerateParentheses();
        int num = 3;
        List<String> result = obj.new Solution().generateParenthesis(num);
        System.out.println(result);

    }

    class Solution {

        List<String> currentRecordList = new ArrayList<String>();
        StringBuilder currentRecord = new StringBuilder("");

        public List<String> generateParenthesis(int n) {

            generate(n, n);

            return currentRecordList;

        }

        public void generate(int openCount, int closeCount) {
            // System.out.println("ENTRY" + currentRecord);

            // TERMINATION CONDITION FOR RECURSION
            if (closeCount == 0 && openCount == 0) {
                // System.out.println("TERMINATION - " + currentRecord);
                currentRecordList.add(currentRecord.toString());
                return;
                // return currentRecord;
            }

            if (openCount > 0) {
                // Open bracked
                currentRecord.append("(");
                // openCount--;
                // if (openCount != 0) {
                generate(openCount - 1, closeCount);
                currentRecord.deleteCharAt(currentRecord.length() - 1);
                // }
            }

            if (closeCount > openCount) {
                currentRecord.append(")");
                // closeCount--;
                generate(openCount, closeCount - 1);
                currentRecord.deleteCharAt(currentRecord.length() - 1);
                // total++;
            }

            // // System.out.println("MID" + currentRecord);
            // if (currentRecord.equals("(()")) {
            // System.out.println("PAUSE");
            // }

            // System.out.println("EXIT ----- " + currentRecord);
            //
            // return currentRecord;
        }
    }

}

/*
 * _ _ _ _ _ _
 * O O O C C C
 * _ _ _ _ _ _
 * O O O C C C
 * 
 * ())
 * 
 * /*
 * 
 * 
 * 1 - ()
 * 2 - ()(), (())
 * 3 - () () () , () (()) , (()) () , ((())) , (()())
 * 4 -
 * 
 * 
 * 
 * 
 * 
 * 
 */