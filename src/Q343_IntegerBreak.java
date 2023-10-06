public class Q343_IntegerBreak {

    public static void main(String[] args) {
        var obj = new Q343_IntegerBreak();
        int num = 13;
        System.out.println(obj.new Solution().integerBreak(num));
    }

    class Solution {

        // HashMap<Integer,Integer> maximums = new HashMap<Integer,Integer>();
        int[] prevResults;
        // public Solution(){
        // maximums.put(2,1);
        // maximums.put(3,2);
        // }

        public int integerBreak(int n) {
            prevResults = new int[3 + n];
            int result = 0;
            prevResults[2] = 1;
            prevResults[3] = 2;
            if (prevResults[n] != 0) {
                return prevResults[n];
                // if (n == 2){
                // return 1;
                // } else if (n == 3){
                // return 2;
            } else {

                int div = 2;
                int quo, rem;
                double current, max = 0;

                for (; div < n; div++) {
                    quo = n / div;
                    rem = n - (div * quo);
                    if (rem == 1) {
                        // System.out.println("BEFORE " + rem + "," + quo + "," + div);
                        quo--;
                        rem = rem + div;
                        // System.out.println("AFTER " + rem + "," + quo + "," + div);
                    }
                    current = rem == 0 ? Math.pow(div, quo) : Math.pow(div, quo) * rem;
                    max = current > max ? current : max;
                }
                result = (int) max;
                prevResults[n] = result;

            }

            return result;

        }

    }
}

// 15 - = 243

// 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
// 2^8 + 1
// 3

// 1,1,1,1,1,1,1,1,1,1,1,1,1,2
// 1,1,1,2,2,2,2,2,2
