import java.util.HashMap;

public class Q50_Pow {
    public static void main(String[] args) {
        var result = new Q50_Pow().new Solution().myPow(2, -2147483648);
        System.out.println("RESULT = " + result);

    }

    class Solution {
        HashMap<Double, Double> memory = new HashMap<Double, Double>(20);
        {
            memory.put(0.0, 1.0);
        }

        public double myPow(double x, int y) {
            double n = (double) y;
            if (n < 0) {
                x = 1 / x;
                n = -1 * n;
            }
            memory.put(1.0, x);
            return pow(x, n);
        }

        private double pow(double x, double n) {
            if (memory.containsKey(n)) {
                return memory.get(n);
            }

            // System.out.println("new n = " + n / 2);
            double res = pow(x, (int) n / 2) * pow(x, (int) n / 2);
            if (n % 2 == 1) {
                res = x * res;
            }
            memory.put(n, res);

            return res;

        }
    }
}
