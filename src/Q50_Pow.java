public class Q50_Pow {
    public static void main(String[] args) {
        var result = new Q50_Pow().new Solution().myPow(2, -2147483648);
        System.out.println("RESULT = " + result);

    }

    class Solution {
        // HashMap<Long, Double> memory = new HashMap<Long, Double>(20);
        // {
        // memory.put(0L, 1.0);
        // }

        public double myPow(double x, long n) {

            if (n < 0) {
                x = 1 / x;
                n = -1 * n;
            }
            // memory.put(1L, x);
            return pow(x, n);
        }

        private double pow(double x, long n) {
            if (n == 0) {
                return 1;
            }

            if (n == 1) {
                return x;
            }
            // if (memory.containsKey(n)) {
            // return memory.get(n);
            // }

            // System.out.println("new n = " + n / 2);
            double res = pow(x, n / 2);

            if (n % 2 == 1) {
                res = x * res * res;
            } else {
                res = res * res;
            }

            // memory.put(n, res);

            return res;

        }
    }
}
