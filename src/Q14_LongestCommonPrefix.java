public class Q14_LongestCommonPrefix {

    public static void main(String[] args) {
        var obj = new Q14_LongestCommonPrefix();
        String[] arr = new String[] { "flower", "flow", "flight" };

        String res = obj.new Solution().longestCommonPrefix(arr);
        System.out.println(res);

    }

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String commonSoFar = strs[0], current = "";
            // char [] commonSoFar = strs[0].toCharArray();
            // char [] 


            for (int i = 1; i < strs.length; i++) {

                if (commonSoFar.length() > strs[i].length()) {
                    current = commonSoFar;
                    commonSoFar = strs[i];
                } else {
                    current = strs[i];
                }
                // System.out.println(commonSoFar + " = " + current);
                String temp = "";
                for (int j = 0; j < commonSoFar.length(); j++) {
                    // System.out.println("Comparing - " + current.charAt(j) +" , "+
                    // commonSoFar.charAt(j) );
                    if (current.charAt(j) == commonSoFar.charAt(j)) {

                        temp = temp + current.charAt(j);
                        // System.out.println("temp = " + temp);
                    } else {
                        if (temp.equals("")) {
                            return temp;
                        }
                        commonSoFar = temp;
                        // System.out.println("done comapring " + current + " , " +commonSoFar);
                        // System.out.println("temp = " + temp);
                        break;
                    }
                }
            }

            return commonSoFar;
        }
    }
}